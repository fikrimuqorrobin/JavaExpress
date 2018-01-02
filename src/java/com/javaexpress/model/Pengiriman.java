/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "pengiriman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pengiriman.findAll", query = "SELECT p FROM Pengiriman p")
    , @NamedQuery(name = "Pengiriman.findByIdPengiriman", query = "SELECT p FROM Pengiriman p WHERE p.idPengiriman = :idPengiriman")
    , @NamedQuery(name = "Pengiriman.findByNamaPengirim", query = "SELECT p FROM Pengiriman p WHERE p.namaPengirim = :namaPengirim")
    , @NamedQuery(name = "Pengiriman.findByTeleponPengirim", query = "SELECT p FROM Pengiriman p WHERE p.teleponPengirim = :teleponPengirim")
    , @NamedQuery(name = "Pengiriman.findByNamaPenerima", query = "SELECT p FROM Pengiriman p WHERE p.namaPenerima = :namaPenerima")
    , @NamedQuery(name = "Pengiriman.findByTeleponPenerima", query = "SELECT p FROM Pengiriman p WHERE p.teleponPenerima = :teleponPenerima")
    , @NamedQuery(name = "Pengiriman.findByTipePaket", query = "SELECT p FROM Pengiriman p WHERE p.tipePaket = :tipePaket")
    , @NamedQuery(name = "Pengiriman.findByNamaPaket", query = "SELECT p FROM Pengiriman p WHERE p.namaPaket = :namaPaket")
    , @NamedQuery(name = "Pengiriman.findByBeratBarang", query = "SELECT p FROM Pengiriman p WHERE p.beratBarang = :beratBarang")
    , @NamedQuery(name = "Pengiriman.findByAsuransi", query = "SELECT p FROM Pengiriman p WHERE p.asuransi = :asuransi")
    , @NamedQuery(name = "Pengiriman.findByHargaBarang", query = "SELECT p FROM Pengiriman p WHERE p.hargaBarang = :hargaBarang")
    , @NamedQuery(name = "Pengiriman.findByJenisLayanan", query = "SELECT p FROM Pengiriman p WHERE p.jenisLayanan = :jenisLayanan")
    , @NamedQuery(name = "Pengiriman.findByTotalTarif", query = "SELECT p FROM Pengiriman p WHERE p.totalTarif = :totalTarif")
    , @NamedQuery(name = "Pengiriman.findByNoResi", query = "SELECT p FROM Pengiriman p WHERE p.noResi = :noResi")
    , @NamedQuery(name = "Pengiriman.findByCreatedTime", query = "SELECT p FROM Pengiriman p WHERE p.createdTime = :createdTime")
    , @NamedQuery(name = "Pengiriman.findByUpdatedTime", query = "SELECT p FROM Pengiriman p WHERE p.updatedTime = :updatedTime")})
