/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author paolo.panconi
 */
@Entity
@XmlRootElement
public class Person extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 255)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @Column(nullable = false, length = 255)
    @NotNull
    @Size(min = 1, max = 255)
    private String surname;
    
    @Column(nullable = false, length = 255)
    @NotNull
    @Size(min = 1, max = 255)
    private String fiscalcode;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    @Past
    private Date dateffBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFiscalcode() {
        return fiscalcode;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
    }

    public Date getDateffBirth() {
        return dateffBirth;
    }

    public void setDateffBirth(Date dateffBirth) {
        this.dateffBirth = dateffBirth;
    }

}
