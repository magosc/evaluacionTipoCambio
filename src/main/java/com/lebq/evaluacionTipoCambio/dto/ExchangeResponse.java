package com.lebq.evaluacionTipoCambio.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeResponse {

    private BigDecimal originalAmount;
    private BigDecimal convertedAmount;
    private BigDecimal exchangeRate;
    private String sourceCurrency;
    private String targetCurrency;
}
