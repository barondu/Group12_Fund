package com.citi.fund.service;


import com.citi.fund.common.ServiceResult;
import com.citi.fund.mapper.FundMapper;
import com.citi.fund.mapper.FundUserMapper;
import com.citi.fund.mapper.PositionMapper;
import com.citi.fund.mapper.UserMapper;
import com.citi.fund.model.Fund;
import com.citi.fund.model.FundDetail;
import com.citi.fund.model.Position;
import com.citi.fund.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * create by Kaiyi Liu
 */
@Service
public class ManagerService {


    @Autowired
    private FundMapper fundMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FundUserMapper fundUserMapper;

    public ServiceResult<List<Fund>> showAllFunds() {
        Fund fd = new Fund();
        List<Fund> fds = fundMapper.selectByFund(fd);
        if (fds.isEmpty()) {
            return ServiceResult.notFound();
        }
        return ServiceResult.of(fds);
    }


    public ServiceResult<FundDetail> showFundDetail(String fundId) {
        Fund fd = fundMapper.selectFundByFundId(fundId);
        if (fd == null) {
            return ServiceResult.notFound();
        }

        Position p = new Position();
        p.setFundId(fundId);
        List<Position> ps = positionMapper.selectByPosition(p);
        String employeeId = fd.getEmployeeId();
        User employee = userMapper.selectUserByEmployeeId(employeeId);

        FundDetail fdetail = new FundDetail();
        fdetail.setUser(employee);
        fdetail.setPositions(ps);
        return ServiceResult.of(fdetail);
    }

    public ServiceResult<List<Fund>> showPersonalFund(String email) {
        String employeeId = userMapper.queryEmployeeByEmail(email);
        if (employeeId == null) {
            return ServiceResult.notFound();
        }
        List<Fund> fds = fundMapper.selectFundByEmployeeId(employeeId);
        if (fds.isEmpty()) {
            return ServiceResult.notFound();
        }
        return ServiceResult.of(fds);
    }

    public ServiceResult createFund(Fund fund) {
        Fund fd = fundMapper.selectFundByFundId(fund.getFundId());
        if (fd != null) {
            return ServiceResult.alreadyExist();
        }
        fundMapper.createFund(fund);
        return ServiceResult.success();
    }

    public ServiceResult deleteFund(String fundId) {
        Fund f = fundMapper.selectFundByFundId(fundId);
        if (f == null) {
            return ServiceResult.notFound();
        }
        fundMapper.deleteFundByFundId(fundId);
        List<Position> ps = positionMapper.selectPositionByFundId(fundId);
        if (!ps.isEmpty()) {
            positionMapper.deletePositionByFundId(fundId);
        }
        return ServiceResult.success();
    }

    public ServiceResult addPosition(Position position) {
        Position p = positionMapper.selectPositionByPositionId(position.getPositionId());
        if (p != null) {
            return ServiceResult.alreadyExist();
        }
        positionMapper.createPosition(position);
        return ServiceResult.success();
    }

    public ServiceResult deletePosition(String positionId) {
        Position p = positionMapper.selectPositionByPositionId(positionId);
        if (p == null) {
            return ServiceResult.notExist();
        }
        positionMapper.deletePositionByPositionId(positionId);
        return ServiceResult.success();
    }
}
