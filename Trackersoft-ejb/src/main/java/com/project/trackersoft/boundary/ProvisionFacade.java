/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.boundary;

import com.project.trackersoft.entity.Provision;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author I7PRO
 */
@Stateless
public class ProvisionFacade extends AbstractFacade<Provision> {

    @PersistenceContext(unitName = "trackersoftPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvisionFacade() {
        super(Provision.class);
    }
    
}
