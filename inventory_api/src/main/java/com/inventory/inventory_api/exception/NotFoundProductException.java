package com.inventory.inventory_api.exception;

public class NotFoundProductException extends Exception{
    public NotFoundProductException(String message){
        super(message);
    }
}