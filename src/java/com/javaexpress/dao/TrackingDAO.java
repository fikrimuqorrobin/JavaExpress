/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Tracking;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class TrackingDAO implements TrackingDAOInterface {

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;
    @Override
    public List<Tracking> findAllTracking() {
    em = emf.createEntityManager();
    List<Tracking> listTracking;
    listTracking = em.createNamedQuery("Tarif.findAll").getResultList();
    return listTracking;
    }
    
}
