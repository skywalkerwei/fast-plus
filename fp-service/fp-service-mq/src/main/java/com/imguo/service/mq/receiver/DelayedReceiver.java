package com.imguo.service.mq.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class DelayedReceiver {

    @RabbitListener(queues = "test-delayed-queue")
    public void testListenerDelayedMessage(Message message) {
        byte[] body = message.getBody();
        System.out.println( LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"))  + new String(body));
    }


}
