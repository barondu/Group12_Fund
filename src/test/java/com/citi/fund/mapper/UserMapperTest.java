package com.citi.fund.mapper;

import com.citi.fund.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

//    @Test
//    void selectByUser() {
//       List<User> us=userMapper.selectByUser(new User());
//       us.forEach(u-> System.out.println(u));
//    }
//
//    @Test
//    void selectUserByEmployeeId() {
//        User u=userMapper.selectUserByEmployeeId("citi1001");
//        System.out.println(u);
//
//    }
//
//    @Test
//    void queryEmployeeByEmail() {
//        String employeeId=userMapper.queryEmployeeByEmail("1961801757@qq.com");
//        System.out.println(employeeId);
//    }
//
//    @Test
//    void selectUserByEmail() {
//        User u=userMapper.selectUserByEmail("1961801757@qq.com");
//        System.out.println(u);
//    }
//
//    @Test
//    void createUser() {
//        User u=new User();
//        u.setEmail("1512113534@qq.com");
//        u.setPassword("1234567896");
//        u.setEmployeeId("citi1045");
//        u.setFirstName("ciri");
//        u.setLastName("allen");
//        u.setIsManager(1);
//        userMapper.createUser(u);
//    }


}