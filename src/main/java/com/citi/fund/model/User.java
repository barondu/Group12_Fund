package com.citi.fund.model;

import lombok.Data;


/**
 * create by Cunzhen Zheng
 */
@Data
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int isManager;
    private String EmployeeId;

}
