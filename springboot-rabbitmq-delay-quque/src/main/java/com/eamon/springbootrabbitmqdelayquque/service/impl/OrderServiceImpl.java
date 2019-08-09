package com.eamon.springbootrabbitmqdelayquque.service.impl;

import com.eamon.springbootrabbitmqdelayquque.config.ExpirationMessagePostProcessor;
import com.eamon.springbootrabbitmqdelayquque.model.OrderParam;
import com.eamon.springbootrabbitmqdelayquque.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.eamon.springbootrabbitmqdelayquque.config.QueueNameEnum.QUEUE_TTL_ORDER_CANCEL;

/**
 * @author eamon
 * @date 2019/08/09 11:05
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static final Long ttl = 10000L;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void cancel(String id) {
        log.info("订单 {} 超时，系统取消该订单", id);
        // todo 执行一系列取消订单操作
    }

    @Override
    public String generateOrder(OrderParam orderParam) {
        log.info("> generateOrder");
        String id = orderParam.getId();
        // 发送取消订单消息到延迟队列
        log.info("send delay message orderId:{} , ttl {}", id, ttl);
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        rabbitTemplate.convertAndSend(QUEUE_TTL_ORDER_CANCEL.getExchange(), QUEUE_TTL_ORDER_CANCEL.getRouteKey(), id,
                new ExpirationMessagePostProcessor(ttl));
        return "下单成功";
    }
}
