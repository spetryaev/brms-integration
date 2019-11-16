package ru.sfedu.brms.service;

import org.junit.Before;
import org.junit.Test;
import ru.sfedu.brms.model.BankDeposit;

import static org.junit.Assert.*;

public class BankDepositServiceTest {

    private BankDepositService depositService;
    @Before
    public void setUp() throws Exception {
        depositService = new BankDepositService();
    }

    @Test
    public void applyInterestToDepositTest() {
        BankDeposit deposit = new BankDeposit();
        deposit.setAmount(1_000_000);
        deposit.setTerm(24);
        depositService.applyInterestToDeposit(deposit);
        assertEquals(4, deposit.getInterest());

        deposit.setTerm(12);
        depositService.applyInterestToDeposit(deposit);
        assertEquals(3, deposit.getInterest());

        deposit.setAmount(500_000);
        depositService.applyInterestToDeposit(deposit);
        assertEquals(4, deposit.getInterest());

        deposit.setAmount(500_000);
        deposit.setTerm(24);
        depositService.applyInterestToDeposit(deposit);
        assertEquals(5, deposit.getInterest());
    }
}