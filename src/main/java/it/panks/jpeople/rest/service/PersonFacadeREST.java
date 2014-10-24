/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.rest.service;

import it.panks.jpeople.model.Person;
import it.panks.jpeople.service.IPersonFacadeService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author paolo.panconi
 */
@Stateless
@Path("/person")
public class PersonFacadeREST  {
    
    @EJB
    private IPersonFacadeService bo;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Person entity) {
        bo.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Person entity) {
        bo.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        bo.remove(bo.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Person find(@PathParam("id") Long id) {
        return bo.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Person> findAll() {
        return bo.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Person> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return bo.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(bo.count());
    }

}
