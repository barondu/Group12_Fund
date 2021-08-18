package com.citi.fund.model;

import lombok.Data;

import java.util.Date;


/**
 * create by Cunzhen Zheng
 */
@Data
public class Position {
    private String id;
    private String positionId;
    private String securityId;
    private int quantity;
    private Date datePurchased;
    private String fundId;

}
