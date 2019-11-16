package ru.sfedu.brms.service;

import org.kie.api.runtime.KieSession;
import ru.sfedu.brms.config.KieBeanFactory;
import ru.sfedu.brms.model.BankDeposit;

public class BankDepositService {

    private KieSession kieSession;

    public BankDeposit applyInterestToDeposit(BankDeposit deposit){
        kieSession = new KieBeanFactory().getKieSession();
        kieSession.insert(deposit);
        kieSession.fireAllRules();
        System.out.println("Interest amount = " + deposit.getInterest());
        kieSession.destroy();
        return deposit;
    }
}
