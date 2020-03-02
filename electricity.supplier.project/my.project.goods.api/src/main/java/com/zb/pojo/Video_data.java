package com.zb.pojo;
import java.io.Serializable;
import java.util.Date;

/**
*   pojo of video_data
*/
public class Video_data implements Serializable {
    //
    private Integer id;
    //视频名称
    private String videoTitle;
    //视频类别
    private Integer typeId;
    //讲师名称
    private String lecturerName;
    //课程级别:0：初级,1：中级,2：高级
    private Integer difficultyLevel;
    //浏览次数
    private Integer browseCount;
    //上传时间
    private Date uploadTime;
    //是否上传:0：未上传,1：已上传
    private Integer notUpload;
    //视频地址
    private Integer videoTypeId;
    //视频价格
    private float videoPrice;
    //课程类别:0：免费,1：会员,2：购买,3：现时秒杀
    private Integer notVip;
    //是否下架:0：已下架,1：未下架
    private Integer lowerShelf;
    //getter setter
    public void setId (Integer  id){
        this.id=id;
    }
    public  Integer getId(){
        return this.id;
    }
    public void setVideoTitle (String  videoTitle){
        this.videoTitle=videoTitle;
    }
    public  String getVideoTitle(){
        return this.videoTitle;
    }
    public void setTypeId (Integer  typeId){
        this.typeId=typeId;
    }
    public  Integer getTypeId(){
        return this.typeId;
    }
    public void setLecturerName (String  lecturerName){
        this.lecturerName=lecturerName;
    }
    public  String getLecturerName(){
        return this.lecturerName;
    }
    public void setDifficultyLevel (Integer  difficultyLevel){
        this.difficultyLevel=difficultyLevel;
    }
    public  Integer getDifficultyLevel(){
        return this.difficultyLevel;
    }
    public void setBrowseCount (Integer  browseCount){
        this.browseCount=browseCount;
    }
    public  Integer getBrowseCount(){
        return this.browseCount;
    }
    public void setUploadTime (Date  uploadTime){
        this.uploadTime=uploadTime;
    }
    public  Date getUploadTime(){
        return this.uploadTime;
    }
    public void setNotUpload (Integer  notUpload){
        this.notUpload=notUpload;
    }
    public  Integer getNotUpload(){
        return this.notUpload;
    }
    public void setVideoTypeId (Integer  videoTypeId){
        this.videoTypeId=videoTypeId;
    }
    public  Integer getVideoTypeId(){
        return this.videoTypeId;
    }
    public void setVideoPrice (float  videoPrice){
        this.videoPrice=videoPrice;
    }
    public  float getVideoPrice(){
        return this.videoPrice;
    }
    public void setNotVip (Integer  notVip){
        this.notVip=notVip;
    }
    public  Integer getNotVip(){
        return this.notVip;
    }
    public void setLowerShelf (Integer  lowerShelf){
        this.lowerShelf=lowerShelf;
    }
    public  Integer getLowerShelf(){
        return this.lowerShelf;
    }
}
