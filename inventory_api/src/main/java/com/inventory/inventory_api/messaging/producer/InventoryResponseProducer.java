package com.inventory.inventory_api.messaging.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.inventory.inventory_api.convert.ProductEventConvet;
import com.inventory.inventory_api.entity.InventoryModel;

@Component
public class InventoryResponseProducer {
    
    private final RabbitTemplate rabbitTemplate;
    private final ProductEventConvet productEventConvert;

    public InventoryResponseProducer(RabbitTemplate rabbitTemplate, ProductEventConvet productEventConvert) {
        this.rabbitTemplate = rabbitTemplate;
        this.productEventConvert = productEventConvert;
    }

    public void quantityReturn (InventoryModel inventoryModel){
        rabbitTemplate.convertAndSend(
            "inventory.exchange",
            "inventory.quantity",
            productEventConvert.toProductEventDto(inventoryModel)
        );
    }
    
}
