package br.com.api.apitestjunit5.service.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
    
    public DataIntegratyViolationException(String msg){
        super(msg);
    }
}
