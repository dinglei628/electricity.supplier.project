package com.zb.pojo;
import java.io.Serializable;
import java.util.Date;

/**
*   pojo of videoaddress
*/
public class Videoaddress implements Serializable {
    //视频地址编号
    private Integer videoId;
    //视频地址
    private String videoAddress;
    //视频属于
    private Integer videoTypeId;
    //getter setter
    public void setVideoId (Integer  videoId){
        this.videoId=videoId;
    }
    public  Integer getVideoId(){
        return this.videoId;
    }
    public void setVideoAddress (String  videoAddress){
        this.videoAddress=videoAddress;
    }
    public  String getVideoAddress(){
        return this.videoAddress;
    }
    public void setVideoTypeId (Integer  videoTypeId){
        this.videoTypeId=videoTypeId;
    }
    public  Integer getVideoTypeId(){
        return this.videoTypeId;
    }
}
