package com.eamon.springbootrabbitmq.service;

/**
 * @author eamon
 * @date 2019/08/08 16:57
 **/
public interface MqService {
    /**
     * default 消费模式
     *
     * @return
     */
    void defaultMessage();

    /**
     * 手动消费模式
     */
    void manualMessage();
}
