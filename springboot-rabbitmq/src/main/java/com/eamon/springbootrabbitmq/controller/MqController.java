package com.eamon.springbootrabbitmq.controller;

import com.eamon.springbootrabbitmq.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eamon
 * @date 2019/08/08 16:56
 **/
@RestController
@RequestMapping("/api/v1/mq")
public class MqController {

    @Autowired
    MqService mqService;

    @GetMapping("/default")
    public void defaultMessage() {
        mqService.defaultMessage();
    }

    @GetMapping("/manual")
    public void manualMessage(){
        mqService.manualMessage();
    }

}
