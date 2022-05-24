/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.boundary;

import com.project.trackersoft.entity.Factura;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author I7PRO
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "trackersoftPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }

    public void procesarFactura() {
        try {
            Connection cn = null;
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
            String user = "TRACKERSOFT";
            String password = "TRACKERSOFT";

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            cn = DriverManager.getConnection(url, user, password);
            CallableStatement cst = cn.prepareCall("{call pkg_facturacion.p_prueba(?,?)}");
            
            cst.setString(1, "hola");
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            
            String nombre = cst.getString(2);
            System.out.println("prueba: " + nombre);

        } catch (SQLException ex) {
            Logger.getLogger(FacturaFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
