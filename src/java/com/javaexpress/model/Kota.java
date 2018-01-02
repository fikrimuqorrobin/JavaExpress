/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.model;

import java.io.Serializable;
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
@Table(name = "kota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kota.findAll", query = "SELECT k FROM Kota k")
    , @NamedQuery(name = "Kota.findByKodeKota", query = "SELECT k FROM Kota k WHERE k.kodeKota = :kodeKota")
    , @NamedQuery(name = "Kota.findByNamaKota", query = "SELECT k FROM Kota k WHERE k.namaKota = :namaKota")
    , @NamedQuery(name = "Kota.findByCreatedTime", query = "SELECT k FROM Kota k WHERE k.createdTime = :createdTime")
    , @NamedQuery(name = "Kota.findByUpdatedTime", query = "SELECT k FROM Kota k WHERE k.updatedTime = :updatedTime")})
public class Kota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kode_kota")
    private Integer kodeKota;
    @Basic(optional = false)
    @Column(name = "nama_kota")
    private String namaKota;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kotaPengirim")
    private List<Pengiriman> pengirimanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kotaPenerima")
    private List<Pengiriman> pengirimanList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kotaAsal")
    private List<Tarif> tarifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kotaTujuan")
    private List<Tarif> tarifList1;
    @JoinColumn(name = "kode_provinsi", referencedColumnName = "kode_provinsi")
    @ManyToOne(optional = false)
    private Provinsi kodeProvinsi;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;

    public Kota() {
    }

    public Kota(Integer kodeKota) {
        this.kodeKota = kodeKota;
    }

    public Kota(Integer kodeKota, String namaKota, Date createdTime, Date updatedTime) {
        this.kodeKota = kodeKota;
        this.namaKota = namaKota;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Integer getKodeKota() {
        return kodeKota;
    }

    public void setKodeKota(Integer kodeKota) {
        this.kodeKota = kodeKota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
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

    @XmlTransient
    public List<Pengiriman> getPengirimanList() {
        return pengirimanList;
    }

    public void setPengirimanList(List<Pengiriman> pengirimanList) {
        this.pengirimanList = pengirimanList;
    }

    @XmlTransient
    public List<Pengiriman> getPengirimanList1() {
        return pengirimanList1;
    }

    public void setPengirimanList1(List<Pengiriman> pengirimanList1) {
        this.pengirimanList1 = pengirimanList1;
    }

    @XmlTransient
    public List<Tarif> getTarifList() {
        return tarifList;
    }

    public void setTarifList(List<Tarif> tarifList) {
        this.tarifList = tarifList;
    }

    @XmlTransient
    public List<Tarif> getTarifList1() {
        return tarifList1;
    }

    public void setTarifList1(List<Tarif> tarifList1) {
        this.tarifList1 = tarifList1;
    }

    public Provinsi getKodeProvinsi() {
        return kodeProvinsi;
    }

    public void setKodeProvinsi(Provinsi kodeProvinsi) {
        this.kodeProvinsi = kodeProvinsi;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeKota != null ? kodeKota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kota)) {
            return false;
        }
        Kota other = (Kota) object;
        if ((this.kodeKota == null && other.kodeKota != null) || (this.kodeKota != null && !this.kodeKota.equals(other.kodeKota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Kota[ kodeKota=" + kodeKota + " ]";
    }
    
}
