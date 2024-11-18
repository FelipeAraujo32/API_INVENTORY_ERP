package com.inventory.inventory_api.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.exception.InsufficientInventoryException;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class InventoryRemoveService {

    private final InventoryRepository inventoryRepository;

    public InventoryRemoveService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void removeInventory(InventoryModel inventory) throws InsufficientInventoryException {
        InventoryModel inventoryModel = findByProduct(inventory.getProductId());
        checkQuantity(inventoryModel.getQuantity(), inventory.getQuantity());
        inventoryModel.setQuantity(inventoryModel.getQuantity() - inventory.getQuantity());
        inventoryRepository.save(inventoryModel);
    }

    private InventoryModel findByProduct(UUID productId) {
        Optional<InventoryModel> inventoryModel = inventoryRepository.findByProductId(productId);
        if (inventoryModel.isEmpty()) {
            new InsufficientInventoryException("Product not found in inventory.");
        }
        return inventoryModel.get();
    }

    private void checkQuantity(int inventoryModelQuantity, int quantity) {
        if (inventoryModelQuantity < quantity) {
            new InsufficientInventoryException("Insufficient quantity in inventory.");
        }
    }

}
