package com.zb.service;

import org.springframework.beans.factory.annotation.Autowired;

public interface UserRegisterService {

    /**
     * 发送验证码
     *
     * @param phoneNumber 手机好吗
     * @return
     */
    void sendCode(String phoneNumber);


}
