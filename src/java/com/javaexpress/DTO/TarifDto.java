/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.DTO;

import com.javaexpress.model.Kota;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class TarifDto {
    private String kotaAsal;
    private String kotaTujuan;
    private BigDecimal reguler;
    private BigDecimal kilat;
    private BigDecimal ons;
    private BigDecimal sds;
    private BigDecimal hds;
    public static double asuransi = 0.03;

    
    
    public TarifDto() {
    }

    /**
     * @return the kotaAsal
     */
    public String getKotaAsal() {
        return kotaAsal;
    }

    /**
     * @param kotaAsal the kotaAsal to set
     */
    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    /**
     * @return the kotaTujuan
     */
    public String getKotaTujuan() {
        return kotaTujuan;
    }

    /**
     * @param kotaTujuan the kotaTujuan to set
     */
    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    /**
     * @return the reguler
     */
    public BigDecimal getReguler() {
        return reguler;
    }

    /**
     * @param reguler the reguler to set
     */
    public void setReguler(BigDecimal reguler) {
        this.reguler = reguler;
    }

    /**
     * @return the kilat
     */
    public BigDecimal getKilat() {
        return kilat;
    }

    /**
     * @param kilat the kilat to set
     */
    public void setKilat(BigDecimal kilat) {
        this.kilat = kilat;
    }

    /**
     * @return the ons
     */
    public BigDecimal getOns() {
        return ons;
    }

    /**
     * @param ons the ons to set
     */
    public void setOns(BigDecimal ons) {
        this.ons = ons;
    }

    /**
     * @return the sds
     */
    public BigDecimal getSds() {
        return sds;
    }

    /**
     * @param sds the sds to set
     */
    public void setSds(BigDecimal sds) {
        this.sds = sds;
    }

    /**
     * @return the hds
     */
    public BigDecimal getHds() {
        return hds;
    }

    /**
     * @param hds the hds to set
     */
    public void setHds(BigDecimal hds) {
        this.hds = hds;
    }

    /**
     * @return the asuransi
     */
    public static double getAsuransi() {
        return asuransi;
    }

    
    
}
