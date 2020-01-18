package com.evilcorp.brms.repository;

import com.evilcorp.brms.model.BankDeposit;
import com.evilcorp.brms.service.BankDepositService;

import java.util.*;

public class BankDepositRepository {

    private BankDepositService bankDepositService;
    private static Map<Long, BankDeposit> repo;

    static{
        repo = new LinkedHashMap<>();
    }

    public BankDepositRepository(){
        this.bankDepositService = new BankDepositService();
    }

    public void save(BankDeposit bankDeposit){
        if(bankDeposit != null){
            if(!repo.containsKey(bankDeposit.getId())){
                bankDepositService.applyInterestToDeposit(Collections.singletonList(bankDeposit));
                repo.put(bankDeposit.getId(), bankDeposit);
            }
        }
    }

    public void save(List<BankDeposit> bankDeposits){
        if(bankDeposits != null){
            bankDepositService.applyInterestToDeposit(bankDeposits);
            for(BankDeposit bankDeposit: bankDeposits){
                if(!repo.containsKey(bankDeposit.getId())){
                    repo.put(bankDeposit.getId(), bankDeposit);
                }
            }
        }
    }

    public BankDeposit getById(Long id){
        if(id != null){
            if(repo.containsKey(id)){
                return repo.get(id);
            }
        }
        return null;
    }

    public List<BankDeposit> getAll(){
        return new ArrayList<>(repo.values());
    }

    public void update(BankDeposit bankDeposit){
        if(bankDeposit != null && bankDeposit.getId() != null){
            if(repo.containsKey(bankDeposit.getId())){
                bankDepositService.applyInterestToDeposit(Collections.singletonList(bankDeposit));
                repo.put(bankDeposit.getId(), bankDeposit);
            }
        }
    }

    public void delete(Long id){
        if(id != null){
            repo.remove(id);
        }
    }


}
