package com.inventory.inventory_api.exception;

public class InsufficientInventoryException extends Exception{
    public InsufficientInventoryException(String message){
        super(message);
    }
}
