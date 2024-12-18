package com.inventory.inventory_api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.exception.NotFoundInventoryException;
import com.inventory.inventory_api.exception.NotFoundProductException;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class FindByService {

    private final InventoryRepository inventoryRepository;

    public FindByService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryModel findByProduct(UUID productId) throws NotFoundProductException {
        return inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundProductException("Product Not Found "));
    }

    public InventoryModel findByInventory(UUID inventoryId) throws NotFoundInventoryException {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new NotFoundInventoryException("Inventory Not Found "));
    }
}
