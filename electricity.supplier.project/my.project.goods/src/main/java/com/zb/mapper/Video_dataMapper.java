package com.zb.mapper;

import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Video_dataMapper {

    /**
     * 多条件查询分页
     * @param v
     * @param from
     * @param pageSize
     * @return
     */
    List<Video_data> getVideo_DataByPage(@Param("videoTitle")String videoTitle,
                                         @Param("typeId")Integer typeId,
                                         @Param("from")Integer from,
                                         @Param("pageSize")Integer pageSize);

    /**
     * 返回数据数量
     * @param videoTitle
     * @param typeId
     * @return
     */
    int getVideo_DataByCount(@Param("videoTitle")String videoTitle,
                             @Param("typeId")Integer typeId);


    /**
     * 获取商品属于的值 -->VideoTypeId
     * @return
     */
    Video_data getByVideoTypeId(@Param("id")Integer id);
    /**
     * 根据地址属于查询地址
     * @param videoTypeId
     * @return
     */
    List<Videoaddress> getSelBy(@Param("videoTypeId")Integer videoTypeId);
}
