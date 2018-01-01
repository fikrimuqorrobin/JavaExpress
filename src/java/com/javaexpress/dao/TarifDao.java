/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.bean.TarifBean;
import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void saveTarif(TarifBean tf) {
        Tarif tarif = new Tarif();
        Admin admin = getDataById(tf.getCreatedBy()); // ini untuk get Adminnya bor
        Status status = getDataStatusById(1); // by id disi 1, itu adalah Aktif
//        status = getDataStatusById(tf.getStatus());
//        DateFormat format = new SimpleDateFormat("yyyy-M-dd");

        tarif.setKotaAsal(tf.getKotaAsal());
        tarif.setKotaTujuan(tf.getKotaTujuan());
        tarif.setReguler(BigDecimal.valueOf(tf.getReguler()));
        tarif.setKilat(BigDecimal.valueOf(tf.getKilat()));
        tarif.setOns(BigDecimal.valueOf(tf.getOns()));
        tarif.setSds(BigDecimal.valueOf(tf.getSds()));
        tarif.setHds(BigDecimal.valueOf(tf.getHds()));
        tarif.setCreatedBy(admin);
        tarif.setUpdatedBy(admin);
//        System.out.println("Datetime : "+format.parse(tf.getCreatedTime()));
//        tr.setCreatedTime(format.parse(tf.getCreatedTime()));
//        tr.setUpdatedTime(format.parse(tf.getUpdatedTime()));
        tarif.setCreatedTime(new Date());
        tarif.setUpdatedTime(new Date());
        tarif.setStatus(status);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tarif);
        em.getTransaction().commit();
        em.close();
    }

    public List<Tarif> showAllTarif() {
        em = emf.createEntityManager();
        List<Tarif> trf;
        trf = em.createNamedQuery("Tarif.findAll").getResultList();
        return trf;
    }

    public List<Kota> showAllKota() {
        em = emf.createEntityManager();
        List<Kota> kota;
        kota = em.createNamedQuery("Kota.findAll").getResultList();
        return kota;
    }

    public Admin getDataById(int idAdmin) {
        em = emf.createEntityManager();
        Admin admin = new Admin();
        Query query = em.createNamedQuery("Admin.findByIdAdmin");
        query.setParameter("idAdmin", idAdmin);
        admin = (Admin) query.getSingleResult();
        return admin;
    }

    public Status getDataStatusById(int idStatus) {
        em = emf.createEntityManager();
        Status status = new Status();
        Query query = em.createNamedQuery("Status.findByIdStatus");
        query.setParameter("idStatus", idStatus);
        status = (Status) query.getSingleResult();
        return status;
    }

    public void updateStatus(int idTarif) {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", idTarif);
        Tarif tarif = (Tarif) query.getSingleResult();
        if (tarif.getStatus().getStatus().equals("Aktif")) {
            tarif.setStatus(getDataStatusById(2));
            tarif.setUpdatedTime(new Date()); // update berdasrakan tanggal dan jam
        } else {
            tarif.setStatus(getDataStatusById(1));
            tarif.setUpdatedTime(new Date()); // update berdasrakan tanggal dan jam
        }
        em.getTransaction().begin();
        em.merge(tarif);
        em.getTransaction().commit();
        em.close();
    }

    public Tarif getDataByIdTarif(int idTarif) {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", idTarif);
        Tarif tarif = new Tarif();
        tarif = (Tarif) query.getSingleResult();
        return tarif;
    }
    
    // UNTUK CEK KOTA SUDAH TERDAHTAR APA BELUM
    public Tarif getDataKotaAsal(int kotaAsal){
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByKotaAsal");
        query.setParameter("kotaAsal", kotaAsal);
        Tarif tarif = (Tarif) query.getSingleResult();
        return tarif;
    }
    public Tarif getDataKotaTujuan(int kotaTujuan){
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByKotaTujuan");
        query.setParameter("kotaTujuan", kotaTujuan);
        Tarif tarif = (Tarif) query.getSingleResult();
        return tarif;
    }
    // UNTUK CEK KOTA SUDAH TERDAHTAR APA BELUM

    public void updateTarif(TarifBean tf, int idTarif) throws ParseException {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Tarif.findByIdTarif");
        query.setParameter("idTarif", idTarif);
        Tarif tarif = (Tarif) query.getSingleResult();
        tarif.setReguler(BigDecimal.valueOf(tf.getReguler()));
        tarif.setKilat(BigDecimal.valueOf(tf.getKilat()));
        tarif.setOns(BigDecimal.valueOf(tf.getOns()));
        tarif.setSds(BigDecimal.valueOf(tf.getSds()));
        tarif.setHds(BigDecimal.valueOf(tf.getHds()));
        tarif.setUpdatedTime(new Date());
        Admin admin = getDataById(tf.getCreatedBy());
        tarif.setUpdatedBy(admin);
        em.getTransaction().begin();
        em.merge(tarif);
        em.getTransaction().commit();
        em.close();
    }
}
