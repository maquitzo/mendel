package ar.com.inna.mendel.challenge.repository;

import ar.com.inna.mendel.challenge.model.Transaction;
import java.util.Optional;
import java.util.List;

public interface ITransactionRepository {
    List<Transaction> findByType(String type);
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long transactionId);
    List<Transaction> findByParentId(Long transactionId);
}
