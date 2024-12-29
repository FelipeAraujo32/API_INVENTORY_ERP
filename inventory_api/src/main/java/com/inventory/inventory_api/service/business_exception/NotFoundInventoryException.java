package com.inventory.inventory_api.service.business_exception;

public class NotFoundInventoryException extends Exception{
    public NotFoundInventoryException(String message){
        super(message);
    }
}
