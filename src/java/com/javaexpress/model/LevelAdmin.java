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
@Table(name = "level_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LevelAdmin.findAll", query = "SELECT l FROM LevelAdmin l")
    , @NamedQuery(name = "LevelAdmin.findByIdLevel", query = "SELECT l FROM LevelAdmin l WHERE l.idLevel = :idLevel")
    , @NamedQuery(name = "LevelAdmin.findByLevel", query = "SELECT l FROM LevelAdmin l WHERE l.level = :level")})
public class LevelAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_level")
    private Integer idLevel;
    @Basic(optional = false)
    @Column(name = "level")
    private String level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
    private List<Admin> adminList;

    public LevelAdmin() {
    }

    public LevelAdmin(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public LevelAdmin(Integer idLevel, String level) {
        this.idLevel = idLevel;
        this.level = level;
    }

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLevel != null ? idLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LevelAdmin)) {
            return false;
        }
        LevelAdmin other = (LevelAdmin) object;
        if ((this.idLevel == null && other.idLevel != null) || (this.idLevel != null && !this.idLevel.equals(other.idLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javaexpress.model.LevelAdmin[ idLevel=" + idLevel + " ]";
    }
    
}
