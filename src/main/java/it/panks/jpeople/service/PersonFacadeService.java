/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.service;

import it.panks.jpeople.model.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author paolo.panconi
 */

@Stateless
public class PersonFacadeService extends BaseEntityFacadeService<Person> implements IPersonFacadeService {

    @PersistenceContext
    private EntityManager em;
    
    public PersonFacadeService() {
        super(Person.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
