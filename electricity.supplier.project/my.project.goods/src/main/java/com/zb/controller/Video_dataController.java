package com.zb.controller;

import com.zb.pojo.Video_data;
import com.zb.service.Video_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Video_dataController {

    @Autowired
    Video_dataService video_dataService;


    @RequestMapping("getById/{id}/{pageSize}")
    public Video_data getById(@PathVariable("id")Integer id, @PathVariable("pageSize") Integer pageSize){
        //根据商品编号查询商品
        Video_data byVideoTypeId = video_dataService.getByVideoId(id,pageSize);
        return byVideoTypeId;
    }

}
