package com.eamon.springbootrabbitmqdelayquque.service;

import com.eamon.springbootrabbitmqdelayquque.model.OrderParam;

/**
 * @author eamon
 * @date 2019/08/09 11:05
 **/
public interface OrderService {
    /**
     * 取消订单
     *
     * @param id 订单id
     */
    void cancel(String id);

    /**
     * 生成订单
     * @param orderParam
     * @return
     */
    String generateOrder(OrderParam orderParam);
}
