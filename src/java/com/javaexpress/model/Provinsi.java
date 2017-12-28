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
@Table(name = "provinsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provinsi.findAll", query = "SELECT p FROM Provinsi p")
    , @NamedQuery(name = "Provinsi.findByKodeProvinsi", query = "SELECT p FROM Provinsi p WHERE p.kodeProvinsi = :kodeProvinsi")
    , @NamedQuery(name = "Provinsi.findByNamaProvinsi", query = "SELECT p FROM Provinsi p WHERE p.namaProvinsi = :namaProvinsi")
    , @NamedQuery(name = "Provinsi.findByCreatedTime", query = "SELECT p FROM Provinsi p WHERE p.createdTime = :createdTime")
    , @NamedQuery(name = "Provinsi.findByUpdatedTime", query = "SELECT p FROM Provinsi p WHERE p.updatedTime = :updatedTime")})
public class Provinsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kode_provinsi")
    private Integer kodeProvinsi;
    @Basic(optional = false)
    @Column(name = "nama_provinsi")
    private String namaProvinsi;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kodeProvinsi")
    private List<Kota> kotaList;

    public Provinsi() {
    }

    public Provinsi(Integer kodeProvinsi) {
        this.kodeProvinsi = kodeProvinsi;
    }

    public Provinsi(Integer kodeProvinsi, String namaProvinsi, Date createdTime, Date updatedTime) {
        this.kodeProvinsi = kodeProvinsi;
        this.namaProvinsi = namaProvinsi;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Integer getKodeProvinsi() {
        return kodeProvinsi;
    }

    public void setKodeProvinsi(Integer kodeProvinsi) {
        this.kodeProvinsi = kodeProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
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
    public List<Kota> getKotaList() {
        return kotaList;
    }

    public void setKotaList(List<Kota> kotaList) {
        this.kotaList = kotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeProvinsi != null ? kodeProvinsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provinsi)) {
            return false;
        }
        Provinsi other = (Provinsi) object;
        if ((this.kodeProvinsi == null && other.kodeProvinsi != null) || (this.kodeProvinsi != null && !this.kodeProvinsi.equals(other.kodeProvinsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Provinsi[ kodeProvinsi=" + kodeProvinsi + " ]";
    }
    
}
