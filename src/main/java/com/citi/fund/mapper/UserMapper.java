package com.citi.fund.mapper;

import com.citi.fund.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    List<User> selectByUser(@Param("user") User user);

    User selectUserByEmployeeId(@Param("employeeId") String employeeId);

    String queryEmployeeByEmail(@Param("email") String email);

    User selectUserByEmail(@Param("email") String email);

    void createUser(@Param("user") User user);
}
