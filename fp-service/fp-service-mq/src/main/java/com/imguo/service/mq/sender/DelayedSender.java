package com.imguo.service.mq.sender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelayedSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int delayedTime, String messageBody) {
        // 指定之前定义的延迟交换机名 与路由键名
        rabbitTemplate.convertAndSend("test-delayed-exchange", "leilei", messageBody, message -> {
            // 延迟时间单位是毫秒
            message.getMessageProperties().setDelay(delayedTime);
            System.out.println("消息发送时间:" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")) +
                    "消息内容:" + messageBody);
            return message;
        });
    }
}