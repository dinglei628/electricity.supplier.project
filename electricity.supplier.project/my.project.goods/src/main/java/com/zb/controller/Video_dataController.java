package com.zb.controller;

import com.alibaba.fastjson.JSON;
import com.zb.dto.Page;
import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import com.zb.service.Video_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Video_dataController {

    @Autowired
    Video_dataService video_dataService;


    @RequestMapping("getByPage")
    public Page<Video_data> getByPage(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                                      @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                      @RequestParam(value = "videoTitle",required = false)String videoTitle,
                                      @RequestParam(value = "typeId",required = false)Integer typeId){
        return video_dataService.getVideo_DataByPage(videoTitle,typeId,pageIndex,pageSize);
    }

    @RequestMapping("getById")
    public List<Videoaddress> getById(@RequestParam("id")Integer id){
        //根据商品编号查询商品，为获取视频属于的值然后查询视频地址遍历集合
        Video_data byVideoTypeId = video_dataService.getByVideoTypeId(id);
        List<Videoaddress> selBy = video_dataService.getSelBy(byVideoTypeId.getVideoTypeId());
        return selBy;
    }

}
