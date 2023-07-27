package br.com.api.apitestjunit5.resource.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {
    
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;


}
