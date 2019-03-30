package com.zpself.rabiitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zengpeng on 2019/3/30
 */
@Component
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void process(Message message){
        logger.info("接收处理队列A当中的消息： " + message.getBody());
    }
    @RabbitListener(queues = RabbitConfig.QUEUE_B)
    public void processB(Message message) {
        byte[] body = message.getBody();
        logger.info("接收处理队列B当中的消息： " +new String (body));
    }

}
