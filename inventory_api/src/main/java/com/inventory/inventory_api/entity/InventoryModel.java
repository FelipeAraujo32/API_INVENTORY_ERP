package com.inventory.inventory_api.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity(name = "inventory")
@Table(name = "inventory_erp")
public class InventoryModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID inventoryId;

    @Column(nullable = false)
    private UUID productId;

    @Column(nullable = false)
    @NotNull(message = "Price cannot be Null")
    @Positive(message = "The price cannot be zero")
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
