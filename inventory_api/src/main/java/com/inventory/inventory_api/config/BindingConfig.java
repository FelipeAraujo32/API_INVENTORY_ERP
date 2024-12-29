package com.inventory.inventory_api.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BindingConfig {
    
    @Bean
    public Binding bindingInventory(Queue inventoryQuantityReturn, TopicExchange inventoryExchange) {
        return BindingBuilder.bind(inventoryQuantityReturn).to(inventoryExchange).with("inventory.quantity");
    }
}
