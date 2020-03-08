package com.zb.service.Impl;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.rabbitmq.client.Channel;
import com.zb.config.RegisterRabbitConfig;
import com.zb.dto.Dto;
import com.zb.dto.DtoUtil;
import com.zb.entity.User;
import com.zb.mapper.UserMapper;
import com.zb.service.UserRegisterService;
import com.zb.util.IdWorker;
import com.zb.util.RedisUtils;
import com.zb.util.SendUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserMapper userMapper;

    @Override
    public void sendCode(String phoneNumber) {
        //System.out.println("添加消息队列");
        rabbitTemplate.convertAndSend(RegisterRabbitConfig.EXCHANGE_MY_USER, RegisterRabbitConfig.KEY_MY_USER, phoneNumber);
    }

    /**
     * 用戶注冊 验证通过添加用户
     *
     * @param phone
     * @param pwd
     * @param code
     * @return
     */
    @Override
    public Dto register(String phone, String pwd, String code) {
        String recode = redisUtils.get(phone);
        if (recode != null && recode.equals(code)) {
            User user = new User();
            user.setId(IdWorker.getId());
            user.setPhone(phone);
            user.setPhonestate(1);
            user.setUserpwd(pwd);
            Integer result = userMapper.addUserByPhone(user);
            if (result == 1) {
                return DtoUtil.returnSuccess("注册成功");
            }
            return DtoUtil.returnFail("注册失败", "8000");
        }
        return DtoUtil.returnFail("验证码错误", "8001");
    }

    @RabbitListener(queues = RegisterRabbitConfig.QUEUE_USER_CODE)
    public void listenSendCode(String phoneNumber, Channel channel) {
        // System.out.println("异步发送验证码");
        String code = SendUtil.generateCode(4);
        SmsSingleSenderResult result = SendUtil.sendCode(phoneNumber, code);
        System.out.println(phoneNumber);
        if (result.result == 0) {
            redisUtils.setEx(phoneNumber, code, 5, TimeUnit.MINUTES);
        }
        // System.out.println(redisUtils.get(phoneNumber) + "----");

    }
}
