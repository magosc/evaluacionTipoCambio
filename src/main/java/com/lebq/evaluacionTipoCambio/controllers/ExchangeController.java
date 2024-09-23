package com.lebq.evaluacionTipoCambio.controllers;

import com.lebq.evaluacionTipoCambio.dto.ExchangeRequest;
import com.lebq.evaluacionTipoCambio.dto.ExchangeResponse;
import com.lebq.evaluacionTipoCambio.model.ExchangeTransaction;
import com.lebq.evaluacionTipoCambio.repositories.ExchangeTransactionRepository;
import com.lebq.evaluacionTipoCambio.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeTransactionRepository transactionRepository;

    @PostMapping
    public ResponseEntity<ExchangeResponse> applyExchangeRate(@RequestBody ExchangeRequest request){
        ExchangeResponse response = exchangeRateService.calculateExchange(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<ExchangeTransaction>> getAllTransactions(){
        List<ExchangeTransaction> transactions = transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
