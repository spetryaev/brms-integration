package ru.sfedu.brms.service;

import org.junit.Before;
import org.junit.Test;
import ru.sfedu.brms.config.KieBeanFactory;
import ru.sfedu.brms.model.BankDeposit;

import java.util.*;

import static org.junit.Assert.*;

public class BankDepositServiceTest {

    private BankDepositService depositService;

    @Before
    public void setUp() {
        depositService = new BankDepositService();
    }

    @Test
    public void applyInterestToDepositTest1() {
        List<BankDeposit> bankDeposits = new ArrayList<>(Arrays.asList(
                new BankDeposit(500_000, 24),
                new BankDeposit(1_000_000, 24),
                new BankDeposit(500_000, 12),
                new BankDeposit(1_000_000, 12)
        ));

        depositService.applyInterestToDeposit(bankDeposits);

        assert bankDeposits.size() == 4;
        assert bankDeposits.stream().allMatch(Objects::nonNull);

        assertEquals(7, bankDeposits.get(0).getInterest());
        assertEquals(12, bankDeposits.get(1).getInterest());
        assertEquals(5, bankDeposits.get(2).getInterest());
        assertEquals(8, bankDeposits.get(3).getInterest());
    }

}