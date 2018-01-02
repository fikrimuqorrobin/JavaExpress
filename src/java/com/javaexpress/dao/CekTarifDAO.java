/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Kota;
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
public class CekTarifDAO {

    static final Logger logger = Logger.getLogger(CekTarifDAO.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    public List<Kota> findAllKota() {
        em = emf.createEntityManager();
        List<Kota> kota;
        kota = this.em.createNamedQuery("Kota.findAll").getResultList();
        em.close();
        return kota;
    }

    public Tarif findTarifByIdKota(Kota kotaAsal, Kota kotaTujuan) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT t FROM Tarif t WHERE t.kotaAsal = :kotaAsal AND t.kotaTujuan = :kotaTujuan");
        query.setParameter("kotaAsal", kotaAsal);
        query.setParameter("kotaTujuan", kotaTujuan);
        Tarif tarif = new Tarif();
        tarif = (Tarif) query.getSingleResult();
        em.close();
        return tarif;
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
}
