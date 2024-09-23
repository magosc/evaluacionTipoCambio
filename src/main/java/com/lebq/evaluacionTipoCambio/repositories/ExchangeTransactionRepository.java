package com.lebq.evaluacionTipoCambio.repositories;

import com.lebq.evaluacionTipoCambio.model.ExchangeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeTransactionRepository extends JpaRepository<ExchangeTransaction, Long> {
}
