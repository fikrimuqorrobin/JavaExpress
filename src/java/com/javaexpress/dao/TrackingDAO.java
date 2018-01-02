/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Tracking;
import java.util.List;
import java.util.logging.Logger;
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

    static final Logger logger = Logger.getLogger(TrackingDAO.class.getName());

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
        logger.info("List All Tracking " + listTracking);
        return listTracking;
    }

}
