/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.bean;

/**
 *
 * @author user
 */
public class ProvinsiBean {

    private String nama_provinsi;
    private int kode_provinsi;

    private String createdTime;
    private int status;
    private int createdBy = 1;
    private int updateBy = 1;

    public ProvinsiBean() {
    }

    public ProvinsiBean(String nama_provinsi, int kode_provinsi, String createdTime, int status) {
        this.nama_provinsi = nama_provinsi;
        this.kode_provinsi = kode_provinsi;
        this.createdTime = createdTime;
        this.status = status;
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
     * @return the updateBy
     */
    public int getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy the updateBy to set
     */
    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return the nama_provinsi
     */
    public String getNama_provinsi() {
        return nama_provinsi;
    }

    /**
     * @param nama_provinsi the nama_provinsi to set
     */
    public void setNama_provinsi(String nama_provinsi) {
        this.nama_provinsi = nama_provinsi;
    }

    /**
     * @return the kode_provinsi
     */
    public int getKode_provinsi() {
        return kode_provinsi;
    }

    /**
     * @param kode_provinsi the kode_provinsi to set
     */
    public void setKode_provinsi(int kode_provinsi) {
        this.kode_provinsi = kode_provinsi;
    }

}
