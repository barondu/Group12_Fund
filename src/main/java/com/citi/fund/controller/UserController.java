package com.citi.fund.controller;


import com.citi.fund.common.ApiResponse;
import com.citi.fund.common.ServiceResult;
import com.citi.fund.model.Fund;
import com.citi.fund.model.FundDetail;
import com.citi.fund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;



/**
 * create by Bairui Du
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //查找所有基金
    @GetMapping("user/allFund")
    public ApiResponse showAllFund() {
        ServiceResult<List<Fund>> result = userService.showAllFunds();
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
    }

    //    查询单个基金详情
    @GetMapping("user/fundDetail/{fundId}")
    public ApiResponse showFundDetail(@PathVariable("fundId") String fundId) {
        ServiceResult<FundDetail> result = userService.showFundDetail(fundId);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofMessage(ApiResponse.Status.NOT_FOUND.getCode(), result.getMessage());
        }
    }

    //    查询个人已购基金
    @GetMapping("user/personalFund")
    public ApiResponse showPersonalFund(HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        ServiceResult<List<Fund>> result = userService.showPersonalFund(email);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofMessage(ApiResponse.Status.NOT_FOUND.getCode(), result.getMessage());
        }
    }

    //用户购买基金
    @PostMapping("user/buyFund/{fundId}")
    public ApiResponse buyFund(@PathVariable("fundId") String fundId, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("userEmail");
        ServiceResult result = userService.buyFund(fundId, email);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    //用户卖出基金
    @PostMapping("user/sellFund/{fundId}")
    public ApiResponse sellFund(@PathVariable("fundId") String fundId, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("userEmail");
        ServiceResult result = userService.sellFund(fundId, email);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

}
