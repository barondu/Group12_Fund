package com.citi.fund.mapper;


import com.citi.fund.model.Fund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FundMapper {
    List<Fund> selectByFund(@Param("fund") Fund fund);

    Fund selectFundByFundId(@Param("fundId") String fundId);

    String queryEmployeeByFundId(@Param("fundId") String fundId);

    List<Fund> selectFundByEmployeeId(@Param("employeeId") String employeeId);

    void createFund(@Param("fund") Fund fund);

    void deleteFundByFundId(@Param("fundId") String fundId);
}
