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
@Table(name = "tarif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarif.findAll", query = "SELECT t FROM Tarif t")
    , @NamedQuery(name = "Tarif.findByIdTarif", query = "SELECT t FROM Tarif t WHERE t.idTarif = :idTarif")
    , @NamedQuery(name = "Tarif.findByReguler", query = "SELECT t FROM Tarif t WHERE t.reguler = :reguler")
    , @NamedQuery(name = "Tarif.findByKilat", query = "SELECT t FROM Tarif t WHERE t.kilat = :kilat")
    , @NamedQuery(name = "Tarif.findByOns", query = "SELECT t FROM Tarif t WHERE t.ons = :ons")
    , @NamedQuery(name = "Tarif.findBySds", query = "SELECT t FROM Tarif t WHERE t.sds = :sds")
    , @NamedQuery(name = "Tarif.findByHds", query = "SELECT t FROM Tarif t WHERE t.hds = :hds")
    , @NamedQuery(name = "Tarif.findByCreatedTime", query = "SELECT t FROM Tarif t WHERE t.createdTime = :createdTime")
    , @NamedQuery(name = "Tarif.findByUpdatedTime", query = "SELECT t FROM Tarif t WHERE t.updatedTime = :updatedTime")})
public class Tarif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarif")
    private Integer idTarif;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "reguler")
    private BigDecimal reguler;
    @Basic(optional = false)
    @Column(name = "kilat")
    private BigDecimal kilat;
    @Basic(optional = false)
    @Column(name = "ons")
    private BigDecimal ons;
    @Basic(optional = false)
    @Column(name = "sds")
    private BigDecimal sds;
    @Basic(optional = false)
    @Column(name = "hds")
    private BigDecimal hds;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarif")
    private List<Pengiriman> pengirimanList;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;
    @JoinColumn(name = "kota_asal", referencedColumnName = "kode_kota")
    @ManyToOne(optional = false)
    private Kota kotaAsal;
    @JoinColumn(name = "kota_tujuan", referencedColumnName = "kode_kota")
    @ManyToOne(optional = false)
    private Kota kotaTujuan;

    public Tarif() {
    }

    public Tarif(Integer idTarif) {
        this.idTarif = idTarif;
    }

    public Tarif(Integer idTarif, BigDecimal reguler, BigDecimal kilat, BigDecimal ons, BigDecimal sds, BigDecimal hds, Date createdTime, Date updatedTime) {
        this.idTarif = idTarif;
        this.reguler = reguler;
        this.kilat = kilat;
        this.ons = ons;
        this.sds = sds;
        this.hds = hds;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Integer getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(Integer idTarif) {
        this.idTarif = idTarif;
    }

    public BigDecimal getReguler() {
        return reguler;
    }

    public void setReguler(BigDecimal reguler) {
        this.reguler = reguler;
    }

    public BigDecimal getKilat() {
        return kilat;
    }

    public void setKilat(BigDecimal kilat) {
        this.kilat = kilat;
    }

    public BigDecimal getOns() {
        return ons;
    }

    public void setOns(BigDecimal ons) {
        this.ons = ons;
    }

    public BigDecimal getSds() {
        return sds;
    }

    public void setSds(BigDecimal sds) {
        this.sds = sds;
    }

    public BigDecimal getHds() {
        return hds;
    }

    public void setHds(BigDecimal hds) {
        this.hds = hds;
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

    public Kota getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(Kota kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public Kota getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(Kota kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarif != null ? idTarif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarif)) {
            return false;
        }
        Tarif other = (Tarif) object;
        if ((this.idTarif == null && other.idTarif != null) || (this.idTarif != null && !this.idTarif.equals(other.idTarif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Tarif[ idTarif=" + idTarif + " ]";
    }
    
}
