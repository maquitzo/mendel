package ar.com.inna.mendel.challenge.repository;

import ar.com.inna.mendel.challenge.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository implements ITransactionRepository {

    private List<Transaction> transactionList = new ArrayList<>();

    @Override
    public Transaction save(Transaction transaction) {
        transactionList.add(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> findByType(String type) {

        return transactionList
                .stream()
                .filter(t -> t.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Transaction> findById(Long transactionId) {

        return transactionList
                .stream()
                .filter(t -> t.getId().equals(transactionId))
                .findFirst();
    }

    @Override
    public List<Transaction> findByParentId(Long transactionId) {

        return transactionList
                .stream()
                .filter(t -> transactionId.equals(t.getParent_id()))
                .collect(Collectors.toList());
    }
}
