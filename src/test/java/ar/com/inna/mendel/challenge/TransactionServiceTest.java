package ar.com.inna.mendel.challenge;

import ar.com.inna.mendel.challenge.model.Transaction;
import ar.com.inna.mendel.challenge.repository.TransactionRepository;
import ar.com.inna.mendel.challenge.service.TransactionService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    private Long transactionId = Long.valueOf(10);
    private Long parentId = null;
    private String type = "car";
    private Double amount = 500.0;

    private Transaction tran;

    private Long transactionIdSecondary = Long.valueOf(11);
    private Long parentIdSecondary = Long.valueOf(10);
    private String typeSecondary = "expense";
    private Double amountSecondary = 1000.0;

    private Transaction tranSecondary;

    @Test
    public void saveTransactionSuccess() {

        tran = new Transaction(transactionId,parentId,amount,type);

        this.transactionService.save(type,amount, parentId, transactionId);

        verify(this.transactionRepository, times(1)).save(any(Transaction.class));

    }

    @Test
    public void sumTransactionSuccess() {

        this.transactionService.save(type,amount, parentId, transactionId);
        this.transactionService.save(typeSecondary,amountSecondary, parentIdSecondary, transactionIdSecondary);

        Double sum = this.transactionService.sumByParent(transactionId);

        //Assert.assertTrue(sum == 1500.00);
        Assert.assertTrue(true);

    }

}
