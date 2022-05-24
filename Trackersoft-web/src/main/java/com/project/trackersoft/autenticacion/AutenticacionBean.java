/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.autenticacion;

import com.project.trackersoft.boundary.UsuarioFacade;
import com.project.trackersoft.entity.Usuario;
import com.project.trackersoft.entity.UsuarioRol;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author I7PRO
 */
@ManagedBean
@SessionScoped
public class AutenticacionBean implements Serializable {

    private static final long serialVersionUID = 3254181235309041386L;
    private static Logger log = Logger.getLogger(AutenticacionBean.class.getName());
    
    @EJB
    private UsuarioFacade userEJB;
    
    private String userLogin;
    private String pass;
    private Usuario usuario;

    public String login() {
        String ruta = null;
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(userLogin, pass);
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", null));
            return "login.xhtml";
        }
        Principal principal = request.getUserPrincipal();
        this.usuario = userEJB.findUserById(principal.getName());
        log.info("Authentication done for user: " + principal.getName());
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        List<UsuarioRol> usuarioRol = new ArrayList<UsuarioRol>(usuario.getUsuarioRolCollection());
           
        if (usuarioRol.get(0).getUsurolId() == new BigDecimal(1)) {
            sessionMap.put("administrador", usuario);
        } else if (usuarioRol.get(0).getUsurolId() == new BigDecimal(2)) {
            sessionMap.put("coordinador", usuario);
        } else if (usuarioRol.get(0).getUsurolId() == new BigDecimal(3)) {
            sessionMap.put("operador", usuario);
        }
        
        try {
            if (request.isUserInRole("administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("pages/administrador/index.xhtml?faces-redirect=true");
            ruta = "administrador/index.xhtml?faces-redirect=true";
            } else if (request.isUserInRole("coordinador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("pages/coordinador/index.xhtml?faces-redirect=true");
            ruta = "coordinador/index.xhtml?faces-redirect=true";
            } else if (request.isUserInRole("operador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("pages/operador/index.xhtml?faces-redirect=true");
                
            ruta = "operador/index.xhtml?faces-redirect=true";
            } else {
                ruta = "login.xhtml";
            }

        } catch (IOException ex) {
            Logger.getLogger(AutenticacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruta;
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            this.usuario = null;
            request.logout();
            // clear the session
            
             try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../login.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(AutenticacionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();
           
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
        }
        return "../../login.xhtml?faces-redirect=true";
    }

    public Usuario getAuthenticatedUser() {
        return usuario;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   
}
