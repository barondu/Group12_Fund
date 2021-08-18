package com.citi.fund.controller;


import com.citi.fund.common.ApiResponse;
import com.citi.fund.common.ServiceResult;
import com.citi.fund.model.Fund;
import com.citi.fund.model.FundDetail;
import com.citi.fund.model.Position;
import com.citi.fund.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * create by Kaiyi Liu
 */
@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    //查询所有基金
    @GetMapping("manager/allFunds")
    public ApiResponse showAllFunds() {
        ServiceResult<List<Fund>> result = managerService.showAllFunds();
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
    }

    //查询单个基金详情
    @GetMapping("manager/fundDetail/{fundId}")
    public ApiResponse showFundDetail(@PathVariable("fundId") String fundId) {
        ServiceResult<FundDetail> result = managerService.showFundDetail(fundId);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
    }

    //查询自己管理的基金
    @GetMapping("manager/personalFund")
    public ApiResponse showPersonalFund(HttpServletRequest request) {
        HttpSession session=request.getSession(true);
        String email = (String) session.getAttribute("userEmail");
        ServiceResult<List<Fund>> result = managerService.showPersonalFund(email);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofMessage(ApiResponse.Status.NOT_FOUND.getCode(), result.getMessage());
        }
    }

    //管理员创建新基金
    @PostMapping("manager/createFund")
    public ApiResponse createFund(@RequestBody Fund fund) {
        ServiceResult result = managerService.createFund(fund);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    @DeleteMapping("manager/delete/{fundId}")
    public ApiResponse deleteFund(@PathVariable("fundId") String fundId) {
        ServiceResult result = managerService.deleteFund(fundId);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    @PostMapping("manager/addPosition")
    public ApiResponse addPosition(@RequestBody Position position) {
        ServiceResult result = managerService.addPosition(position);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    @DeleteMapping("manager/deletePosition/{positionId}")
    public ApiResponse deletePosition(@PathVariable("positionId") String positionId) {
        ServiceResult result = managerService.deletePosition(positionId);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

}
