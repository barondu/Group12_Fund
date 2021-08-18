package com.citi.fund.controller;

import com.citi.fund.common.ApiResponse;
import com.citi.fund.common.ServiceResult;
import com.citi.fund.mapper.UserMapper;
import com.citi.fund.model.User;
import com.citi.fund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * create by Rui Zhang
 */
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("homePage")
    public String homePage() {
        return "Citi Fund Management Organization";
    }

    @PostMapping("signin")
    public ApiResponse signin(String email, String password, HttpServletRequest request) {
        User user = userMapper.selectUserByEmail(email);
        if (user.getPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userEmail", email);
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofMessage(4001, "username or password is not correct");
        }
    }

    @PostMapping("signup")
    public ApiResponse signup(@RequestBody User user) {
        ServiceResult result = userService.create(user);
        if (result.isSuccess()) {
            return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
        } else {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }
    }

    @RequestMapping("logout")
    public ApiResponse logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return ApiResponse.ofStatus(ApiResponse.Status.SUCCESS);
    }

    @RequestMapping("loginError")
    public ApiResponse loginError() {
        return ApiResponse.ofMessage(40000, "you must login first");
    }

}
