package com.primlook.memester.exception;

/**
 * Created by Bernardo on 1/29/2020
 */
public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException(String id) {
        super("The Profile with id: " + id +" was not found");
    }
}
