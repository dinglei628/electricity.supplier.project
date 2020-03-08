package com.zb.service;

import com.zb.dto.Dto;
import com.zb.entity.User;

public interface UserService {

    Dto UpdateUserInfo(User newUser);
    Integer updatePirSrc(String src,String id);
}
