package com.citi.fund.model;

import lombok.Data;

import java.util.List;


/**
 * create by Cunzhen Zheng
 */
@Data
public class FundDetail {
    private User user;
    private List<Position> positions;

}
