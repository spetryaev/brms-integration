package ru.sfedu.brms;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import ru.sfedu.brms.config.KieBeanFactory;
import ru.sfedu.brms.model.BankDeposit;

import java.io.IOException;

public class BRMSApplication {

    public static void main(String[] args) {
        System.out.println("Hey");
        /*BankDepositService service = new BankDepositService();
        BankDeposit deposit = new BankDeposit();
        deposit.setAmount(1);
        deposit.setTerm(0);
        deposit.setInterest(0);
        service.applyInterestAmountToDeposit(deposit);*/

        KieBeanFactory factory = new KieBeanFactory();
        try {
            KieSession kieSession = factory.getKieSession();
            BankDeposit deposit = new BankDeposit();
            deposit.setAmount(1);
            deposit.setTerm(2);
            deposit.setInterest(3);

            kieSession.insert(deposit);
            kieSession.fireAllRules();
            System.out.println(deposit.getInterestAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
