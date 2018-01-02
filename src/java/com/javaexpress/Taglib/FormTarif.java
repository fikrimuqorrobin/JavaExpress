/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.Taglib;

/**
 *
 * @author user
 */
public class FormTarif {
    private String kotaAsal;
    private String kotaTujuan;
    private double tarifReguler;
    private double tarifKilat;
    private double tarifOns;
    private double tarifSds;
    private double tarifHds;
    private String buttonInsert;
    public FormTarif() {
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
     * @return the tarifReguler
     */
    public double getTarifReguler() {
        return tarifReguler;
    }

    /**
     * @param tarifReguler the tarifReguler to set
     */
    public void setTarifReguler(double tarifReguler) {
        this.tarifReguler = tarifReguler;
    }

    /**
     * @return the tarifKilat
     */
    public double getTarifKilat() {
        return tarifKilat;
    }

    /**
     * @param tarifKilat the tarifKilat to set
     */
    public void setTarifKilat(double tarifKilat) {
        this.tarifKilat = tarifKilat;
    }

    /**
     * @return the tarifOns
     */
    public double getTarifOns() {
        return tarifOns;
    }

    /**
     * @param tarifOns the tarifOns to set
     */
    public void setTarifOns(double tarifOns) {
        this.tarifOns = tarifOns;
    }

    /**
     * @return the tarifSds
     */
    public double getTarifSds() {
        return tarifSds;
    }

    /**
     * @param tarifSds the tarifSds to set
     */
    public void setTarifSds(double tarifSds) {
        this.tarifSds = tarifSds;
    }

    /**
     * @return the tarifHds
     */
    public double getTarifHds() {
        return tarifHds;
    }

    /**
     * @param tarifHds the tarifHds to set
     */
    public void setTarifHds(double tarifHds) {
        this.tarifHds = tarifHds;
    }
    
}
