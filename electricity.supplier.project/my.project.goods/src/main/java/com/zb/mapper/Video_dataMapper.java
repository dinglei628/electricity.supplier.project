package com.zb.mapper;

import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Video_dataMapper {

    /**
     * 根据商品id查询
     * @return
     */
    Video_data getByVideoId(@Param("id")Integer id);


    List<Video_data> getByVideo(@Param("pageSize") Integer pageSize);
//    /**
//     * 根据地址属于查询地址
//     * @param videoTypeId
//     * @return
//     */
//    List<Videoaddress> getSelBy(@Param("videoTypeId")Integer videoTypeId);
    /**
     * 根据Id修改浏览次 没浏览一次+1
     * @param id
     * @return
     */
    int BrowseUpdate(@Param("id")Integer id);
}
