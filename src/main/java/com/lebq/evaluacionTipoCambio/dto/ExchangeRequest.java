package com.lebq.evaluacionTipoCambio.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRequest {

    private BigDecimal amount;
    private String sourceCurrency;
    private String targetCurrency;
}
