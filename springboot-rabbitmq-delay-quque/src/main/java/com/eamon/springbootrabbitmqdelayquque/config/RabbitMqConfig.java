package com.eamon.springbootrabbitmqdelayquque.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.eamon.springbootrabbitmqdelayquque.config.QueueNameEnum.QUEUE_ORDER_CANCEL;
import static com.eamon.springbootrabbitmqdelayquque.config.QueueNameEnum.QUEUE_TTL_ORDER_CANCEL;

/**
 * RabbitMq 队列配置
 *
 * @author eamon
 * @date 2019/08/09 08:50
 **/
@Configuration
public class RabbitMqConfig {

    /**
     * 订单消息实际消费队列所绑定的交换机
     *
     * @return 交换机
     */
    @Bean
    DirectExchange orderDirectExchange() {
        return new DirectExchange(QUEUE_ORDER_CANCEL.getExchange());
    }

    /**
     * 订单延迟队列队列所绑定的交换机
     *
     * @return
     */
    @Bean
    DirectExchange orderTtlDirectExchange() {
        return new DirectExchange(QUEUE_TTL_ORDER_CANCEL.getExchange());
    }

    /**
     * 订单实际消费队列
     *
     * @return 队列
     */
    @Bean
    Queue orderQueue() {
        return new Queue(QUEUE_ORDER_CANCEL.getName());
    }

    /**
     * 订单延迟队列 （死信队列）
     *
     * @return 队列
     */
    @Bean
    Queue orderTtlQueue() {
        return QueueBuilder
                // 队列名称
                .durable(QUEUE_TTL_ORDER_CANCEL.getName())
                // 消息到期后，转发到dlx（死信交换机）也就是实际消费的交换机
                .withArgument("x-dead-letter-exchange", QUEUE_ORDER_CANCEL.getExchange())
                // 消息到期后，转发至交换机携带的路由键，也就是实际消费的路由键
                .withArgument("x-dead-letter-routing-key", QUEUE_ORDER_CANCEL.getRouteKey())
                .build();
    }

    /**
     * 将订单队列绑定到订单交换机 使用 订单队列路由键
     *
     * @param orderDirectExchange
     * @param orderQueue
     * @return
     */
    @Bean
    Binding orderBinding(DirectExchange orderDirectExchange, Queue orderQueue) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirectExchange)
                .with(QUEUE_ORDER_CANCEL.getRouteKey());
    }

    /**
     * 将订单延迟队列绑定到延迟交换机 使用延迟队列路由键
     *
     * @param orderTtlDirectExchange
     * @param orderTtlQueue
     * @return
     */
    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlDirectExchange, Queue orderTtlQueue) {
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirectExchange)
                .with(QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }

}
