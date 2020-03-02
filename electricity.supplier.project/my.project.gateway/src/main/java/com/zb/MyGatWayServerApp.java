package com.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MyGatWayServerApp {
    //你好李四
    public static void main(String[] args) {
        SpringApplication.run(MyGatWayServerApp.class, args);
    }
}
