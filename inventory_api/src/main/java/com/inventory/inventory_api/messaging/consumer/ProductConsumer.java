package com.inventory.inventory_api.messaging.consumer;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.inventory.inventory_api.convert.ProductEventConvet;
import com.inventory.inventory_api.dto.ProductEventDto;
import com.inventory.inventory_api.entity.InventoryModel;
import com.inventory.inventory_api.service.AddQuantityService;
import com.inventory.inventory_api.service.CreatedInventoryService;
import com.inventory.inventory_api.service.DeleteInventoryService;
import com.inventory.inventory_api.service.FindByService;
import com.inventory.inventory_api.service.RemoveQuantityService;
import com.inventory.inventory_api.service.business_exception.InsufficientInventoryException;
import com.inventory.inventory_api.service.business_exception.NotFoundProductException;

@Component
public class ProductConsumer {

    private final ProductEventConvet productEventConvet;
    private final CreatedInventoryService createdInventoryService;
    private final AddQuantityService addQuantityService;
    private final RemoveQuantityService removeQuantityService;
    private final DeleteInventoryService deleteInventoryService;
    private final FindByService findByService;

    public ProductConsumer(ProductEventConvet productEventConvet, CreatedInventoryService createdInventoryService,
            AddQuantityService addQuantityService, RemoveQuantityService removeQuantityService,
            DeleteInventoryService deleteInventoryService, FindByService findByService) {
        this.productEventConvet = productEventConvet;
        this.createdInventoryService = createdInventoryService;
        this.addQuantityService = addQuantityService;
        this.removeQuantityService = removeQuantityService;
        this.deleteInventoryService = deleteInventoryService;
        this.findByService = findByService;
    }

    @RabbitListener(queues = "product.created.queue")
    public void handleInventoryCreated(ProductEventDto productEventDto) {
        InventoryModel inventoryModel = productEventConvet.toInventoryModel(productEventDto);
        createdInventoryService.inventoryModelCreated(inventoryModel);
    }

    @RabbitListener(queues = "product.updated.queue")
    public void handleInventoryAddQuantity(ProductEventDto productEventDto) {
        InventoryModel inventoryModel = productEventConvet.toInventoryModel(productEventDto);
        addQuantityService.toAddInventory(inventoryModel);
    }

    @RabbitListener(queues = "product.remove.queue")
    public void handleInventoryRemoveQuantity(ProductEventDto productEventDto)
            throws InsufficientInventoryException, NotFoundProductException {
        InventoryModel inventoryModel = productEventConvet.toInventoryModel(productEventDto);
        removeQuantityService.removeQuantityInventory(inventoryModel);
    }

    @RabbitListener(queues = "product.deleted.queue")
    public void handleInventoryDelete(UUID productId) throws NotFoundProductException {
        deleteInventoryService.deletedInventoryByProductId(productId);
    }

    @RabbitListener(queues = "product.quantity.queue")
    public void handleInventoryQuantityReturn(UUID productId) throws NotFoundProductException {
        findByService.findByProduct(productId);
    }

}
