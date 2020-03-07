package com.zb.controller;

import com.zb.mapper.GoodMapper;
import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import com.zb.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodController {

    @Autowired(required = false)
    GoodService goodService;
    @Autowired
    GoodMapper goodMapper;


    @GetMapping("show/{id}/{pageSize}")
    public Video_data show(@PathVariable("id")Integer id,@PathVariable("pageSize")Integer pageSize){
        Video_data videoById = goodService.getVideoById(id, pageSize);
        System.out.println(videoById+"aaaaaaaaaaaa");
        return videoById;
    }


    public List<Videoaddress> videoList(@PathVariable("videoTypeId")Integer videoTypeId){
        return goodService.getVideoAddRess(videoTypeId);
    }

}
