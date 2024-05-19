package com.project.microservice.inventory.controller;


import com.project.microservice.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;




    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Boolean isStockAvailable(@RequestParam String productCode, @RequestParam Integer quantity) {

        /*
        if (inventoryService.isStockAvailable(quantity,productCode))

            return "Stock available for product code " + productCode;

        else
            return "Stock not available for product code " + productCode;
         */
        return inventoryService.isStockAvailable(quantity,productCode);
    }
}
