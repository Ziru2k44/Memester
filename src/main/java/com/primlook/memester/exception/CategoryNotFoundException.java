package com.primlook.memester.exception;

/**
 * Created by Bernardo on 1/29/2020
 */
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("A category was not found");
    }
}
