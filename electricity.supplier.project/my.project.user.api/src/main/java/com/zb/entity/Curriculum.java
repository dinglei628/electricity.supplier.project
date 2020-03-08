package com.zb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Curriculum {

    String id;
    String title;
    String describe;
    Date lastLookTime;
    String coverImage;
    String userId;
    String courseId;



}
