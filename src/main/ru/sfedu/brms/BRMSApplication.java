package ru.sfedu.brms;

import ru.sfedu.brms.model.BankDeposit;
import ru.sfedu.brms.service.BankDepositService;

public class BRMSApplication {

    public static void main(String[] args) {
        BankDepositService depositService = new BankDepositService();

        try {
            BankDeposit deposit = new BankDeposit();
            deposit.setAmount(1_000_000);
            deposit.setTerm(24);
            depositService.applyInterestToDeposit(deposit);

            deposit.setTerm(12);
            depositService.applyInterestToDeposit(deposit);

            deposit.setAmount(500_000);
            depositService.applyInterestToDeposit(deposit);

            deposit.setAmount(500_000);
            deposit.setTerm(24);
            depositService.applyInterestToDeposit(deposit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
