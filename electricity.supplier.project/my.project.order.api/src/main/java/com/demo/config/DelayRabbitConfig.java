package com.demo.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayRabbitConfig {
    //死信的配置
    private static final String ORDER_DELAY_QUEUE = "user.order.delay.queue";
    public static final String ORDER_DELAY_EXCHANGE = "user.order.delay.exchange";
    public static final String ORDER_DELAY_ROUTING_KEY = "order_delay";

    public static final String ORDER_QUEUE_NAME = "user.order.queue";
    public static final String ORDER_EXCHANGE_NAME = "user.order.exchange";
    public static final String ORDER_ROUTING_KEY = "order";

    /**
     * 延迟队列配置
     * <p>
     * 1、params.put("x-message-ttl", 5 * 1000);
     * 第一种方式是直接设置 Queue 延迟时间 但如果直接给队列设置过期时间,这种做法不是很灵活,（当然二者是兼容的,默认是时间小的优先）
     * 2、rabbitTemplate.convertAndSend(book, message -> {
     * message.getMessageProperties().setExpiration(2 * 1000 + "");
     * return message;
     * });
     * 第二种就是每次发送消息动态设置延迟时间,这样我们可以灵活控制
     **/
    @Bean
    public Queue delayOrderQueue() {
        Map<String, Object> params = new HashMap<String, Object>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", ORDER_EXCHANGE_NAME);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", ORDER_ROUTING_KEY);
        return new Queue(ORDER_DELAY_QUEUE, true, false, false, params);
    }

    /**
     * 需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。
     * 这是一个完整的匹配。如果一个队列绑定到该交换机上要求路由键 “dog”，则只有被标记为“dog”的消息才被转发，
     * 不会转发dog.puppy，也不会转发dog.guard，只会转发dog。
     *
     * @return DirectExchange
     */
    @Bean
    public DirectExchange orderDelayExchange() {
        return new DirectExchange(ORDER_DELAY_EXCHANGE);
    }

    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(delayOrderQueue()).to(orderDelayExchange()).with(ORDER_DELAY_ROUTING_KEY);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange orderTopicExchange() {
        return new TopicExchange(ORDER_EXCHANGE_NAME);
    }

    @Bean
    public Binding orderBinding() {

        return BindingBuilder.bind(orderQueue()).to(orderTopicExchange()).with(ORDER_ROUTING_KEY);
    }
}
