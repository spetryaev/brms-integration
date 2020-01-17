package ru.sfedu.brms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BankClient implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String fullName;

}
