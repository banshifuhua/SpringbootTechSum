package com.eamon.springbootrabbitmqdelayquque.config;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * @author eamon
 * @date 2019/08/09 11:08
 **/
public class ExpirationMessagePostProcessor implements MessagePostProcessor {

    /**
     * 单位 毫秒
     */
    private final Long ttl;

    public ExpirationMessagePostProcessor(Long ttl) {
        this.ttl = ttl;
    }

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties().setExpiration(String.valueOf(ttl));
        return message;
    }
}
