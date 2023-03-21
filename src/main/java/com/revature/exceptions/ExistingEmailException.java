package com.revature.exceptions;

public class ExistingEmailException extends Exception{
    public ExistingEmailException(String msg){
        super(msg);
    }
}
