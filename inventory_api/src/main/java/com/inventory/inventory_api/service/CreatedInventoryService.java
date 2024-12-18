package com.inventory.inventory_api.service;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class CreatedInventoryService {

    private final InventoryRepository inventoryRepository;

    public CreatedInventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryModel inventoryModelCreated(InventoryModel inventory) {
        InventoryModel inventoryModel = inventoryRepository.findByProductId(inventory.getProductId())
                .orElse(new InventoryModel(inventory.getProductId(), inventory.getQuantity()));
        return inventoryRepository.save(inventoryModel);
    }

    

    

    

    
}
