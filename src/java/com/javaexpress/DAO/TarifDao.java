/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.DAO;

import com.javaexpress.DTO.TarifDto;
import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class TarifDao {
    private Integer idTarif;
    private int kotaAsal;
    private int kotaTujuan;
    private BigDecimal reguler;
    private BigDecimal kilat;
    private BigDecimal ons;
    private BigDecimal sds;
    private BigDecimal hds;
    private Date createdTime;
    private Date updatedTime;
    private List<PengirimanDao> pengirimanList;
    private EntityManagerFactory emf;
    private EntityManager em;
    private Tarif tarif;
    
    public TarifDao() {
    }

    public void StartDatabase(){
            emf = Persistence.createEntityManagerFactory("JavaExpressPU");
            em = emf.createEntityManager();
    }

    public void ClosedDatabase(){
        em.close();
        emf.close();
    }
    
    public List<TarifDto> SelectDatabaseTarifDto(){
     List<TarifDto> ldto = new ArrayList<>();
     List<Tarif> lt = new ArrayList<>();
     StartDatabase();
     Query query = em.createQuery("SELECT e from Tarif e");
     lt = query.getResultList();
        for (Tarif t : lt) {
           TarifDto tdto = new TarifDto();
           tdto.setKotaAsal(t.getKotaAsal().getNamaKota());
           tdto.setKotaTujuan(t.getKotaTujuan().getNamaKota());
           tdto.setReguler(t.getReguler());
           tdto.setKilat(t.getKilat());
           tdto.setOns(t.getOns());
           tdto.setSds(t.getSds());
           tdto.setHds(t.getHds());
           ldto.add(tdto);
        }
     ClosedDatabase();
     return ldto;
    }
    
    public int idTarif(Kota kotaAsal, Kota kotaTujuan){
    int id = 0;    
    StartDatabase();
    Query query = em.createQuery("SELECT e.idTarif FROM Tarif e where e.kotaAsal=:param1 AND e.kotaTujuan=:param2");
    query.setParameter("param1", kotaAsal);
    query.setParameter("param2", kotaTujuan);
    id = (int) query.getSingleResult();
    ClosedDatabase();
    return id;
    }
    
    public Tarif getTarif(int id){
        Tarif tarif = new Tarif();
        StartDatabase();
        Query query = em.createQuery("SELECT e from Tarif e where e.idTarif=:param");
        query.setParameter("param", id);
        tarif = (Tarif) query.getSingleResult();
        ClosedDatabase();
        return tarif;
    }
    
    public void InsertDataTarif(Kota kotaAsal, Kota kotaTujuan, double reguler, double kilat, 
                                           double ons,double sds, double hds ){
         StartDatabase();
         EntityTransaction et = em.getTransaction();
         et.begin();
         tarif = new Tarif();
         tarif.setKotaAsal(kotaAsal);
         tarif.setKotaTujuan(kotaTujuan);
         tarif.setReguler(BigDecimal.valueOf(reguler));
         tarif.setKilat(BigDecimal.valueOf(kilat));
         tarif.setOns(BigDecimal.valueOf(ons));
         tarif.setSds(BigDecimal.valueOf(sds));
         tarif.setHds(BigDecimal.valueOf(hds));
         tarif.setCreatedBy(new Admin(1));
         tarif.setUpdatedBy(new Admin(1));
         tarif.setStatus(new Status(1));
         tarif.setCreatedTime(new Date());
         tarif.setUpdatedTime(new Date());
         em.persist(tarif);
         et.commit();
         ClosedDatabase();
    }
    
    /**
     * @return the idTarif
     */
    public Integer getIdTarif() {
        return idTarif;
    }

    /**
     * @param idTarif the idTarif to set
     */
    public void setIdTarif(Integer idTarif) {
        this.idTarif = idTarif;
    }

    /**
     * @return the kotaAsal
     */
    public int getKotaAsal() {
        return kotaAsal;
    }

    /**
     * @param kotaAsal the kotaAsal to set
     */
    public void setKotaAsal(int kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    /**
     * @return the kotaTujuan
     */
    public int getKotaTujuan() {
        return kotaTujuan;
    }

    /**
     * @param kotaTujuan the kotaTujuan to set
     */
    public void setKotaTujuan(int kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    /**
     * @return the reguler
     */
    public BigDecimal getReguler() {
        return reguler;
    }

    /**
     * @param reguler the reguler to set
     */
    public void setReguler(BigDecimal reguler) {
        this.reguler = reguler;
    }

    /**
     * @return the kilat
     */
    public BigDecimal getKilat() {
        return kilat;
    }

    /**
     * @param kilat the kilat to set
     */
    public void setKilat(BigDecimal kilat) {
        this.kilat = kilat;
    }

    /**
     * @return the ons
     */
    public BigDecimal getOns() {
        return ons;
    }

    /**
     * @param ons the ons to set
     */
    public void setOns(BigDecimal ons) {
        this.ons = ons;
    }

    /**
     * @return the sds
     */
    public BigDecimal getSds() {
        return sds;
    }

    /**
     * @param sds the sds to set
     */
    public void setSds(BigDecimal sds) {
        this.sds = sds;
    }

    /**
     * @return the hds
     */
    public BigDecimal getHds() {
        return hds;
    }

    /**
     * @param hds the hds to set
     */
    public void setHds(BigDecimal hds) {
        this.hds = hds;
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
   
    
}
