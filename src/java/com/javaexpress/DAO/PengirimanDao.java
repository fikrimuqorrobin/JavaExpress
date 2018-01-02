/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javaexpress.DAO;

import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Pengiriman;
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
public class PengirimanDao {
    private Integer idPengiriman;
    private String namaPengirim;
    private String teleponPengirim;
    private String alamatPengirim;
    private String namaPenerima;
    private String teleponPenerima;
    private String alamatPenerima;
    private String tipePaket;
    private String namaPaket;
    private int beratBarang;
    private Character asuransi;
    private BigDecimal hargaBarang;
    private String jenisLayanan;
    private BigDecimal totalTarif;
    private String noResi;
    private Date createdTime;
    private Date updatedTime;
    private KotaDAO kotaPengirim;
    private KotaDAO kotaPenerima;
    private TarifDao tarif;
    private List<TrackingDao> trackingList;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PengirimanDao() {
    }

    public void ActiveDatabase(){
         emf = Persistence.createEntityManagerFactory("JavaExpressPU");
         em = emf.createEntityManager();
         }
    
         public void CloseDatabase(){
         em.close();
         emf.close();
         }
         
         public Pengiriman getNoResi(String noResi){
         Pengiriman kiriman = new Pengiriman();
         ActiveDatabase();
         Query query = em.createQuery("SELECT e from Pengiriman e where e.noResi =:param");
         query.setParameter("param", noResi);
         kiriman =  (Pengiriman) query.getSingleResult();
         CloseDatabase();
         return kiriman;    
         }
         
         public List<Pengiriman> allListPengiriman(){
         List<Pengiriman> lp = new ArrayList<>();
         ActiveDatabase();
         Query query = em.createQuery("SELECT e from Pengiriman e");
         lp = query.getResultList();
         CloseDatabase();
         return lp;
         }
         
      
         public void UpdateDatabasePengiriman(int idPengiriman, Status status){
         
         ActiveDatabase();
         Pengiriman p = new Pengiriman();
         EntityTransaction et = em.getTransaction();
         et.begin();
         p = em.find(Pengiriman.class, idPengiriman);
         if(status.getIdStatus()==1)
         p.setStatus(new Status(2));
         if(status.getIdStatus()==2)
         p.setStatus(new Status(1));
         em.merge(p);
         et.commit();
         CloseDatabase();
         }
         
         
         
