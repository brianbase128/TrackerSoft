package com.project.trackersoft.controller;

import com.project.trackersoft.boundary.ActividadFacade;
import com.project.trackersoft.entity.Actividad;
import com.project.trackersoft.controller.util.JsfUtil;
import com.project.trackersoft.controller.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "actividadController")
@SessionScoped
public class ActividadController implements Serializable {

    @EJB
    private com.project.trackersoft.boundary.ActividadFacade ejbFacade;
    private List<Actividad> items = null;
    private Actividad selected;

    public ActividadController() {
    }

    public Actividad getSelected() {
        return selected;
    }

    public void setSelected(Actividad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ActividadFacade getFacade() {
        return ejbFacade;
    }

    public Actividad prepareCreate() {
        selected = new Actividad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        this.selected.setActFechaCreacion(new Date());
        this.selected.setActUsuarioCreacion(BigInteger.ONE);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ActividadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        this.selected.setActFechaModificacion(new Date());
        this.selected.setActUsuarioModificacion(BigInteger.ONE);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ActividadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ActividadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Actividad> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Actividad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Actividad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Actividad.class)
    public static class ActividadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActividadController controller = (ActividadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actividadController");
            return controller.getFacade().find(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Actividad) {
                Actividad o = (Actividad) object;
                return getStringKey(o.getActId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Actividad.class.getName()});
                return null;
            }
        }

    }

}
