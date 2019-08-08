package com.eamon.springbootrabbitmq.listener;

import com.eamon.springbootrabbitmq.config.RabbitMqConfig;
import com.eamon.springbootrabbitmq.model.User;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author eamon
 * @date 2019/08/08 17:16
 **/
@Component
public class RabbitMqListener {
    private static final Logger log = LoggerFactory.getLogger(RabbitMqListener.class);

    /**
     * 默认情况下,如果没有配置手动ACK, 那么Spring Data AMQP 会在消息消费完毕后自动帮我们去ACK
     * 存在问题：如果报错了,消息不会丢失,但是会无限循环消费,一直报错,如果开启了错误日志很容易就吧磁盘空间耗完
     * 解决方案：手动ACK,或者try-catch 然后在 catch 里面讲错误的消息转移到其它的队列中去
     *
     * @param user
     * @param message
     * @param channel
     */
    @RabbitListener(queues = {RabbitMqConfig.DEFAULT_QUEUE})
    public void listenerAutoAck(User user, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("[listenerAutoAck 监听的消息] - [{}]", user.toString());
        try {
            // 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            log.warn("[listenerAutoAck 监听的消息] - 消费失败");
            // 处理失败，重新压入MQ
            try {
                channel.basicRecover();
            } catch (IOException ex) {
                log.error("[listenerAutoAck 监听的消息] - 重新入队失败！", e);
            }
        }
    }

    @RabbitListener(queues = {RabbitMqConfig.MANUAL_QUEUE})
    public void listenerManualAck(User user, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("[listenerManualAck 监听的消息] - [{}]", user.toString());
        try {
            // 消费成功，可以ACK
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            // todo 消费失败，进行容错处理，比如，将此消息发送到其他队列
        }
    }

}
