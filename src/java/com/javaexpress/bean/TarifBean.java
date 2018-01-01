/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.bean;

import javax.validation.constraints.DecimalMin;

/**
 *
 * @author user
 */
public class TarifBean {

    private int kotaAsal;
    private int kotaTujuan;
    @DecimalMin(value = "1.0", message = "Mohon Isi Harga Reguler Minimal {value}")
    private double reguler;
    
    @DecimalMin(value = "1.0", message = "Mohon Isi Harga Kilat Minimal {value}")
    private double kilat;
    
    @DecimalMin(value = "1.0", message = "Mohon Isi Harga ONS Minimal {value}")
    private double ons;
    
    @DecimalMin(value = "1.0", message = "Mohon Isi Harga SDS Minimal {value}")
    private double sds;
    
    @DecimalMin(value = "1.0", message = "Mohon Isi Harga HDS Minimal {value}")
    private double hds;
    
    private String createdTime;
    private int status;
    private int createdBy = 1;
    private int updatedBy = 1;

    public TarifBean() {
    }

    public TarifBean(int kotaAsal, int kotaTujuan, double reguler, double kilat, double ons, double sds, double hds, String createdTime, int status, int createdBy, int updatedBy) {
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.reguler = reguler;
        this.kilat = kilat;
        this.ons = ons;
        this.sds = sds;
        this.hds = hds;
        this.createdTime = createdTime;
        this.status = status;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    /**
     * @return the kotaAsal
     */
    public int getKotaAsal() {
        return kotaAsal;
    }

    /**
     * @param kotaAsal the kotaAsal to set
     */
    public void setKotaAsal(int kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    /**
     * @return the kotaTujuan
     */
    public int getKotaTujuan() {
        return kotaTujuan;
    }

    /**
     * @param kotaTujuan the kotaTujuan to set
     */
    public void setKotaTujuan(int kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    /**
     * @return the reguler
     */
    public double getReguler() {
        return reguler;
    }

    /**
     * @param reguler the reguler to set
     */
    public void setReguler(double reguler) {
        this.reguler = reguler;
    }

    /**
     * @return the kilat
     */
    public double getKilat() {
        return kilat;
    }

    /**
     * @param kilat the kilat to set
     */
    public void setKilat(double kilat) {
        this.kilat = kilat;
    }

    /**
     * @return the ons
     */
    public double getOns() {
        return ons;
    }

    /**
     * @param ons the ons to set
     */
    public void setOns(double ons) {
        this.ons = ons;
    }

    /**
     * @return the sds
     */
    public double getSds() {
        return sds;
    }

    /**
     * @param sds the sds to set
     */
    public void setSds(double sds) {
        this.sds = sds;
    }

    /**
     * @return the hds
     */
    public double getHds() {
        return hds;
    }

    /**
     * @param hds the hds to set
     */
    public void setHds(double hds) {
        this.hds = hds;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the createdBy
     */
    public int getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public int getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the createdTime
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
