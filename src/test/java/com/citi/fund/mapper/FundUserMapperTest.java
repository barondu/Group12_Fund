//package com.citi.fund.mapper;
//
//import com.citi.fund.model.FundUser;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//class FundUserMapperTest {
//
//    @Autowired
//    FundUserMapper fundUserMapper;
//
//    @Test
//    void selectByFundUser() {
//        List<FundUser> fdus = fundUserMapper.selectByFundUser(new FundUser());
//        fdus.forEach(fdu -> System.out.println(fdu));
//    }
//
//    @Test
//    void selectByFundId() {
//        System.out.println(fundUserMapper.selectFundUserByFundId("f1001"));
//    }
//
//    @Test
//    void create() {
//        FundUser fu = new FundUser();
//        fu.setFundId("f1001");
//        fu.setEmail("1961801757@qq.com");
//        fu.setEmployeeId("citi1004");
//        fundUserMapper.createFundUser(fu);
//    }
//
//    @Test
//    void deletById() {
//        fundUserMapper.deletFundUserById(1);
//    }
//}