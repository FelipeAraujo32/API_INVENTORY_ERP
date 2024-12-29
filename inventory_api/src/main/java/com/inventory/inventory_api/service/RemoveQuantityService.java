package com.inventory.inventory_api.service;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;
import com.inventory.inventory_api.service.business_exception.InsufficientInventoryException;
import com.inventory.inventory_api.service.business_exception.NotFoundProductException;

@Service
public class RemoveQuantityService {
    
    private final InventoryRepository inventoryRepository;
    private final FindByService findByService;

    public RemoveQuantityService(InventoryRepository inventoryRepository, FindByService findByService) {
        this.inventoryRepository = inventoryRepository;
        this.findByService = findByService;
    }

    public void removeQuantityInventory(InventoryModel inventory) throws InsufficientInventoryException, NotFoundProductException {
        InventoryModel inventoryModel = findByService.findByProduct(inventory.getProductId());
        checkQuantity(inventoryModel.getQuantity(), inventory.getQuantity());
        inventoryModel.setQuantity(inventoryModel.getQuantity() - inventory.getQuantity());
        inventoryRepository.save(inventoryModel);
    }

    private void checkQuantity(int inventoryModelQuantity, int quantity) {
        if (inventoryModelQuantity < quantity) {
            new InsufficientInventoryException("Insufficient quantity in inventory.");
        }
    }
}
