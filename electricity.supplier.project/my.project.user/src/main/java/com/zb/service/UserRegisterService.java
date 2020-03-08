package com.zb.service;

import com.zb.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserRegisterService {

    /**
     * 发送验证码
     *
     * @param phoneNumber 手机好吗
     * @return
     */
    void sendCode(String phoneNumber);

    /**
     * 注冊
     *
     * @param phone
     * @param code
     * @return
     */
    Dto register(String phone, String pwd, String code);


}
