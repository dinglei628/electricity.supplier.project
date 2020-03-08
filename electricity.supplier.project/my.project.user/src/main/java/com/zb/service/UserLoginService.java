package com.zb.service;

import com.zb.dto.Dto;

public interface UserLoginService {
    /**
     * 登录
     * @return
     */
    Dto login(String phone, String pwd);

}
