package com.citi.fund.mapper;

import com.citi.fund.model.Fund;
import com.citi.fund.model.FundUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FundUserMapper {

    List<FundUser> selectByFundUser(@Param("fundUser") FundUser fundUser);

    FundUser selectFundUserByFundId(@Param("fundId") String fundId);

    void createFundUser(@Param("fundUser") FundUser newfu);

    void deletFundUserById(@Param("id") int id);
}
