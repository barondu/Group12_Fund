package com.citi.fund.mapper;

import com.citi.fund.model.Fund;
import com.citi.fund.model.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PositionMapper {

    List<Position> selectByPosition(@Param("position") Position p);

    List<Position> selectPositionByFundId(@Param("fundId") String fundId);

    void deletePositionByFundId(@Param("fundId") String fundId);

    Position selectPositionByPositionId(@Param("positionId") String positionId);

    void createPosition(@Param("position") Position position);

    void deletePositionByPositionId(@Param("positionId") String positionId);
}
