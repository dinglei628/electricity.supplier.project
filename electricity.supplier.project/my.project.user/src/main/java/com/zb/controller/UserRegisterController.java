package com.zb.controller;

import com.zb.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    @Autowired
    UserRegisterService userRegisterService;

    @RequestMapping("/sendCode/{phoneNumber}")
    public String sendCode(@PathVariable("phoneNumber") String phoneNumber) {
        userRegisterService.sendCode(phoneNumber);
        return "ok";
    }
}
