package ru.sfedu.brms.service;

import org.kie.api.runtime.KieSession;
import ru.sfedu.brms.config.KieBeanFactory;
import ru.sfedu.brms.model.BankDeposit;

public class BankDepositService {

    private KieSession kieSession = new KieBeanFactory().getKieSession();

    public BankDeposit applyInterestAmountToDeposit(BankDeposit deposit){
        kieSession.insert(deposit);
        kieSession.fireAllRules();
        System.out.println("Interest amount = " + deposit.getInterestAmount());
        return deposit;
    }
}
