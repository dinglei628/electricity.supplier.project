package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.dto.Page;
import com.zb.mapper.Video_dataMapper;
import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import com.zb.service.Video_dataService;
import com.zb.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Video_dataServiceImpl implements Video_dataService {
    @Autowired(required = false)
    Video_dataMapper video_dataMapper;
    @Autowired
    RedisUtils redisUtils;


    @Override
    public Page<Video_data> getVideo_DataByPage(String videoTitle, Integer typeId, Integer pageIndex, Integer pageSize) {
        List<Video_data> list = video_dataMapper.getVideo_DataByPage(videoTitle, typeId, (pageIndex - 1) * pageSize, pageSize);
        int cnt = video_dataMapper.getVideo_DataByCount(videoTitle, typeId);
        Page<Video_data> page = new Page<>(pageIndex,pageSize,cnt,list);
        return page;
    }

    @Override
    public Video_data getByVideoTypeId(Integer id) {
        return video_dataMapper.getByVideoTypeId(id);
    }

    @Override
    public List<Videoaddress> getSelBy(Integer videoTypeId) {
        return video_dataMapper.getSelBy(videoTypeId);
    }
}
