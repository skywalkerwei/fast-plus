package com.imguo.service.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class DelayedRabbitConfig {

    @Bean
    public Exchange delayExchange() {
        Map<String, Object> args = new HashMap<>(2);
        //  x-delayed-type    声明 延迟队列Exchange的类型
        args.put("x-delayed-type", "direct");
        // 设置名字 交换机类型 持久化 不自动删除
        return new CustomExchange("test-delayed-exchange", "x-delayed-message", true, false, args);
    }

    @Bean
    public Queue delayQueue() {
        return QueueBuilder.durable("test-delayed-queue").build();
    }

    /**
     * 将延迟队列通过routingKey绑定到延迟交换器
     *
     * @return
     */
    @Bean
    public Binding delayQueueBindExchange(Exchange delayExchange, Queue delayQueue) {
        return BindingBuilder.bind(delayQueue).to(delayExchange).with("leilei").noargs();
    }

}
