/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Status;
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
public class StatusDAO implements StatusDAOInterface {

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Override
    public void saveStatus(Status status) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(status);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Status> findAllStatus() {
        em = emf.createEntityManager();
        List<Status> listStatus;
        listStatus = em.createNamedQuery("Status.findAll").getResultList();
        return listStatus;

    }

    @Override
    public void updateStatus(int id) {

        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Status.findByIdStatus");
        query.setParameter("idStatus", id);
        Status status = new Status();
        status = (Status) query.getSingleResult();
        em.getTransaction().begin();
        em.merge(status);
        em.getTransaction().commit();
        em.close();
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
