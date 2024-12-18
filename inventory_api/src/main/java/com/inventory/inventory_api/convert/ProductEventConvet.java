package com.inventory.inventory_api.convert;

import org.springframework.stereotype.Component;

import com.inventory.inventory_api.dto.ProductEventDto;
import com.inventory.inventory_api.entity.InventoryModel;

@Component
public class ProductEventConvet {
    
    public InventoryModel toInventoryModel(ProductEventDto productEventDto){
        InventoryModel inventoryModel = new InventoryModel();
        inventoryModel.setProductId(productEventDto.getProductId());
        inventoryModel.setQuantity(productEventDto.getStock());
        return inventoryModel;
    }

    public ProductEventDto toProductEventDto(InventoryModel inventoryModel){
        ProductEventDto productEventDto = new ProductEventDto();
        productEventDto.setProductId(inventoryModel.getProductId());
        productEventDto.setStock(inventoryModel.getQuantity());
        return productEventDto;
    }
}
