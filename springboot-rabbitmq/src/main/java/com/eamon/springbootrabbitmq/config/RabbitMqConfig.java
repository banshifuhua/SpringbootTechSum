package com.eamon.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit mq 配置
 *
 * @author eamon
 * @date 2019/08/08 16:16
 **/
@Configuration
public class RabbitMqConfig {

    public static final String DEFAULT_QUEUE = "default.queue";
    public static final String MANUAL_QUEUE = "manual.queue";


    @Bean
    public Queue defaultQueue() {
        // 第一个参数 队列名字 第二个参数 是否需要持久化
        return new Queue(DEFAULT_QUEUE, true);
    }

    @Bean
    public Queue manualQueue() {
        // 第一个参数 队列名字 第二个参数 是否需要持久化
        return new Queue(MANUAL_QUEUE, true);
    }

}
