package com.zb.service;

import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;

import java.util.List;

public interface GoodService {
    Video_data getVideoById(Integer id,Integer pageSize);

    List<Videoaddress> getVideoAddRess(Integer videoTypeId);
}