         public BigDecimal getTarif(String kotaAsal, String kotaTujuan ,double beratBarang, double hargaBarang,char asuransi, String jenisLayanan){
         BigDecimal nilaiAkhir = BigDecimal.ZERO;
         ActiveDatabase();
         TarifDao tarifDao = new TarifDao();
         int id = tarifDao.idTarif(new Kota(new KotaDAO().idKotaFromDatabase(kotaAsal)), new Kota(new KotaDAO().idKotaFromDatabase(kotaTujuan)));
           if(jenisLayanan.equalsIgnoreCase("reguler"))
           {
              if(asuransi=='T'){ 
              double hargaPaket = tarifDao.getTarif(id).getReguler().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(id).getReguler().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
           }
           else if(jenisLayanan.equalsIgnoreCase("kilat"))
           {
              if(asuransi == 'T'){
              double hargaPaket = tarifDao.getTarif(id).getKilat().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(id).getKilat().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
           }
           else if(jenisLayanan.equalsIgnoreCase("ons"))
           {
              if(asuransi=='T'){ 
              double hargaPaket = tarifDao.getTarif(id).getOns().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(id).getOns().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
           }
           else if(jenisLayanan.equalsIgnoreCase("sds"))
           { 
               if(asuransi=='T'){
              double hargaPaket = tarifDao.getTarif(id).getSds().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
               }
               else{
              double hargaPaket = tarifDao.getTarif(id).getSds().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai); 
               }
           }
           else if(jenisLayanan.equalsIgnoreCase("hds"))
           {
              if(asuransi=='T'){
              double hargaPaket = tarifDao.getTarif(id).getHds().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(id).getHds().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai); 
              }
           }
         CloseDatabase();
         return nilaiAkhir;
         }
         
         public void InsertDatabasePengiriman(String alamatPenerima, String alamatPengirim, char asuransi,double beratBarang,
            double hargaBarang, String jenisLayanan, String namaPaket, String namaPenerima, String namaPengirim, String noResi,
            String teleponPenerima, String teleponPengirim, String tipePaket, Kota KotaPenerima, Kota KotaPengirim, int idTarif){
    
           ActiveDatabase();
           EntityTransaction et = em.getTransaction();
           et.begin();
           Pengiriman p = new Pengiriman();
           p.setAlamatPenerima(alamatPenerima);// dalam bentuk form
           p.setAlamatPengirim(alamatPengirim); //dalam bentuk form 
           p.setAsuransi(asuransi); // dalam bentuk form (Y/T)
           p.setBeratBarang((int) beratBarang); //dalam bentuk form
           p.setCreatedBy(new Admin(1));
           p.setCreatedTime(new Date());
           p.setHargaBarang(BigDecimal.valueOf(hargaBarang)); //dalam bentuk form
           p.setJenisLayanan(jenisLayanan); //dalam bentuk form 
           p.setKotaPenerima(KotaPenerima); //diambil dari kelas kota
           p.setKotaPengirim(KotaPengirim); //diambil dari kelas kota
           p.setNamaPaket(namaPaket); //dalam bentuk form
           p.setNamaPenerima(namaPenerima); //dalam bentuk form
           p.setNamaPengirim(namaPengirim); //dalam bentuk form
           p.setNoResi(noResi);  //dalam bentu form
           p.setStatus(new Status(1));
           TarifDao tarifDao = new TarifDao();
           p.setTarif(tarifDao.getTarif(idTarif)); //diambil dari alamatPenerima dan alamatPengirim
           p.setTeleponPenerima(teleponPenerima); //dalam bentuk form
           p.setTeleponPengirim(teleponPengirim); //dalam bentuk form
           p.setTipePaket(tipePaket);  //dalam bentuk form
           BigDecimal nilaiAkhir = BigDecimal.ZERO;
           if(jenisLayanan.equals("reguler"))
           {
              if(asuransi=='T'){ 
              double hargaPaket = tarifDao.getTarif(idTarif).getReguler().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(idTarif).getReguler().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
           }
           else if(jenisLayanan.equalsIgnoreCase("kilat"))
           {
              if(asuransi == 'T'){
              double hargaPaket = tarifDao.getTarif(idTarif).getKilat().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(idTarif).getKilat().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
           }
           else if(jenisLayanan.equalsIgnoreCase("ons"))
           {
              if(asuransi=='T'){ 
              double hargaPaket = tarifDao.getTarif(idTarif).getOns().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(idTarif).getOns().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
           }
           else if(jenisLayanan.equalsIgnoreCase("sds"))
           { 
               if(asuransi=='T'){
              double hargaPaket = tarifDao.getTarif(idTarif).getSds().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
               }
               else{
              double hargaPaket = tarifDao.getTarif(idTarif).getSds().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai); 
               }
           }
           else if(jenisLayanan.equalsIgnoreCase("hds"))
           {
              if(asuransi=='T'){
              double hargaPaket = tarifDao.getTarif(idTarif).getHds().doubleValue();
              double nilai = hargaPaket*beratBarang;
              nilaiAkhir = BigDecimal.valueOf(nilai);
              }
              else{
              double hargaPaket = tarifDao.getTarif(idTarif).getHds().doubleValue();
              double nilai = hargaPaket*beratBarang+(hargaBarang*0.03);
              nilaiAkhir = BigDecimal.valueOf(nilai); 
              }
           }
           p.setTotalTarif(nilaiAkhir);  //diambil dari hasil kali berat dan tarif serta kalkulasi dengan asuransi (jika pilihan asuransi adalah 'Y')
           p.setTrackingList(new ArrayList<>(/*tracking*/));   
           p.setUpdatedBy(new Admin(1));
           p.setUpdatedTime(new Date());
           
           em.persist(p);
           
           et.commit();
           CloseDatabase();
         }
    
    /**
     * @return the idPengiriman
     */
    public Integer getIdPengiriman() {
        return idPengiriman;
    }

    /**
     * @param idPengiriman the idPengiriman to set
     */
    public void setIdPengiriman(Integer idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    /**
     * @return the namaPengirim
     */
    public String getNamaPengirim() {
        return namaPengirim;
    }

    /**
     * @param namaPengirim the namaPengirim to set
     */
    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    /**
     * @return the teleponPengirim
     */
    public String getTeleponPengirim() {
        return teleponPengirim;
    }

    /**
     * @param teleponPengirim the teleponPengirim to set
     */
    public void setTeleponPengirim(String teleponPengirim) {
        this.teleponPengirim = teleponPengirim;
    }

    /**
     * @return the alamatPengirim
     */
    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    /**
     * @param alamatPengirim the alamatPengirim to set
     */
    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    /**
     * @return the namaPenerima
     */
    public String getNamaPenerima() {
        return namaPenerima;
    }

    /**
     * @param namaPenerima the namaPenerima to set
     */
    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    /**
     * @return the teleponPenerima
     */
    public String getTeleponPenerima() {
        return teleponPenerima;
    }

    /**
     * @param teleponPenerima the teleponPenerima to set
     */
    public void setTeleponPenerima(String teleponPenerima) {
        this.teleponPenerima = teleponPenerima;
    }

    /**
     * @return the alamatPenerima
     */
    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    /**
     * @param alamatPenerima the alamatPenerima to set
     */
    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    /**
     * @return the tipePaket
     */
    public String getTipePaket() {
        return tipePaket;
    }

    /**
     * @param tipePaket the tipePaket to set
     */
    public void setTipePaket(String tipePaket) {
        this.tipePaket = tipePaket;
    }

    /**
     * @return the namaPaket
     */
    public String getNamaPaket() {
        return namaPaket;
    }

    /**
     * @param namaPaket the namaPaket to set
     */
    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    /**
     * @return the beratBarang
     */
    public int getBeratBarang() {
        return beratBarang;
    }

    /**
     * @param beratBarang the beratBarang to set
     */
    public void setBeratBarang(int beratBarang) {
        this.beratBarang = beratBarang;
    }

    /**
     * @return the asuransi
     */
    public Character getAsuransi() {
        return asuransi;
    }

    /**
     * @param asuransi the asuransi to set
     */
    public void setAsuransi(Character asuransi) {
        this.asuransi = asuransi;
    }

    /**
     * @return the hargaBarang
     */
    public BigDecimal getHargaBarang() {
        return hargaBarang;
    }

    /**
     * @param hargaBarang the hargaBarang to set
     */
    public void setHargaBarang(BigDecimal hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    /**
     * @return the jenisLayanan
     */
    public String getJenisLayanan() {
        return jenisLayanan;
    }

    /**
     * @param jenisLayanan the jenisLayanan to set
     */
    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    /**
     * @return the totalTarif
     */
    public BigDecimal getTotalTarif() {
        return totalTarif;
    }

    /**
     * @param totalTarif the totalTarif to set
     */
    public void setTotalTarif(BigDecimal totalTarif) {
        this.totalTarif = totalTarif;
    }

    /**
     * @return the noResi
     */
    public String getNoResi() {
        return noResi;
    }

    /**
     * @param noResi the noResi to set
     */
    public void setNoResi(String noResi) {
        this.noResi = noResi;
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
     * @return the kotaPengirim
     */
    public KotaDAO getKotaPengirim() {
        return kotaPengirim;
    }

    /**
     * @param kotaPengirim the kotaPengirim to set
     */
    public void setKotaPengirim(KotaDAO kotaPengirim) {
        this.kotaPengirim = kotaPengirim;
    }

    /**
     * @return the kotaPenerima
     */
    public KotaDAO getKotaPenerima() {
        return kotaPenerima;
    }

    /**
     * @param kotaPenerima the kotaPenerima to set
     */
    public void setKotaPenerima(KotaDAO kotaPenerima) {
        this.kotaPenerima = kotaPenerima;
    }

    /**
     * @return the tarif
     */
    public TarifDao getTarif() {
        return tarif;
    }

    /**
     * @param tarif the tarif to set
     */
    public void setTarif(TarifDao tarif) {
        this.tarif = tarif;
    }

    /**
     * @return the trackingList
     */
    public List<TrackingDao> getTrackingList() {
        return trackingList;
    }

    /**
     * @param trackingList the trackingList to set
     */
    public void setTrackingList(List<TrackingDao> trackingList) {
        this.trackingList = trackingList;
    }

    
}
