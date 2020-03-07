package com.zb.service.Impl;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.rabbitmq.client.Channel;
import com.zb.config.RegisterRabbitConfig;
import com.zb.service.UserRegisterService;
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

    @Override
    public void sendCode(String phoneNumber) {
        //System.out.println("添加消息队列");
        rabbitTemplate.convertAndSend(RegisterRabbitConfig.EXCHANGE_MY_USER, RegisterRabbitConfig.KEY_MY_USER, phoneNumber);
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
