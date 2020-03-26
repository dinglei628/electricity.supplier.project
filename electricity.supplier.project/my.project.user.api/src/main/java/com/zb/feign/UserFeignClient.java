package com.zb.feign;

import com.zb.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("USERSERVICE")
public interface UserFeignClient {
    @RequestMapping("currentUserbytoken/{token}")
    public User getCurrentUserByToken(@PathVariable("token") String token);
     @RequestMapping("currentUserbyphone/{phone}")
    public User getCurrentUserByPhone(@PathVariable("phone") String phone);
}
//If I should see you，after long year. How should I greet, with tears, with silence.如果我们再相见，事隔经年。我将以何贺你，以眼泪，以沉默。