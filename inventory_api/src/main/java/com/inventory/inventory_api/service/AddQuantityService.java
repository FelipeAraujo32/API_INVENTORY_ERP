package com.inventory.inventory_api.service;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class AddQuantityService {
    
    private final InventoryRepository inventoryRepository;
    
    public AddQuantityService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void toAddInventory(InventoryModel inventory) {
        InventoryModel inventoryModel = inventoryRepository.findByProductId(inventory.getProductId())
                .orElse((new InventoryModel(inventory.getProductId(), inventory.getQuantity())));
        inventoryModel.setQuantity(inventoryModel.getQuantity() + inventory.getQuantity());
        inventoryRepository.save(inventoryModel);
    }
}
