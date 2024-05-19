package com.project.microservice.product.dto;

import java.math.BigDecimal;

public record ProductRecord(String productId, String productName, String productDescription,BigDecimal productPrice) {
}
