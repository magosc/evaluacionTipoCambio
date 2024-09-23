package com.lebq.evaluacionTipoCambio.services;

import com.lebq.evaluacionTipoCambio.clients.ExchangeRateClient;
import com.lebq.evaluacionTipoCambio.dto.ExchangeRateResponse;
import com.lebq.evaluacionTipoCambio.dto.ExchangeRequest;
import com.lebq.evaluacionTipoCambio.dto.ExchangeResponse;
import com.lebq.evaluacionTipoCambio.exceptions.ExchangeRateNotFoundException;
import com.lebq.evaluacionTipoCambio.model.ExchangeTransaction;
import com.lebq.evaluacionTipoCambio.repositories.ExchangeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    @Autowired
    private ExchangeTransactionRepository transactionRepository;

    public ExchangeResponse calculateExchange(ExchangeRequest request){
        ExchangeRateResponse response = exchangeRateClient.getExchangeRate(request.getSourceCurrency());

        Double exchangeRate = response.getRates().get(request.getTargetCurrency());

        if(exchangeRate == null){
            throw new ExchangeRateNotFoundException("Tipo de cambio no disponible para "+request.getTargetCurrency());
        }

        BigDecimal convertedAmount = request.getAmount().multiply(BigDecimal.valueOf(exchangeRate));

        ExchangeTransaction transaction = new ExchangeTransaction();
        transaction.setOriginalAmount(request.getAmount());
        transaction.setConvertedAmount(convertedAmount);
        transaction.setExchangeRate(BigDecimal.valueOf(exchangeRate));
        transaction.setSourceCurrency(request.getSourceCurrency());
        transaction.setTargetCurrency(request.getTargetCurrency());
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);

        ExchangeResponse exchangeResponse = new ExchangeResponse();
        exchangeResponse.setOriginalAmount(request.getAmount());
        exchangeResponse.setConvertedAmount(convertedAmount);
        exchangeResponse.setExchangeRate(BigDecimal.valueOf(exchangeRate));
        exchangeResponse.setSourceCurrency(request.getSourceCurrency());
        exchangeResponse.setTargetCurrency(request.getTargetCurrency());

        return exchangeResponse;
    }
}
