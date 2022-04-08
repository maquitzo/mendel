package ar.com.inna.mendel.challenge.model;

public class Transaction {
    private Long id;
    private Long parent_id;
    private Double amount;
    private String type;

    public Transaction(Long id, Long parent_id, Double amount, String type) {
        this.setId(id);
        this.setParent_id(parent_id);
        this.setAmount(amount);
        this.setType(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
