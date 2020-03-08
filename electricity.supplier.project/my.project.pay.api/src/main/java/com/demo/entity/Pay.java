package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay implements Serializable {
    //id orderId isPay userId goodId way createDate updateDate
    private String id;
    private String orderId;
    private String subject;
    private Float amount;
    private String isPay;
    private String way;
    private String createDate;
    private String mentDate;
}
