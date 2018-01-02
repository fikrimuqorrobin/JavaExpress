/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Pengiriman;
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
public class PengirimanDAO implements PengirimanDAOInterface {
    
    private static final Logger logger = Logger.getLogger(PengirimanDAO.class.getName());
    
    @PersistenceUnit
    EntityManagerFactory emf;
    
    private EntityManager em;

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

    @Override
    public void savePengiriman(Pengiriman pengiriman) {
    em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(pengiriman);
    em.getTransaction().commit();
    logger.info("Pengiriman Berhasil Disimpan "+pengiriman);
    em.close();
    }

    @Override
    public List<Pengiriman> findAllPengiriman() {
        em = emf.createEntityManager();
        List<Pengiriman> listPengiriman;
        listPengiriman = em.createNamedQuery("Pengiriman.findAll").getResultList();
        logger.info("Pengiriman All Data " +listPengiriman );
        return listPengiriman;
    }

    @Override
    public Pengiriman findById(int id) {
        em  =  emf.createEntityManager();
        em.find(Pengiriman.class, id);
        logger.info("Pencarian Pengiriman ID "+id);
        return (Pengiriman) em;
    }

    @Override
    public Pengiriman findByNoPengiriman(String nopengiriman) {
        em = emf.createEntityManager();
        em.createNamedQuery("Pengiriman.findByNoResi").setParameter("noResi", nopengiriman).getSingleResult();
        logger.info("Pencarian No Pengiriman "+nopengiriman);
        return (Pengiriman) em;
    }
}
