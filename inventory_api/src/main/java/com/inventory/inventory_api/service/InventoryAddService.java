package com.inventory.inventory_api.service;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class InventoryAddService {

    private final InventoryRepository inventoryRepository;

    public InventoryAddService(InventoryRepository inventoryRepository, InventoryQueryService inventoryQueryService) {
        this.inventoryRepository = inventoryRepository;
    }

    public void addInventory(InventoryModel inventory) {
        InventoryModel inventoryModel = inventoryRepository.findByProductId(inventory.getProductId())
                .orElse((new InventoryModel(inventory.getProductId(), inventory.getQuantity())));
        inventoryModel.setQuantity(inventoryModel.getQuantity() + inventory.getQuantity());
        inventoryRepository.save(inventoryModel);
    }
}
