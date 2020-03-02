package com.zb.pojo;
import java.io.Serializable;
import java.util.Date;

/**
*   pojo of videotype
*/
public class Videotype implements Serializable {
    //类型编号
    private Integer typeId;
    //类型名称
    private String typeVideoName;
    //getter setter
    public void setTypeId (Integer  typeId){
        this.typeId=typeId;
    }
    public  Integer getTypeId(){
        return this.typeId;
    }
    public void setTypeVideoName (String  typeVideoName){
        this.typeVideoName=typeVideoName;
    }
    public  String getTypeVideoName(){
        return this.typeVideoName;
    }
}
