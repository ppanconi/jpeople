/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.service;

import it.panks.jpeople.model.Person;
import javax.ejb.Local;

/**
 *
 * @author paolo.panconi
 */
@Local
public interface IPersonFacadeService extends ICrudService<Person>{
    
}
