package com.zb.mapper;

import com.zb.entity.Curriculum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CurriculumMapper {

    List<Curriculum> getCurriculumsByUid(@Param("userId") String userId, @Param("from") Integer from, @Param("pageSize") Integer pageSize);

    Integer getCurriculumCountByUid(@Param("userId") String userId);
}
