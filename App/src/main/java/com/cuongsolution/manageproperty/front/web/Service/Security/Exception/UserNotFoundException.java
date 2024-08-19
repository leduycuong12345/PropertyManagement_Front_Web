package com.cuongsolution.manageproperty.front.web.Service.Security.Exception;

public class UserNotFoundException extends Exception{
	private String message;

    public UserNotFoundException(String message){
        super(message);
        this.message=message;
    }

    public UserNotFoundException() {}
}
