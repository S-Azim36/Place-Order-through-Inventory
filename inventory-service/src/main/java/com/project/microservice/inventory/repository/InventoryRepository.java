package com.project.microservice.inventory.repository;

import com.project.microservice.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    Boolean existsByProductCodeAndStockIsGreaterThanEqual(String productCode, Integer stock);

}
