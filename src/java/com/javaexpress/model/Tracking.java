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
    , @NamedQuery(name = "Tracking.findByStatus", query = "SELECT t FROM Tracking t WHERE t.status = :status")
    , @NamedQuery(name = "Tracking.findByTglUpdate", query = "SELECT t FROM Tracking t WHERE t.tglUpdate = :tglUpdate")})
public class Tracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tracking")
    private Integer idTracking;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "tgl_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglUpdate;
    @JoinColumn(name = "kode_pengiriman", referencedColumnName = "id_pengiriman")
    @ManyToOne(optional = false)
    private Pengiriman kodePengiriman;

    public Tracking() {
    }

    public Tracking(Integer idTracking) {
        this.idTracking = idTracking;
    }

    public Tracking(Integer idTracking, String status, Date tglUpdate) {
        this.idTracking = idTracking;
        this.status = status;
        this.tglUpdate = tglUpdate;
    }

    public Integer getIdTracking() {
        return idTracking;
    }

    public void setIdTracking(Integer idTracking) {
        this.idTracking = idTracking;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }

    public Pengiriman getKodePengiriman() {
        return kodePengiriman;
    }

    public void setKodePengiriman(Pengiriman kodePengiriman) {
        this.kodePengiriman = kodePengiriman;
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
        return "com.muqorrobin.model.Tracking[ idTracking=" + idTracking + " ]";
    }
    
}
