package ru.sfedu.brms.model;

public class BankDeposit {

    private int amount;
    private int term;
    private int interest;
    private int interestAmount;

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

    public int getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(int interestAmount) {
        this.interestAmount = interestAmount;
    }
}
