package com.demo.mapper;

import com.demo.entity.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayMapper {

    Integer getPayByOrderId(@Param("id") String id);

    Integer getPayByOrderIdAndStatus(@Param("id")String id,@Param("status") String status);

    Integer addPay(Pay pay);

    Integer updatePayInfo(@Param("status") String status,@Param("mentDate") String mentDate,@Param("id") String id);
}
