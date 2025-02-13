package com.CN.FitFusion.exception;

public class UserNotFoundException extends RuntimeException{
     public UserNotFoundException(String message) {
    	 super(message);
     }
}
