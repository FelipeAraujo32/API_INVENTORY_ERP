package com.inventory.inventory_api.service.business_exception;

public class InsufficientInventoryException extends Exception{
    public InsufficientInventoryException(String message){
        super(message);
    }
}
