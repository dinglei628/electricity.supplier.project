package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.mapper.Video_dataMapper;
import com.zb.pojo.Video_data;
import com.zb.service.Video_dataService;
import com.zb.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Video_dataServiceImpl implements Video_dataService {
    @Autowired(required = false)
    Video_dataMapper video_dataMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public Video_data getByVideoId(Integer id,Integer pageSize) {
        List<Video_data> byVideo = video_dataMapper.getByVideo(pageSize);
        for (Video_data v:byVideo){
            if(v.getId() == id){
                System.out.println("这是热点数据");
                Video_data video_data = toByVideoId(id);
                return video_data;
            }
        }
        Video_data goods = null;
        String key = "goods_" + id;
        if (redisTemplate.hasKey(key)) {
            System.out.println("1获取redis中的数据");
            String json = redisUtils.get(key).toString();
            goods = JSON.parseObject(json, Video_data.class);
            System.out.println(goods+"aaaaaaaaaaaaaaaaaaaaaaaaa");
            System.out.println("1redis取数据");
        } else {
            System.out.println("1获取db中的数据");
            goods = video_dataMapper.getByVideoId(id);
            redisUtils.set("good_" + id, JSON.toJSONString(goods));
            System.out.println("1mysql取数据");
        }
        video_dataMapper.BrowseUpdate(id);
        return goods;
    }

    @Cacheable(value = "cache" ,key="#id")
    public Video_data toByVideoId(Integer id){
        Video_data goods = null;
        String key = "goods_" + id;
        if (redisTemplate.hasKey(key)) {
            System.out.println("2获取redis中的数据");
            String json = redisUtils.get(key).toString();
            goods = JSON.parseObject(json, Video_data.class);
            System.out.println("2redis取数据");
        } else {
            System.out.println("2获取db中的数据");
            goods = video_dataMapper.getByVideoId(id);
            redisUtils.set("good_" + id, JSON.toJSONString(goods));
            System.out.println("2mysql取数据");
        }
        video_dataMapper.BrowseUpdate(id);
        return goods;
    }
}
