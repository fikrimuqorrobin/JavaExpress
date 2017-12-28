package com.javaexpress.dao;

import com.javaexpress.model.Admin;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AdminDao {
    
    static final Logger logger = Logger.getLogger(AdminDao.class.getName());

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    public Admin findByUsername(String username) {
        Admin admin = new Admin();
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("Select a from Admin a where a.username = :username");
            query.setParameter("username", username);
            admin = (Admin) query.getSingleResult();
        } catch (NoResultException nre) {
            logger.severe("Username tidak ada");
        }
        return admin;
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
