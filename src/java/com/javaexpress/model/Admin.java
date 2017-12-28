/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.model;

import java.io.Serializable;
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
    , @NamedQuery(name = "Admin.findByNamaLengkap", query = "SELECT a FROM Admin a WHERE a.namaLengkap = :namaLengkap")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Tracking> trackingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private List<Tracking> trackingList1;

    public Admin() {
    }

    public Admin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(Integer idAdmin, String username, String password, String namaLengkap) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
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
