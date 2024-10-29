package com.inventory.inventory_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventory_api.entity.InventoryModel;
import java.util.Optional;


@Repository 
public interface InventoryRepository extends JpaRepository<InventoryModel, UUID>{
    
    public Optional<InventoryModel> findByProductId(UUID productId);
} 
