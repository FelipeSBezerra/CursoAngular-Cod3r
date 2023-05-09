package com.felipe.product.domain.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Integer id){
        super("There is no product with id " + id + " in the database");
    }
}
