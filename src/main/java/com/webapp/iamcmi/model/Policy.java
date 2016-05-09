package com.webapp.iamcmi.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="POLICY")
public class Policy {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
}
