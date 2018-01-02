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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByIdStatus", query = "SELECT s FROM Status s WHERE s.idStatus = :idStatus")
    , @NamedQuery(name = "Status.findByStatus", query = "SELECT s FROM Status s WHERE s.status = :status")
    , @NamedQuery(name = "Status.findByCreatedTime", query = "SELECT s FROM Status s WHERE s.createdTime = :createdTime")
    , @NamedQuery(name = "Status.findByUpdatedTime", query = "SELECT s FROM Status s WHERE s.updatedTime = :updatedTime")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status")
    private Integer idStatus;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Provinsi> provinsiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Pengiriman> pengirimanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Tarif> tarifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Kota> kotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Admin> adminList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Tracking> trackingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<LevelAdmin> levelAdminList;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;

    public Status() {
    }

    public Status(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Status(Integer idStatus, String status, Date createdTime, Date updatedTime) {
        this.idStatus = idStatus;
        this.status = status;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public List<Provinsi> getProvinsiList() {
        return provinsiList;
    }

    public void setProvinsiList(List<Provinsi> provinsiList) {
        this.provinsiList = provinsiList;
    }

    @XmlTransient
    public List<Pengiriman> getPengirimanList() {
        return pengirimanList;
    }

    public void setPengirimanList(List<Pengiriman> pengirimanList) {
        this.pengirimanList = pengirimanList;
    }

    @XmlTransient
    public List<Tarif> getTarifList() {
        return tarifList;
    }

    public void setTarifList(List<Tarif> tarifList) {
        this.tarifList = tarifList;
    }

    @XmlTransient
    public List<Kota> getKotaList() {
        return kotaList;
    }

    public void setKotaList(List<Kota> kotaList) {
        this.kotaList = kotaList;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @XmlTransient
    public List<Tracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<Tracking> trackingList) {
        this.trackingList = trackingList;
    }

    @XmlTransient
    public List<LevelAdmin> getLevelAdminList() {
        return levelAdminList;
    }

    public void setLevelAdminList(List<LevelAdmin> levelAdminList) {
        this.levelAdminList = levelAdminList;
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
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Status[ idStatus=" + idStatus + " ]";
    }
    
}
