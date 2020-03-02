package com.zb.service;

import com.zb.dto.Page;
import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;

import java.util.List;

public interface Video_dataService {

    Page<Video_data> getVideo_DataByPage(String videoTitle,Integer typeId,Integer pageIndex,Integer pageSize);

    Video_data getByVideoTypeId(Integer id);

    List<Videoaddress> getSelBy(Integer videoTypeId);

}
