/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.panks.jpeople.view.util;

import it.panks.jpeople.model.Entity;
import it.panks.jpeople.model.Person;
import it.panks.jpeople.view.controller.BaseCrudEntityController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author paolo.panconi
 */
public abstract class BaseEntityConverter<T> implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        BaseCrudEntityController controller = (BaseCrudEntityController) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, getControllerName());
        return controller.getEntityInstance(getKey(value));
    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        
        try {
            T o = getEntityClass().cast(object);
            if (o.getClass().isAssignableFrom(Entity.class)) {
                Entity e = (Entity) o;
                return getStringKey(e.getId());
            }
        } catch (ClassCastException ex) {}

        throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Person.class.getName());
    }

    public abstract Object getControllerName();

    public abstract Class<T> getEntityClass();
}
