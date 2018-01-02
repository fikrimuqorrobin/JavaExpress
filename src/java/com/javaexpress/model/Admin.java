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
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByIdAdmin", query = "SELECT a FROM Admin a WHERE a.idAdmin = :idAdmin")
    , @NamedQuery(name = "Admin.findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username")
    , @NamedQuery(name = "Admin.findByNamaLengkap", query = "SELECT a FROM Admin a WHERE a.namaLengkap = :namaLengkap")
    , @NamedQuery(name = "Admin.findByCreatedTime", query = "SELECT a FROM Admin a WHERE a.createdTime = :createdTime")
    , @NamedQuery(name = "Admin.findByUpdatedTime", query = "SELECT a FROM Admin a WHERE a.updatedTime = :updatedTime")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_admin")
    private Integer idAdmin;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "nama_lengkap")
    private String namaLengkap;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Provinsi> provinsiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Provinsi> provinsiList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Pengiriman> pengirimanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Pengiriman> pengirimanList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Tarif> tarifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Tarif> tarifList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Kota> kotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Kota> kotaList1;
    @JoinColumn(name = "level", referencedColumnName = "id_level")
    @ManyToOne(optional = false)
    private LevelAdmin level;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Admin> adminList;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Admin> adminList1;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Tracking> trackingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Tracking> trackingList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<LevelAdmin> levelAdminList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<LevelAdmin> levelAdminList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Status> statusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Status> statusList1;

    public Admin() {
    }

    public Admin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(Integer idAdmin, String username, String password, String namaLengkap, Date createdTime, Date updatedTime) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
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
    public List<Provinsi> getProvinsiList1() {
        return provinsiList1;
    }

    public void setProvinsiList1(List<Provinsi> provinsiList1) {
        this.provinsiList1 = provinsiList1;
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

    @XmlTransient
    public List<Kota> getKotaList() {
        return kotaList;
    }

    public void setKotaList(List<Kota> kotaList) {
        this.kotaList = kotaList;
    }

    @XmlTransient
    public List<Kota> getKotaList1() {
        return kotaList1;
    }

    public void setKotaList1(List<Kota> kotaList1) {
        this.kotaList1 = kotaList1;
    }

    public LevelAdmin getLevel() {
        return level;
    }

    public void setLevel(LevelAdmin level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    @XmlTransient
    public List<Admin> getAdminList1() {
        return adminList1;
    }

    public void setAdminList1(List<Admin> adminList1) {
        this.adminList1 = adminList1;
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

    @XmlTransient
    public List<Tracking> getTrackingList1() {
        return trackingList1;
    }

    public void setTrackingList1(List<Tracking> trackingList1) {
        this.trackingList1 = trackingList1;
    }

    @XmlTransient
    public List<LevelAdmin> getLevelAdminList() {
        return levelAdminList;
    }

    public void setLevelAdminList(List<LevelAdmin> levelAdminList) {
        this.levelAdminList = levelAdminList;
    }

    @XmlTransient
    public List<LevelAdmin> getLevelAdminList1() {
        return levelAdminList1;
    }

    public void setLevelAdminList1(List<LevelAdmin> levelAdminList1) {
        this.levelAdminList1 = levelAdminList1;
    }

    @XmlTransient
    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @XmlTransient
    public List<Status> getStatusList1() {
        return statusList1;
    }

    public void setStatusList1(List<Status> statusList1) {
        this.statusList1 = statusList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmin != null ? idAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Admin[ idAdmin=" + idAdmin + " ]";
    }
    
}
