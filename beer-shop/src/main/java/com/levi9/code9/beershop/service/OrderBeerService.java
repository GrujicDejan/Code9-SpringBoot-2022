package com.levi9.code9.beershop.service;

import com.levi9.code9.beershop.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderBeerService {

    @Autowired
    private DesignBeerService designBeerService;

    private List<Order> orders = new ArrayList<>();

    public void submitOrder(final Order order) {
        order.setBeers(designBeerService.getAllBeers());
        orders.add(order);
        log.info(String.format("Order submitted: %s", order));
    }

}
