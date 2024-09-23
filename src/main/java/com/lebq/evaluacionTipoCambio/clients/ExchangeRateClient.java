package com.lebq.evaluacionTipoCambio.clients;

import com.lebq.evaluacionTipoCambio.dto.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ExchangeRateClient", url = "https://open.er-api.com")
public interface ExchangeRateClient {

    @GetMapping("/v6/latest/{currency}")
    ExchangeRateResponse getExchangeRate(@PathVariable("currency") String currency);
}
