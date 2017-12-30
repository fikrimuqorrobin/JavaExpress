/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class TarifDao {
    
    static final Logger logger = Logger.getLogger(TarifDao.class.getName());
    
    @PersistenceUnit
    EntityManagerFactory emf;
    
    private EntityManager em;
    
    @Transactional
    public void saveTarif(Tarif tarif){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tarif);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Tarif> showAllTarif(){
        em = emf.createEntityManager();
        List<Tarif> trf;
        trf = em.createNamedQuery("Tarif.findAll").getResultList();
        return trf;
    }
    
    public List<Kota> showAllKota(){
        em = emf.createEntityManager();
        List<Kota> kota;
        kota = em.createNamedQuery("Kota.findAll").getResultList();
        return kota;
    }
    
    public Admin getDataById(int idAdmin){
        em = emf.createEntityManager();
        Admin admin = new Admin();
        Query query = em.createNamedQuery("Admin.findByIdAdmin");
        query.setParameter("idAdmin", idAdmin);
        admin = (Admin) query.getSingleResult();
        return admin;
    }
    
    public Status getDataStatusById(int idStatus){
        em = emf.createEntityManager();
        Status status = new Status();
        Query query = em.createNamedQuery("Status.findByIdStatus");
        query.setParameter("idStatus", idStatus);
        status = (Status) query.getSingleResult();
        return status;
    }
}