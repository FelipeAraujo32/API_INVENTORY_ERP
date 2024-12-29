package com.inventory.inventory_api.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {
    
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("inventory.exchange");
    }
}
