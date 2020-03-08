package com.zb.controller;

import com.zb.dto.Dto;
import com.zb.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    @Autowired
    UserRegisterService userRegisterService;

    @RequestMapping("/sendCode/{phone}")
    public String sendCode(@PathVariable("phone") String phoneNumber) {
        userRegisterService.sendCode(phoneNumber);
        return "ok";
    }

    @RequestMapping("/register")
    public Dto sendCode(String phone, String pwd, String code) {
        return userRegisterService.register(phone, pwd, code);
    }
}
