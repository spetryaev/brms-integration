package com.evilcorp.brms.service;

import com.evilcorp.brms.config.KieBeanFactory;
import com.evilcorp.brms.controller.BankDepositController;
import com.evilcorp.brms.model.BankDeposit;
import org.apache.log4j.Logger;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class BankDepositService {

    private KieBeanFactory kieBeanFactory;
    private Logger log = Logger.getLogger(BankDepositService.class);

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
            log.error(e.getMessage());
        }
        return bankDeposits;
    }
}
