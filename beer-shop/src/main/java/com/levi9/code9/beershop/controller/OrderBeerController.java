package com.levi9.code9.beershop.controller;

import com.levi9.code9.beershop.model.Order;
import com.levi9.code9.beershop.service.OrderBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderBeerController {

    @Autowired
    private OrderBeerService orderBeerService;

    @PostMapping
    public void orderBeer(@RequestBody final Order order) {
        orderBeerService.submitOrder(order);
    }

}
