package com.inventory.inventory_api.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.inventory.inventory_api.convert.ProductEventConvet;
import com.inventory.inventory_api.dto.ProductEventDto;
import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.exception.InsufficientInventoryException;
import com.inventory.inventory_api.service.InventoryAddService;
import com.inventory.inventory_api.service.InventoryQueryService;
import com.inventory.inventory_api.service.InventoryRemoveService;

@Component
public class ProductConsumer {

    private final InventoryAddService inventoryAddService;
    private final InventoryQueryService inventoryQueryService;
    private final InventoryRemoveService inventoryRemoveService;
    private final ProductEventConvet productEventConvet;

    public ProductConsumer(InventoryAddService inventoryAddService, InventoryQueryService inventoryQueryService,
            InventoryRemoveService inventoryRemoveService, ProductEventConvet productEventConvet) {
        this.inventoryAddService = inventoryAddService;
        this.inventoryQueryService = inventoryQueryService;
        this.inventoryRemoveService = inventoryRemoveService;
        this.productEventConvet = productEventConvet;
    }

    @RabbitListener(queues = "product.created.queue")
    public void handleInventoryAdd(ProductEventDto productEventDto) {
        InventoryModel inventoryModel = productEventConvet.toInventoryModel(productEventDto);
        inventoryAddService.addInventory(inventoryModel);
    }

    @RabbitListener(queues = "product.deleted.queue")
    public void handleInventoryUpdate(ProductEventDto productEventDto) throws InsufficientInventoryException {
        InventoryModel inventoryModel = productEventConvet.toInventoryModel(productEventDto);
        inventoryRemoveService.removeInventory(inventoryModel);
    }
}
