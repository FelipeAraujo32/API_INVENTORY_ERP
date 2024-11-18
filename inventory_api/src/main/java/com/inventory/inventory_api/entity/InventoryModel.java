package com.inventory.inventory_api.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "inventory")
@Table(name = "inventory_erp")
public class InventoryModel {
    
    private UUID inventoryId;
    private UUID productId;
    private Integer quantity;

    public InventoryModel(UUID productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public InventoryModel() {
    }

    public UUID getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(UUID inventoryId) {
        this.inventoryId = inventoryId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
