/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller.bean;

/**
 *
 * @author user
 */
public class CekTarifFormBean {
    private int kotaAsal;
    private int KotaTujuan;
    private int beratBarang;


    public CekTarifFormBean() {
    }

    public CekTarifFormBean(int kotaAsal, int KotaTujuan) {
        this.kotaAsal = kotaAsal;
        this.KotaTujuan = KotaTujuan;
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
     * @return the KotaTujuan
     */
    public int getKotaTujuan() {
        return KotaTujuan;
    }

    /**
     * @param KotaTujuan the KotaTujuan to set
     */
    public void setKotaTujuan(int KotaTujuan) {
        this.KotaTujuan = KotaTujuan;
    }

    /**
     * @return the beratBarang
     */
    public int getBeratBarang() {
        return beratBarang;
    }

    /**
     * @param beratBarang the beratBarang to set
     */
    public void setBeratBarang(int beratBarang) {
        this.beratBarang = beratBarang;
    }

}