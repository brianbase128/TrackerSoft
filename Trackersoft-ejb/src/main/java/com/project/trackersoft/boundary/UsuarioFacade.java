/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.boundary;

import com.project.trackersoft.entity.Usuario;
import com.project.trackersoft.entity.UsuarioRol;
import com.project.trackersoft.util.AuthenticationUtils;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author I7PRO
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "trackersoftPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario findUserById(String id) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByUsuId", Usuario.class);
        query.setParameter("usuId", new BigDecimal(id));
        Usuario user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            // getSingleResult throws NoResultException in case there is no user in DB
            // ignore exception and return NULL for user instead
        }
        return user;
    }
    
    public Usuario createUser(Usuario user) {
        try {
            user.setUsuToken(AuthenticationUtils.encodeSHA256(user.getUsuToken()));
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        UsuarioRol group = new UsuarioRol();
        group.setUsuId(user);
//        group.setRolId(rolId);
//        group.setGroupname(Group.USERS_GROUP);
        em.persist(user);
        em.persist(group);
        
        return user;
    }

}
