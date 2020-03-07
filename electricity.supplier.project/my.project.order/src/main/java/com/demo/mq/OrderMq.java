package com.demo.mq;

import com.demo.config.RabbitConfig;

import com.demo.entity.Order;
import com.demo.entity.OrderVo;
import com.demo.mapper.OrderMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class OrderMq {

    @Autowired
    private OrderMapper orderMapper;
    @RabbitListener(queues = RabbitConfig.QUEUE_ORDER)
    public void addOrder(OrderVo orderVo, Channel channel) {
        System.err.println("Mysql-----------添加用户订单");
        Order order = new Order();
        order.setId(orderVo.getOid());
        order.setUserId(orderVo.getUid());
        order.setGoodId(orderVo.getGid());
        order.setStatus(0);
        order.setPrice(12.5f);
        orderMapper.addOrder(order);
    }
}
