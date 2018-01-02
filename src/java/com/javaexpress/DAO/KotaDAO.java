/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.DAO;

import com.javaexpress.model.Kota;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class KotaDAO {
    private Integer kodeKota;
    private String namaKota;
    private Date createdTime;
    private Date updatedTime;
    private List<PengirimanDao> pengirimanList;
    private List<PengirimanDao> pengirimanList1;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public KotaDAO() {
    }
    
    public void StartDatabase(){
            emf = Persistence.createEntityManagerFactory("JavaExpressPU");
            em = emf.createEntityManager();
    }

    public void ClosedDatabase(){
        em.close();
        emf.close();
    }
    
    public Kota SelectKota(String namaKota){
    Kota kota = new Kota();
    StartDatabase();
    Query query = em.createQuery("SELECT e from Kota e WHERE e.namaKota=:param");
    query.setParameter("param", namaKota);
    kota = (Kota) query.getSingleResult();
    ClosedDatabase();
    return kota;
    }
    
   public int idKotaFromDatabase(String kota){
      StartDatabase();
      Query query = em.createQuery("SELECT e.kodeKota from Kota e where e.namaKota=:param");
      query.setParameter("param", kota);
      int x = (int) query.getSingleResult();
      ClosedDatabase();
      return x;
   }
    
    public List<Kota> ListKota(){
         List<Kota> lk = new ArrayList<>();
         StartDatabase();
         Query query = em.createQuery("SELECT e from Kota e");
         lk = query.getResultList();
         ClosedDatabase();
         return lk;
    }
    
    /**
     * @return the kodeKota
     */
    public Integer getKodeKota() {
        return kodeKota;
    }

    /**
     * @param kodeKota the kodeKota to set
     */
    public void setKodeKota(Integer kodeKota) {
        this.kodeKota = kodeKota;
    }

    /**
     * @return the namaKota
     */
    public String getNamaKota() {
        return namaKota;
    }

    /**
     * @param namaKota the namaKota to set
     */
    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    /**
     * @return the createdTime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return the updatedTime
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * @param updatedTime the updatedTime to set
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * @return the pengirimanList
     */
    public List<PengirimanDao> getPengirimanList() {
        return pengirimanList;
    }

    /**
     * @param pengirimanList the pengirimanList to set
     */
    public void setPengirimanList(List<PengirimanDao> pengirimanList) {
        this.pengirimanList = pengirimanList;
    }

    /**
     * @return the pengirimanList1
     */
    public List<PengirimanDao> getPengirimanList1() {
        return pengirimanList1;
    }

    /**
     * @param pengirimanList1 the pengirimanList1 to set
     */
    public void setPengirimanList1(List<PengirimanDao> pengirimanList1) {
        this.pengirimanList1 = pengirimanList1;
    }
    
}
