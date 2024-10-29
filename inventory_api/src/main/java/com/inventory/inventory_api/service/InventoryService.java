package com.inventory.inventory_api.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.repository.InventoryRepository;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;
    
    private InventoryModel findByInventoryModel(UUID productId){
        Optional<InventoryModel> optInventoryModel = inventoryRepository.findByProductId(productId);
        if(optInventoryModel.isEmpty()){
            //Solta uma Exception
        }
        return optInventoryModel.get();
    }

    public InventoryModel createdInventory(UUID productId, Integer quantity){
        InventoryModel findByInventory = findByInventoryModel(productId);
        // função para verifi. se tem InventoryId.
        InventoryModel inventoryModel = new InventoryModel(productId, quantity);
        return inventoryRepository.save(inventoryModel);
    }




}
