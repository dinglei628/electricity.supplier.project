package com.zb.controller;

import com.zb.dto.Dto;
import com.zb.entity.Curriculum;
import com.zb.entity.User;
import com.zb.service.CurriculumService;
import com.zb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    CurriculumService curriculumService;

    @RequestMapping("changeInfo")
    public Dto changeInfo(User user) {
        Dto dto = userService.UpdateUserInfo(user);
        return dto;
    }


    @RequestMapping("curr")
    public Dto<List<Curriculum>> getCurriculum(String token, Integer pageIndex) {
        return curriculumService.findCurriclumByUserId(token, pageIndex);
    }
}

