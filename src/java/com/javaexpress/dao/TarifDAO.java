/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Tarif;
import java.util.List;
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
public class TarifDAO implements TarifDAOInterface {

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
    public void saveTarif(Tarif tarif) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tarif);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Tarif> findAllTarif() {
        em = emf.createEntityManager();
        List<Tarif> listTarif;
        listTarif = em.createNamedQuery("Tarif.findAll").getResultList();
        return listTarif;
    }

    @Override
    public Tarif findByIdTarif(int id) {
        em = emf.createEntityManager();

        Tarif tarif = new Tarif();
        tarif = (Tarif) em.createNamedQuery("Tarif.findByIdTarif").setParameter("idTarif", id).getSingleResult();
        return tarif;

    }

    @Override
    public void updateTarif(int id) {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", id);
        Tarif tarif = new Tarif();
        tarif = (Tarif) query.getSingleResult();
        em.getTransaction().begin();
        em.persist(tarif);
        em.getTransaction().commit();
        em.close();

    }
}
