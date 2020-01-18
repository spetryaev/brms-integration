package com.evilcorp.brms;

import com.evilcorp.brms.controller.BankDepositController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class BRMSApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public BRMSApplication() {
        singletons.add(new BankDepositController());
    }

    @Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }
}
