package com.inventory.inventory_api.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.messaging.producer.InventoryResponseProducer;
import com.inventory.inventory_api.repository.InventoryRepository;
import com.inventory.inventory_api.service.business_exception.NotFoundInventoryException;
import com.inventory.inventory_api.service.business_exception.NotFoundProductException;

@Service
public class FindByService {

    private final InventoryRepository inventoryRepository;
    private final InventoryResponseProducer inventoryResponseProducer;

    public FindByService(InventoryRepository inventoryRepository, InventoryResponseProducer inventoryResponseProducer) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryResponseProducer = inventoryResponseProducer;
    }

    public InventoryModel findByProduct(UUID productId) throws NotFoundProductException {
        Optional<InventoryModel> inventoryModel = inventoryRepository.findByProductId(productId);
        inventoryResponseProducer.quantityReturn(inventoryModel.get());
        return inventoryModel
                .orElseThrow(() -> new NotFoundProductException("Product Not Found "));
    }

    public InventoryModel findByInventory(UUID inventoryId) throws NotFoundInventoryException {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new NotFoundInventoryException("Inventory Not Found "));
    }
}
