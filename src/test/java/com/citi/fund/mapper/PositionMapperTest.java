package com.citi.fund.mapper;

import com.citi.fund.model.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PositionMapperTest {

    @Autowired
    private PositionMapper positionMapper;

//    @Test
//    void selectByPosition() {
//        List<Position> ps = positionMapper.selectByPosition(new Position());
//        ps.forEach(p -> System.out.println(p));
//    }
//
//    @Test
//    void selectPositionByFundId() {
//        List<Position> ps = positionMapper.selectPositionByFundId("f1004");
//        ps.forEach(p -> System.out.println(p));
//
//    }
//
//    @Test
//    void deleteByfundId() {
//        positionMapper.deletePositionByFundId("f1009");
//    }
//
//    @Test
//    void selectByPositionId() {
//        System.out.println(positionMapper.selectPositionByPositionId("p1001"));
//    }
//
//    @Test
//    void create() {
//        Position ps=new Position();
//        ps.setFundId("f1009");
//        ps.setPositionId("p1050");
//        long time = System.currentTimeMillis();
//        Date date = new Date(time);
//        ps.setDatePurchased(date);
//        ps.setQuantity(100);
//        ps.setSecurityId("netease");
//        positionMapper.createPosition(ps);
//    }
//
//    @Test
//    void deleteByPositionId() {
//        positionMapper.deletePositionByPositionId("p1050");
//    }
//
//    @Test
//    void deleteByFundId() {
//        positionMapper.deletePositionByFundId("f1009");
//    }
}