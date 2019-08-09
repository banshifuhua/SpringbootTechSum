package com.eamon.springbootrabbitmqdelayquque.listener;

import com.eamon.springbootrabbitmqdelayquque.service.OrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author eamon
 * @date 2019/08/09 11:17
 **/
@Component
public class RabbitMqListener {

    @Autowired
    OrderService orderService;

    @RabbitListener(queues = "order_cancel")
    public void orderCancel(String id, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            orderService.cancel(id);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            // 消息处理失败
        }
    }

}
