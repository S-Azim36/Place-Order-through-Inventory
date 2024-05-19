package com.project.microservice.order.controller;


import com.project.microservice.order.dto.OrderRecord;
import com.project.microservice.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRecord orderRecord) {
        OrderRecord order = orderService.createOrder(orderRecord);
        if(order == null){
            return "Something went wrong!";
        }
        else if(order.orderId() == null){
            return "Couldn't create order for: "+order.productCode();
        }
        else {
            return "Order created successfully for: "+order.productCode();
        }

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderRecord> getAllOrders() {
        return orderService.getAllOrders();
    }

}
