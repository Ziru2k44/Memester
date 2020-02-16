package com.primlook.memester.exception;

/**
 * Created by Bernardo on 1/29/2020
 */
public class LanguageNotFoundException extends RuntimeException {

    public LanguageNotFoundException(String id) {
        super("The Language with id: " + id +" was not found");
    }
}
