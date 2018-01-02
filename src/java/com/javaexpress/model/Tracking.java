/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracking.findAll", query = "SELECT t FROM Tracking t")
    , @NamedQuery(name = "Tracking.findByIdTracking", query = "SELECT t FROM Tracking t WHERE t.idTracking = :idTracking")
    , @NamedQuery(name = "Tracking.findByStatusPengiriman", query = "SELECT t FROM Tracking t WHERE t.statusPengiriman = :statusPengiriman")
    , @NamedQuery(name = "Tracking.findByCreatedTime", query = "SELECT t FROM Tracking t WHERE t.createdTime = :createdTime")
    , @NamedQuery(name = "Tracking.findByUpdateTime", query = "SELECT t FROM Tracking t WHERE t.updateTime = :updateTime")})
public class Tracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tracking")
    private Integer idTracking;
    @Basic(optional = false)
    @Column(name = "status_pengiriman")
    private String statusPengiriman;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "kode_pengiriman", referencedColumnName = "id_pengiriman")
    @ManyToOne(optional = false)
    private Pengiriman kodePengiriman;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "created_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id_admin")
    @ManyToOne(optional = false)
    private Admin updatedBy;

    public Tracking() {
    }

    public Tracking(Integer idTracking) {
        this.idTracking = idTracking;
    }

    public Tracking(Integer idTracking, String statusPengiriman, Date createdTime, Date updateTime) {
        this.idTracking = idTracking;
        this.statusPengiriman = statusPengiriman;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }

    public Integer getIdTracking() {
        return idTracking;
    }

    public void setIdTracking(Integer idTracking) {
        this.idTracking = idTracking;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Pengiriman getKodePengiriman() {
        return kodePengiriman;
    }

    public void setKodePengiriman(Pengiriman kodePengiriman) {
        this.kodePengiriman = kodePengiriman;
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
        hash += (idTracking != null ? idTracking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracking)) {
            return false;
        }
        Tracking other = (Tracking) object;
        if ((this.idTracking == null && other.idTracking != null) || (this.idTracking != null && !this.idTracking.equals(other.idTracking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.Tracking[ idTracking=" + idTracking + " ]";
    }
    
}
