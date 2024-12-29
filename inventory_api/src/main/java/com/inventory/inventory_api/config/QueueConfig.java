package com.inventory.inventory_api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class QueueConfig {
    
    @Bean
    public Queue inventoryQuantityReturn(){
        return new Queue("inventory.quantity.queue");
    }
}
