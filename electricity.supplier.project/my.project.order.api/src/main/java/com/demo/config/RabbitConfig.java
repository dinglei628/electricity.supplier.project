package com.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    public static final String QUEUE_ORDER = "order_queue";

    public static final String EXCHANGE_TOPIC_ORDER = "exchange_topic_order";


    @Bean(EXCHANGE_TOPIC_ORDER)
    public Exchange createExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC_ORDER).durable(true).build();
    }

    @Bean(QUEUE_ORDER)
    public Queue createOrderQueue() {
        Queue queue = new Queue(QUEUE_ORDER);
        return queue;
    }


    @Bean
    public Binding bindingOrder(@Qualifier(EXCHANGE_TOPIC_ORDER) Exchange exchange, @Qualifier(QUEUE_ORDER) Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("order.*").noargs();
    }



}