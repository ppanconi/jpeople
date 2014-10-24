/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.model;

import java.io.Serializable;

/**
 *
 * @author paolo.panconi
 */
public interface Entity {
    
    Serializable getId();

    Long getVersion();
    
    String getNotes();
}
