package com.imguo.service.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage) {

        System.out.println("repeatTradeQueue 接收时间:"+ LocalDateTime.now().toString()+" msg内容：");
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());

    }

}
