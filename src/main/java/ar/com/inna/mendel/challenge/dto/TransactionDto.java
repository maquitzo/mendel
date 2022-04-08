package ar.com.inna.mendel.challenge.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransactionDto {
    @NotEmpty
    public Double amount;
    @NotEmpty
    public String type;
    @NotNull
    public Long parent_id;
}
