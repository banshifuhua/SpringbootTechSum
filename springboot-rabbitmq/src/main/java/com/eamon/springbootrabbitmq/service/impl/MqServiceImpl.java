package com.eamon.springbootrabbitmq.service.impl;

import com.eamon.springbootrabbitmq.config.RabbitMqConfig;
import com.eamon.springbootrabbitmq.model.User;
import com.eamon.springbootrabbitmq.service.MqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eamon
 * @date 2019/08/08 16:57
 **/
@Service
public class MqServiceImpl implements MqService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void defaultMessage() {
        User user = new User();
        user.setId(1);
        user.setUsername("default");
        rabbitTemplate.convertAndSend(RabbitMqConfig.DEFAULT_QUEUE, user);
    }

    @Override
    public void manualMessage() {
        User user = new User();
        user.setId(2);
        user.setUsername("manual");
        rabbitTemplate.convertAndSend(RabbitMqConfig.MANUAL_QUEUE, user);
    }
}
