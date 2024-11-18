package com.inventory.inventory_api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class InventoryQueryService {

    private final InventoryRepository inventoryRepository;
    
    public InventoryQueryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Optional<InventoryModel> getInventoryByProductId(UUID productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public List<InventoryModel> getAllInventory() {
        return inventoryRepository.findAll();
    }




}
