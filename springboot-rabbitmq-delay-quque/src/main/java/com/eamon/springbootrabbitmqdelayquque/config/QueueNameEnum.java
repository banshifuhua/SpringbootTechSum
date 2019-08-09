package com.eamon.springbootrabbitmqdelayquque.config;

/**
 * @author eamon
 * @date 2019/08/09 09:03
 **/
public enum QueueNameEnum {

    // 延迟消息队列
    QUEUE_TTL_ORDER_CANCEL("order_direct_ttl", "order_cancel_ttl", "order_cancel_ttl_key"),
    // 实际消息消费队列
    QUEUE_ORDER_CANCEL("order_direct", "order_cancel", "order_cancel_key");

    /**
     * 交换机名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueNameEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getName() {
        return name;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