public class Pengiriman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pengiriman")
    private Integer idPengiriman;
    @Basic(optional = false)
    @Column(name = "nama_pengirim")
    private String namaPengirim;
    @Basic(optional = false)
    @Column(name = "telepon_pengirim")
    private String teleponPengirim;
    @Basic(optional = false)
    @Lob
    @Column(name = "alamat_pengirim")
    private String alamatPengirim;
    @Basic(optional = false)
    @Column(name = "nama_penerima")
    private String namaPenerima;
    @Basic(optional = false)
    @Column(name = "telepon_penerima")
    private String teleponPenerima;
    @Basic(optional = false)
    @Lob
    @Column(name = "alamat_penerima")
    private String alamatPenerima;
    @Basic(optional = false)
    @Column(name = "tipe_paket")
    private String tipePaket;
    @Basic(optional = false)
    @Column(name = "nama_paket")
    private String namaPaket;
    @Basic(optional = false)
    @Column(name = "berat_barang")
    private int beratBarang;
    @Column(name = "asuransi")
    private Character asuransi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "harga_barang")
    private BigDecimal hargaBarang;
    @Basic(optional = false)
    @Column(name = "jenis_layanan")
    private String jenisLayanan;
    @Basic(optional = false)
    @Column(name = "total_tarif")
    private BigDecimal totalTarif;
    @Basic(optional = false)
    @Column(name = "no_resi")
    private String noResi;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @JoinColumn(name = "kota_pengirim", referencedColumnName = "kode_kota")
    @ManyToOne(optional = false)
    private Kota kotaPengirim;
    @JoinColumn(name = "kota_penerima", referencedColumnName = "kode_kota")
    @ManyToOne(optional = false)
    private Kota kotaPenerima;
    @JoinColumn(name = "tarif", referencedColumnName = "id_tarif")
    @ManyToOne(optional = false)
    private Tarif tarif;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kodePengiriman")
    private List<Tracking> trackingList;

    public Pengiriman() {
    }

    public Pengiriman(Integer idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    public Pengiriman(Integer idPengiriman, String namaPengirim, String teleponPengirim, String alamatPengirim, String namaPenerima, String teleponPenerima, String alamatPenerima, String tipePaket, String namaPaket, int beratBarang, String jenisLayanan, BigDecimal totalTarif, String noResi, Date createdTime, Date updatedTime) {
        this.idPengiriman = idPengiriman;
        this.namaPengirim = namaPengirim;
        this.teleponPengirim = teleponPengirim;
        this.alamatPengirim = alamatPengirim;
        this.namaPenerima = namaPenerima;
        this.teleponPenerima = teleponPenerima;
        this.alamatPenerima = alamatPenerima;
        this.tipePaket = tipePaket;
        this.namaPaket = namaPaket;
        this.beratBarang = beratBarang;
        this.jenisLayanan = jenisLayanan;
        this.totalTarif = totalTarif;
        this.noResi = noResi;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Integer getIdPengiriman() {
        return idPengiriman;
    }

    public void setIdPengiriman(Integer idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getTeleponPengirim() {
        return teleponPengirim;
    }

    public void setTeleponPengirim(String teleponPengirim) {
        this.teleponPengirim = teleponPengirim;
    }

    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getTeleponPenerima() {
        return teleponPenerima;
    }

    public void setTeleponPenerima(String teleponPenerima) {
        this.teleponPenerima = teleponPenerima;
    }

    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String getTipePaket() {
        return tipePaket;
    }

    public void setTipePaket(String tipePaket) {
        this.tipePaket = tipePaket;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public int getBeratBarang() {
        return beratBarang;
    }

    public void setBeratBarang(int beratBarang) {
        this.beratBarang = beratBarang;
    }

    public Character getAsuransi() {
        return asuransi;
    }

    public void setAsuransi(Character asuransi) {
        this.asuransi = asuransi;
    }

    public BigDecimal getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(BigDecimal hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public BigDecimal getTotalTarif() {
        return totalTarif;
    }

    public void setTotalTarif(BigDecimal totalTarif) {
        this.totalTarif = totalTarif;
    }

    public String getNoResi() {
        return noResi;
    }

    public void setNoResi(String noResi) {
        this.noResi = noResi;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Kota getKotaPengirim() {
        return kotaPengirim;
    }

    public void setKotaPengirim(Kota kotaPengirim) {
        this.kotaPengirim = kotaPengirim;
    }

    public Kota getKotaPenerima() {
        return kotaPenerima;
    }

    public void setKotaPenerima(Kota kotaPenerima) {
        this.kotaPenerima = kotaPenerima;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    public Admin getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Admin updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public List<Tracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<Tracking> trackingList) {
        this.trackingList = trackingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPengiriman != null ? idPengiriman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengiriman)) {
            return false;
        }
        Pengiriman other = (Pengiriman) object;
        if ((this.idPengiriman == null && other.idPengiriman != null) || (this.idPengiriman != null && !this.idPengiriman.equals(other.idPengiriman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Pengiriman[ idPengiriman=" + idPengiriman + " ]";
    }
    
}
