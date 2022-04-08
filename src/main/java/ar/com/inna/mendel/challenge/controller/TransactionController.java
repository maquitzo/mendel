package ar.com.inna.mendel.challenge.controller;

import ar.com.inna.mendel.challenge.dto.TransactionDto;
import ar.com.inna.mendel.challenge.model.Transaction;
import ar.com.inna.mendel.challenge.service.ITransactionService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService iTransactionService) {
        this.transactionService = iTransactionService;
    }

    @PutMapping("/{transaction_id}")
    public void putTransaction(@PathVariable String transaction_id, @RequestBody TransactionDto transaction) {

        this.transactionService.save(
                transaction.type,
                transaction.amount,
                transaction.parent_id,
                transaction_id);
    }

    @GetMapping("/types/{type}")
    public List<String> getTransactionByType(@PathVariable String type) {
        return this.transactionService.listByType(type);
    }

    @GetMapping("/sum/{transaction_id}")
    public ResponseEntity<Object> getTransactionByParent(@PathVariable Long transaction_id) {

        JSONObject sum = new JSONObject();
        sum.put("sum", this.transactionService.sumByParent(transaction_id));

        return new ResponseEntity<Object>(sum, HttpStatus.OK);
    }

}
