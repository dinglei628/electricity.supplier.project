package com.zb.feign;

import com.zb.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("auth2.server")
public interface UserFeignClient2 {

    @RequestMapping("/userinfo/{token}")
    public User userinfo(@PathVariable("token") String token) ;
}
