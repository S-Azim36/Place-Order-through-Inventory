package com.project.microservice.order.service;

import com.project.microservice.order.client.InventoryClient;
import com.project.microservice.order.dto.OrderRecord;
import com.project.microservice.order.model.Order;
import com.project.microservice.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InventoryClient inventoryClient;


    public OrderRecord createOrder(OrderRecord orderRecord) {

        Boolean checkIfStockAvailable = inventoryClient.isStockAvailable(orderRecord.productCode(),orderRecord.orderQuantity());

        if (checkIfStockAvailable) {

            Order order = new Order(orderRecord.orderId(),
                    UUID.randomUUID().toString(),
                    orderRecord.productCode(),
                    orderRecord.productPrice(),
                    orderRecord.orderQuantity());

            try {

                orderRepository.save(order);
                return new OrderRecord(order.getOrderId(),
                        order.getOrderNumber(),
                        order.getProductCode(),
                        order.getProductPrice(),
                        order.getOrderQuantity());
            } catch (Exception e) {
                //e.printStackTrace();
                return null;
            }
        }
        else {
            return orderRecord;
        }



    }

    public List<OrderRecord> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderRecord(order.getOrderId(),
                        order.getOrderNumber(), order.getProductCode(),
                        order.getProductPrice(),order.getOrderQuantity()))
                .toList();
    }


}
