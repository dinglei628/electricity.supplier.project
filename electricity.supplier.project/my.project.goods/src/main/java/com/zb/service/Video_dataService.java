package com.zb.service;

import com.zb.dto.Page;
import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;

import java.util.List;

public interface Video_dataService {

    Video_data getByVideoId(Integer id,Integer pageSize);

}
