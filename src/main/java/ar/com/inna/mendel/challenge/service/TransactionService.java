package ar.com.inna.mendel.challenge.service;

import ar.com.inna.mendel.challenge.model.Transaction;
import ar.com.inna.mendel.challenge.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ITransactionRepository iTransactionRepository;

    public void save(String type,Double amount, Long parent_id, Long transaction_id) {
        iTransactionRepository.save(new Transaction(transaction_id,parent_id,amount,type));
    }

    public List<String> listByType(String type){

        return iTransactionRepository
                .findByType(type)
                .stream()
                .map(p -> p.getId().toString())
                .collect(Collectors.toList());
    }


    public Double sumByParent(Long transaction_id) {

        List<Transaction> lt = iTransactionRepository.findByParentId(transaction_id);
        Optional<Transaction> tid = iTransactionRepository.findById(transaction_id);

        Double sumParent = Stream.concat(lt.stream(), tid.stream())
                .map(t -> t.getAmount())
                .reduce(0.00, (partialAmount, amount) -> partialAmount + amount);

        return sumParent;
    }

}
