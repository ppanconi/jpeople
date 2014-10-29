/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author paolo.panconi
 */
@RunWith(JUnit4.class)
public class PersonTest {
    
    Person p1 = new Person();
    Person p2 = new Person();
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testEquality() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Object not equals", p1, p2 );
        
        p1.setId(1L);
        p2.setId(2L);
        
        assertNotSame("Differtnt object are copareted as same" , p1, p2);
    }
    
    @org.junit.Test
    public void testSerialization() {
        p1.setId(1L);
        p1.setVersion(1L);
        p1.setNotes("test notes");
        
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        
        
        try {
            ObjectOutputStream oout = new ObjectOutputStream(bout);
            
            oout.writeObject(p1);
            
            ByteArrayInputStream i = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(i);
            
            p2 = (Person) oi.readObject();
            
            assertEquals(p1, p2);
            
        } catch (IOException ex) {
            Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Serialization fail " +   ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    
    
}
