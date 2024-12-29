package com.inventory.inventory_api.service.business_exception;

public class NotFoundProductException extends Exception{
    public NotFoundProductException(String message){
        super(message);
    }
}
