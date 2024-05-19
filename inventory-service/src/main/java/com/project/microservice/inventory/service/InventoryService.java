package com.project.microservice.inventory.service;

import com.project.microservice.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public Boolean isStockAvailable(Integer stock, String productCode) {

        return inventoryRepository.existsByProductCodeAndStockIsGreaterThanEqual(productCode,stock);
    }

}
