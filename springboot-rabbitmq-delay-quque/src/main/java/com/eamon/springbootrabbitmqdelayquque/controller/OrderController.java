package com.eamon.springbootrabbitmqdelayquque.controller;

import com.eamon.springbootrabbitmqdelayquque.model.OrderParam;
import com.eamon.springbootrabbitmqdelayquque.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author eamon
 * @date 2019/08/09 11:05
 **/
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public String generateOrder(@RequestBody OrderParam orderParam) {
        return orderService.generateOrder(orderParam);
    }

    @GetMapping("/cancel/{id}")
    public void cancel(@PathVariable String id) {
        orderService.cancel(id);
    }

}
