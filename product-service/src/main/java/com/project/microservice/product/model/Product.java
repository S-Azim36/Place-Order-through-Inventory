package com.project.microservice.product.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
}
