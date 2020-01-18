package com.evilcorp.brms.model;

public class BankDeposit {

    private Long id;
    private int amount;
    private int term;
    private int interest;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public BankDeposit(){}

    public BankDeposit(int amount, int term) {
        this.amount = amount;
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
