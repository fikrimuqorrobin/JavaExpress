/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Kota;
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
public class KotaDAO  implements KotaDAOInterface{
    
    static final Logger logger = Logger.getLogger(KotaDAO.class.getName());
    
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
    public void saveKota(Kota kota) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(kota);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Kota findKotabyID(int kode_kota) {
        em = emf.createEntityManager();
        return em.find(Kota.class, kode_kota);
    }

    @Override
    public List<Kota> listKota() {
    em = emf.createEntityManager();
    List<Kota> listKota;
    listKota = em.createNamedQuery("Kota.findAll").getResultList();
    return listKota; 
    }
    
    
}
