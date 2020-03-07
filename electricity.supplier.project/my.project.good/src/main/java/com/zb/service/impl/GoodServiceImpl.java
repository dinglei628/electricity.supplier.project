package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.mapper.GoodMapper;
import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import com.zb.service.GoodService;
import com.zb.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodMapper goodMapper;

    @Autowired
    RedisUtils redisUtils;


    @Override
    @Cacheable(value = "cache" ,key="#id")
    public Video_data getVideoById(Integer id,Integer pageSize) {
        List<Video_data> videoByList = goodMapper.getVideoByList(pageSize);
        for (Video_data v:videoByList){
            if(v.getId() == id){
                System.out.println("热点数据。。。");
                return toVideoById(id,pageSize);
            }
        }
        Video_data videoById = null;
        String key = "good_"+id;
        if(redisUtils.hasKey(key)){
            System.out.println("1redis中获取数据。。。");
            String json = redisUtils.get(key).toString();
            videoById = JSON.parseObject(json, Video_data.class);
            System.out.println("1redis中获取数据。。。");
        }else{
            System.out.println("1mysql中获取数据。。。");
            videoById = goodMapper.getVideoById(id);
            redisUtils.set(key, JSON.toJSONString(videoById));
        }
        goodMapper.UpVideoById(id);
        return videoById;
    }

    @Override
    public List<Videoaddress> getVideoAddRess(Integer videoTypeId) {
        return goodMapper.getVideoAddRess(videoTypeId);
    }

    /**
     * 查询热点数据
     * @param id
     * @param pageSize
     * @return
     */
    public Video_data toVideoById(Integer id,Integer pageSize) {
        Video_data videoById = null;
        String key = "good_"+id;
        if(redisUtils.hasKey(key)){
            System.out.println("2redis中获取数据");
            String json = redisUtils.get(key).toString();
            videoById = JSON.parseObject(json, Video_data.class);
            System.out.println("2redis中获取数据");
        }else{
            System.out.println("2mysql中获取数据");
            videoById = goodMapper.getVideoById(id);
            redisUtils.set(key, JSON.toJSONString(videoById));
        }
        goodMapper.UpVideoById(id);
        return videoById;
    }

}
