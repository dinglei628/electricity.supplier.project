package com.zb.mapper;

import com.zb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    Integer addUserByPhone(User user);

    User getUserByPhone(String phone);

    Integer updateUserInfoByPhone(User user);

    Integer updatePirSrc(@Param("src") String src, @Param("id") String id);


}