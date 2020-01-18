package com.evilcorp.brms.controller;


import com.evilcorp.brms.model.BankDeposit;
import com.evilcorp.brms.repository.BankDepositRepository;
import com.evilcorp.brms.service.BankDepositService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.Body;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/")
public class BankDepositController {

    private Logger log = Logger.getLogger(BankDepositController.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    private BankDepositRepository repository = new BankDepositRepository();

    @GET
    @Path("/deposit/{id}")
    public Response getById(@PathParam("id") Long id) throws JsonProcessingException {
        log.info("GET request to /api/deposit/" + id);
        BankDeposit deposit = repository.getById(id);
        return Response.status(200).entity(objectMapper.writeValueAsString(deposit)).build();
    }

    @GET
    @Path("/deposit")
    public Response getAll() throws JsonProcessingException {
        log.info("GET request to /api/deposit");
        List<BankDeposit> deposits = repository.getAll();
        return Response.status(200).entity(objectMapper.writeValueAsString(deposits)).build();
    }

    @POST
    @Path("/deposit")
    @Consumes("application/json")
    public Response save(String json){
        log.info("POST request to /api/deposit");
        try {
            BankDeposit bankDeposit = objectMapper.readValue(json, BankDeposit.class);
            repository.save(bankDeposit);
            return Response.status(200).build();
        } catch (IOException e) {
            log.info(e.getMessage());
            return Response.status(500).build();
        }
    }

}