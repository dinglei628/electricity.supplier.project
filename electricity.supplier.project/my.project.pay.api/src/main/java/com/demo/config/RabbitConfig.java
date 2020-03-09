package com.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String QUEUE_PAY = "pay_queue";

    public static final String EXCHANGE_TOPIC_PAY = "exchange_topic_pay";


    @Bean(EXCHANGE_TOPIC_PAY)
    public Exchange createPayExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC_PAY).durable(true).build();
    }

    @Bean(QUEUE_PAY)
    public Queue createPayQueue() {
        Queue queue = new Queue(QUEUE_PAY);
        return queue;
    }


    @Bean
    public Binding bindingPay(@Qualifier(EXCHANGE_TOPIC_PAY) Exchange exchange, @Qualifier(QUEUE_PAY) Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("pay.*").noargs();
    }



}