package br.com.api.apitestjunit5.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
