/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
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
public class PengirimanDAO {

    static final Logger logger = Logger.getLogger(PengirimanDAO.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Transactional
    public void savePengiriman(Pengiriman pengiriman) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pengiriman);
        em.getTransaction().commit();
        em.close();
//        double x = 100.0;
//        BigDecimal y = BigDecimal.valueOf(x);
    }

    public List<Kota> findAllKota() {
        em = emf.createEntityManager();
        List<Kota> kota;
        kota = this.em.createNamedQuery("Kota.findAll").getResultList();
        em.close();
        return kota;
    }

    public Admin findAdminById(int id) {

        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Admin.findByIdAdmin");
        query.setParameter("idAdmin", id);
        Admin admin = new Admin();
        admin = (Admin) query.getSingleResult();
        em.close();
        return admin;

    }
    
        public Kota findKotaById(int id) {

        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Kota.findByKodeKota");
        query.setParameter("kodeKota", id);
        Kota kota = new Kota();
        kota = (Kota) query.getSingleResult();
        em.close();
        return kota;

    }

    public Status findStatusById(int id) {

        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Status.findByIdStatus");
        query.setParameter("idStatus", id);
        Status status = new Status();
        status = (Status) query.getSingleResult();
        em.close();
        return status;

    }
    
        public Tarif findTarifById(int id) {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", id);
        Tarif tarif = new Tarif();
        tarif = (Tarif) query.getSingleResult();
        em.close();
        return tarif;

    }

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
}
