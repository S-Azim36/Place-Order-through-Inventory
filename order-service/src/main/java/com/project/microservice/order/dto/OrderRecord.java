package com.project.microservice.order.dto;

import java.math.BigDecimal;

public record OrderRecord(Long orderId, String orderNumber, String productCode, BigDecimal productPrice, Integer orderQuantity) {
}
