package com.project.microservice.product.service;

import com.project.microservice.product.dto.ProductRecord;
import com.project.microservice.product.model.Product;
import com.project.microservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public ProductRecord createProduct(ProductRecord productRecord) {

        Product product = Product.builder()
                        .productName(productRecord.productName())
                        .productDescription(productRecord.productDescription())
                        .productPrice(productRecord.productPrice())
                        .build();

        productRepository.save(product);
        return new ProductRecord(product.getProductId(), product.getProductName(), product.getProductDescription(), product.getProductPrice());

    }

    public List<ProductRecord> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductRecord(product.getProductId(),
                        product.getProductName(), product.getProductDescription(),
                        product.getProductPrice()))
                .toList();
    }
}
