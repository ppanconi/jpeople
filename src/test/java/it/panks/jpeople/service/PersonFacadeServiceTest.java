/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.service;

import it.panks.jpeople.model.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 *
 * @author paolo.panconi
 */
@RunWith(Arquillian.class)
public class PersonFacadeServiceTest {

    @EJB
    PersonFacadeService instance;

    Person  p1 = new Person();
       
    
    public PersonFacadeServiceTest() {
    }
    
    @BeforeClass
    public void makeTestData() {
        p1.setName("Paul");
        p1.setSurname("Panks");
        p1.setFiscalcode("PNCPLA74B19D612D");
        p1.setDateffBirth(new Date(1094, 1, 19));
        p1.setNotes("Me, or my data");
    }

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(PersonFacadeService.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void preparePersistenceTest() throws Exception {
        clearData();
        insertData();
//        startTransaction();
    }

    private void clearData() throws Exception {
//        utx.begin();
//        em.joinTransaction();
        System.out.println("Dumping old records...");
        instance.getEntityManager().getTransaction().begin();
        instance.getEntityManager().createQuery("delete from Person").executeUpdate();
//        utx.commit();
        instance.getEntityManager().getTransaction().commit();
    }

    private void insertData() throws Exception {
//        utx.begin();
//        em.joinTransaction();
        System.out.println("Inserting records...");
        instance.getEntityManager().getTransaction().begin();
        
        instance.getEntityManager().persist(p1);
        instance.getEntityManager().getTransaction().commit();
//        utx.commit();
        
        // clear the persistence context (first-level cache)
//        em.clear();
    }

//    private void startTransaction() throws Exception {
//        utx.begin();
//        em.joinTransaction();
//    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PersonFacadeService.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Person entity = p1;
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        
        assertNotNull(entity.getId());
    }

    /**
     * Test of edit method, of class PersonFacadeService.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Person entity = p1;
        instance.edit(entity);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PersonFacadeService.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Person entity = p1;
        instance.remove(entity);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PersonFacadeService.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Long id = 1L;
        Person expResult = p1;
        Person result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PersonFacadeService.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List<Person> expResult = new ArrayList<>();
        expResult.add(p1);
        List<Person> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class PersonFacadeService.
     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of count method, of class PersonFacadeService.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
