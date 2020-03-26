package com.zb.mapper;

import com.zb.pojo.Video_data;
import com.zb.pojo.Videoaddress;
import com.zb.pojo.Videotype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodMapper {

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Video_data getVideoById(@Param("id")Integer id);

    /**
     * 根据浏览次数查询热点数据，可动态更改热点数据条数
     * @param pageSize
     * @return
     */
    List<Video_data> getVideoByList(@Param("pageSize")Integer pageSize);

    /**
     * 根据Id修改商品访问次数
     * @param id
     * @return
     */
    int UpVideoById(@Param("id")Integer id);

    /**
     * 根据商品属于编号查询商品地址集合
     * @param videoTypeId
     * @return
     */
    List<Videoaddress> getVideoAddRess(@Param("videoTypeId")Integer videoTypeId);



    List<Video_data> getTypeSel(@Param("typeId")Integer typeId);

}
