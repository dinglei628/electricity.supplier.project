package com.demo.mapper;

import com.demo.entity.History;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HistoryMapper {

    Integer addHistory(History history);

    List<History> getHisOrderByUserId(@Param("uId")String uId,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

    Integer getHisOrderByUserIdCount(@Param("uId")String uId);
}
