package com.evilcorp.brms.controller;


import com.evilcorp.brms.model.BankDeposit;
import com.evilcorp.brms.service.BankDepositService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/")
public class BankDepositController {

    private Logger log = Logger.getLogger(BankDepositController.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    private BankDepositService bankDepositService = new BankDepositService();

    @GET
    @Path("/data")
    public Response data() throws JsonProcessingException {
        log.info("GET request to /api/data");
        List<BankDeposit> bankDeposits = new ArrayList<>(Arrays.asList(
                new BankDeposit(500_000, 24),
                new BankDeposit(1_000_000, 24),
                new BankDeposit(500_000, 12),
                new BankDeposit(1_000_000, 12)
        ));

        bankDepositService.applyInterestToDeposit(bankDeposits);

        return Response.status(200).entity(objectMapper.writeValueAsString(bankDeposits)).build();
    }

}