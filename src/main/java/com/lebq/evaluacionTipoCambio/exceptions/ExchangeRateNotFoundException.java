package com.lebq.evaluacionTipoCambio.exceptions;

public class ExchangeRateNotFoundException extends RuntimeException{

    public ExchangeRateNotFoundException(String message){
        super(message);
    }
}
