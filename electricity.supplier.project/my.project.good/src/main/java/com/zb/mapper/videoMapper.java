package com.zb.mapper;

import com.zb.pojo.Videoaddress;
import com.zb.pojo.Videotype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface videoMapper {

    int videoInsert(Videoaddress v);

}
