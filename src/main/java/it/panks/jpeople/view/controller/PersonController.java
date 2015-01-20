/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.view.controller;

import it.panks.jpeople.model.Person;
import it.panks.jpeople.service.ICrudService;
import it.panks.jpeople.service.IPersonFacadeService;
import it.panks.jpeople.view.util.BaseEntityConverter;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author paolo.panconi
 */
@Named("personController")
@SessionScoped
public class PersonController extends BaseCrudEntityController<Person> implements Serializable {

    @EJB
    private IPersonFacadeService facadeService;
    
    @Override
    Person makeNewEnityObject() {
       return new Person();
    }

    @Override
    protected ICrudService<Person> getFacade() {
        return facadeService;
    }
    
    @FacesConverter(forClass = Person.class)
    public static class PersonControllerConverter extends BaseEntityConverter<Person>{

        @Override
        public Object getControllerName() {
            //TODO get it from Annotation
            return "personController";
        }

        @Override
        public Class<Person> getEntityClass() {
            return Person.class;
        }
        
    }
    
    
    
}
