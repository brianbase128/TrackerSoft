package com.project.trackersoft.controller;

import com.project.trackersoft.boundary.CentroCostoFacade;
import com.project.trackersoft.entity.CentroCosto;
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

@ManagedBean(name = "centroCostoController")
@SessionScoped
public class CentroCostoController implements Serializable {

    @EJB
    private com.project.trackersoft.boundary.CentroCostoFacade ejbFacade;
    private List<CentroCosto> items = null;
    private CentroCosto selected;

    public CentroCostoController() {
    }

    public CentroCosto getSelected() {
        return selected;
    }

    public void setSelected(CentroCosto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CentroCostoFacade getFacade() {
        return ejbFacade;
    }

    public CentroCosto prepareCreate() {
        selected = new CentroCosto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        this.selected.setCcostUsuarioCreacion(BigInteger.ONE);
        this.selected.setCcostFechaCreacion(new Date());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CentroCostoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        this.selected.setCcostUsuarioModificacion(BigInteger.ONE);
        this.selected.setCcostFechaModificacion(new Date());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CentroCostoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CentroCostoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CentroCosto> getItems() {
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

    public List<CentroCosto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CentroCosto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CentroCosto.class)
    public static class CentroCostoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CentroCostoController controller = (CentroCostoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "centroCostoController");
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
            if (object instanceof CentroCosto) {
                CentroCosto o = (CentroCosto) object;
                return getStringKey(o.getCcostId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CentroCosto.class.getName()});
                return null;
            }
        }

    }

}
