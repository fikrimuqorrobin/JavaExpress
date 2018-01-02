/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Provinsi;
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
public class ProvinsiDAO implements ProvinsiDAOInterface {

    private static final Logger logger = Logger.getLogger(ProvinsiDAO.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Override
    public void saveProvinsi(Provinsi provinsi) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(provinsi);
        em.getTransaction().commit();
        logger.info("Provinsi Berhasil Disimpan " + provinsi.getNamaProvinsi() + " " + "Dibuat Oleh Admin ID " + provinsi.getCreatedBy());
        em.close();

    }

    @Override
    public List<Provinsi> findAllProvinsi() {
        em = emf.createEntityManager();
        List<Provinsi> listProvinsi;
        listProvinsi = em.createNamedQuery("Provinsi.findAll").getResultList();
        logger.info(("List All Provinsi "+listProvinsi));
        return listProvinsi;
    }

    @Override
    public Provinsi findById(int kode_provinsi) {
        em = emf.createEntityManager();
        em.find(Provinsi.class, kode_provinsi);
        logger.info("Pencarian ID "+kode_provinsi);
        return (Provinsi) em;
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
