//package com.citi.fund.mapper;
//
//import com.citi.fund.model.Fund;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.util.Assert;
//
//import java.util.List;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//class FundMapperTest {
//    @Autowired
//    private FundMapper fundMapper;
//
//    @Test
//    void selectByFund() {
//        List<Fund> fds=fundMapper.selectByFund(new Fund());
//        fds.forEach(fd-> System.out.println(fd));
//    }
//
//    @Test
//    void selectByFundId() {
//        Fund fund=fundMapper.selectFundByFundId("f1001");
//        System.out.println(fund);
//    }
//
//    @Test
//    void queryEmployeeByFundId() {
//       String employeeId= fundMapper.queryEmployeeByFundId("f1001");
//        System.out.println(employeeId);
//    }
//
//    @Test
//    void selectByEmployeeId() {
//        System.out.println(fundMapper.selectFundByEmployeeId("citi1001"));
//    }
//
//    @Test
//    void createFund() {
//        Fund fd=new Fund();
//        fd.setFundId("f1007");
//        fd.setEmployeeId("citi1008");
//        fd.setName("global growth");
//        fundMapper.createFund(fd);
//    }
//
//    @Test
//    void deleteFundByFundId() {
//        fundMapper.deleteFundByFundId("f1007");
//    }
//}