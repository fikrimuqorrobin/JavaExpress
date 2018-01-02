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
public class TrackingDAO {

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
 
    public Pengiriman findbyNoResi (String no_resi){
      Pengiriman pengiriman = new Pengiriman();
      try{
          em = emf.createEntityManager();
            Query query = em.createQuery("Select p from pengiriman p where p.no_resi = :no_resi");
            query.setParameter("no_resi", no_resi);
            pengiriman = (Pengiriman) query.getSingleResult();
        } catch (NoResultException nre) {
            logger.severe("No Resi Tidak Ada");
        }
        return pengiriman;
      }
 
    public List<Tracking> tampilListNoResi(){
        em = emf.createEntityManager();
        List<Tracking> tracking;
        tracking = em.createNamedQuery("Pengiriman.findByNoResi").getResultList();
        return tracking;
        
    }
    public Tracking findByResiID (Integer id_tracking){
        em = emf.createEntityManager();
        return em.find(Tracking.class, id_tracking);
     }
        public Status findStatusByNoResi(Integer id_status){
            em = emf.createEntityManager();
           return em.find(Status.class, id_status);
     }

    public List<Tracking> findbyNoResi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
