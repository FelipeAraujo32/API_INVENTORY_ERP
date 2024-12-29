package com.inventory.inventory_api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;
import com.inventory.inventory_api.service.business_exception.NotFoundInventoryException;
import com.inventory.inventory_api.service.business_exception.NotFoundProductException;

@Service
public class DeleteInventoryService {

    private final InventoryRepository inventoryRepository;
    private final FindByService findByService;

    public DeleteInventoryService(InventoryRepository inventoryRepository, FindByService findByService) {
        this.inventoryRepository = inventoryRepository;
        this.findByService = findByService;
    }

    public void deletedInventoryByProductId(UUID productId) throws NotFoundProductException {
        InventoryModel byProduct = findByService.findByProduct(productId);
        inventoryRepository.delete(byProduct);
    }

    public void deletedInventoryByInventoryId(UUID inventoryId) throws NotFoundInventoryException {
        InventoryModel byProduct = findByService.findByInventory(inventoryId);
        inventoryRepository.delete(byProduct);
    }
    
}
