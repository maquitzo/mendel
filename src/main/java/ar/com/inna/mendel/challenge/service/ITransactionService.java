package ar.com.inna.mendel.challenge.service;

import ar.com.inna.mendel.challenge.model.Transaction;

import java.util.List;

public interface ITransactionService {
    void save(String type, Double amount, Long parent_id, String transaction_id);

    List<String> listByType(String type);

    Double sumByParent(Long transaction_id);
}
