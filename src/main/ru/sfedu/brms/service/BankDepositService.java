package ru.sfedu.brms.service;

import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import ru.sfedu.brms.config.KieBeanFactory;
import ru.sfedu.brms.model.BankDeposit;

import java.util.List;

public class BankDepositService {

    private KieBeanFactory kieBeanFactory;

    public BankDepositService(){
        this.kieBeanFactory = new KieBeanFactory();
    }

    public List<BankDeposit> applyInterestToDeposit(List<BankDeposit> bankDeposits){
        KieSession kieSession = kieBeanFactory.newKieSession();
        try{
            for(BankDeposit deposit: bankDeposits){
                kieSession.insert(deposit);
            }
            kieSession.fireAllRules();
            kieSession.destroy();
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        return bankDeposits;
    }
}
