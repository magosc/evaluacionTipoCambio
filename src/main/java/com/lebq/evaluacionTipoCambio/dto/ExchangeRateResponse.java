package com.lebq.evaluacionTipoCambio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExchangeRateResponse {

    private String result;
    private String base_code;
    private Map<String, Double> rates;
}
