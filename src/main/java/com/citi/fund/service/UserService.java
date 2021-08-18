package com.citi.fund.service;

import com.citi.fund.common.ServiceResult;
import com.citi.fund.mapper.FundMapper;
import com.citi.fund.mapper.FundUserMapper;
import com.citi.fund.mapper.PositionMapper;
import com.citi.fund.mapper.UserMapper;
import com.citi.fund.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * create by Bairui Du
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FundMapper fundMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    FundUserMapper fundUserMapper;


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
        FundUser fu = new FundUser();
        fu.setEmail(email);
        List<FundUser> fus = fundUserMapper.selectByFundUser(fu);
        if (fus.isEmpty()) {
            return ServiceResult.notFound();
        }
        List<Fund> result = new ArrayList<>();
        fus.forEach(f -> result.add(fundMapper.selectFundByFundId(f.getFundId())));
        return ServiceResult.of(result);
    }


    public ServiceResult buyFund(String fundId, String email) {
        FundUser fu = fundUserMapper.selectFundUserByFundId(fundId);
        if (fu != null) {
//            用户已经购买了该基金
            return ServiceResult.alreadyExist();
        }

        String employeeId = fundMapper.queryEmployeeByFundId(fundId);
        FundUser newfu = new FundUser();
        newfu.setEmail(email);
        newfu.setFundId(fundId);
        newfu.setEmployeeId(employeeId);
        fundUserMapper.createFundUser(newfu);

        return ServiceResult.success();

    }

    public ServiceResult sellFund(String fundId, String email) {
        FundUser fu = new FundUser();
        fu.setFundId(fundId);
        fu.setEmail(email);
        List<FundUser> fus = fundUserMapper.selectByFundUser(fu);
        if (fus.isEmpty()) {
//            用户没有购买该基金，无法卖出
            return ServiceResult.notExist();
        }
        fundUserMapper.deletFundUserById(fus.get(0).getId());
        return ServiceResult.success();
    }

    public ServiceResult create(User user) {
        User u = userMapper.selectUserByEmail(user.getEmail());
        if (u != null) {
            return ServiceResult.alreadyExist();
        }
        userMapper.createUser(user);
        return ServiceResult.success();
    }

    public ServiceResult<List<Fund>> showAllFunds() {
        Fund fd = new Fund();
        List<Fund> fds = fundMapper.selectByFund(fd);
        if (fds.isEmpty()) {
            return ServiceResult.notFound();
        }
        return ServiceResult.of(fds);
    }
}
