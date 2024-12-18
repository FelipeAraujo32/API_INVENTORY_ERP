package com.inventory.inventory_api.exception;

public class NotFoundInventoryException extends Exception{
    public NotFoundInventoryException(String message){
        super(message);
    }
}
