/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tracking;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
    static final Logger logger = Logger.getLogger(TrackingDAO.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Pengiriman findbyNoResi(String NoResi) {
        Pengiriman pengiriman = null;
       
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("Select p from Pengiriman p where p.noResi = :NoResi");
            query.setParameter("NoResi", NoResi);
            pengiriman = (Pengiriman) query.getSingleResult();
           } catch (NoResultException nre) {
            logger.severe("No Resi Tidak Ada " + nre.getMessage());
        }
        return pengiriman;
    }

    public List<Tracking> tampilListNoResi() {
        em = emf.createEntityManager();
        List<Tracking> listTracking;
        listTracking = this.em.createNamedQuery("Tracking.findAll").getResultList();
        return listTracking;
    }

    public Tracking findByResiID(Integer id_tracking) {
        em = emf.createEntityManager();
        return em.find(Tracking.class, id_tracking);
    }

    public Status findStatusByNoResi(Integer id_status) {
        em = emf.createEntityManager(); 
        return em.find(Status.class, id_status);
    }

    public Tracking findTrackingByID(int id_pengiriman) {
        em = emf.createEntityManager();
        return em.find(Tracking.class, id_pengiriman);
    }

    @Override
    public void updateTracking(Tracking tracking) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tracking);
        em.getTransaction().commit();
        em.close();
    }
}
