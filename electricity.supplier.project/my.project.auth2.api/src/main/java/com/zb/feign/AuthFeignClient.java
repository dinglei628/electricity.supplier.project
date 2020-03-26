package com.zb.feign;

import com.zb.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "AUTH2SERVER")
public interface AuthFeignClient {
    @RequestMapping("/userinfo")
    public User userinfo(@RequestParam("token") String token);
}
