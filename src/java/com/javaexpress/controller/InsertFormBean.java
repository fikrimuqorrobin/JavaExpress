/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import java.util.Date;

/**
 *
 * @author user
 */
public class InsertFormBean {
    private String namaPengirim;
    private String teleponPengirim;
    private int kotaPengirim;
    private String alamatPengirim;  
    private String namaPenerima;
    private String teleponPenerima;
    private int kotaPenerima;
    private String alamatPenerima;
    private String tipePaket;
    private String namaPaket;
    private int beratBarang;
    private Character asuransi;
    private Double hargaBarang;
    private String jenisLayanan;
    private int tarif;
    private Double totalTarif;
    private String noResi;
    private int createdBy;
    private int updatedBy;
//    private String createdTime;
//    private String updatedTime;
    private int status;

    public InsertFormBean() {
    }

    public InsertFormBean(String namaPengirim, String teleponPengirim, int kotaPengirim, String alamatPengirim, String namaPenerima, String teleponPenerima, int kotaPenerima, String alamatPenerima, String tipePaket, String namaPaket, int beratBarang, Character asuransi, Double hargaBarang, String jenisLayanan, int tarif, Double totalTarif, String noResi, int createdBy, int updatedBy, int status) {
        this.namaPengirim = namaPengirim;
        this.teleponPengirim = teleponPengirim;
        this.kotaPengirim = kotaPengirim;
        this.alamatPengirim = alamatPengirim;
        this.namaPenerima = namaPenerima;
        this.teleponPenerima = teleponPenerima;
        this.kotaPenerima = kotaPenerima;
        this.alamatPenerima = alamatPenerima;
        this.tipePaket = tipePaket;
        this.namaPaket = namaPaket;
        this.beratBarang = beratBarang;
        this.asuransi = asuransi;
        this.hargaBarang = hargaBarang;
        this.jenisLayanan = jenisLayanan;
        this.tarif = tarif;
        this.totalTarif = totalTarif;
        this.noResi = noResi;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.status = status;
    }

    /**
     * @return the namaPengirim
     */
    public String getNamaPengirim() {
        return namaPengirim;
    }

    /**
     * @param namaPengirim the namaPengirim to set
     */
    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    /**
     * @return the teleponPengirim
     */
    public String getTeleponPengirim() {
        return teleponPengirim;
    }

    /**
     * @param teleponPengirim the teleponPengirim to set
     */
    public void setTeleponPengirim(String teleponPengirim) {
        this.teleponPengirim = teleponPengirim;
    }

    /**
     * @return the kotaPengirim
     */
    public int getKotaPengirim() {
        return kotaPengirim;
    }

    /**
     * @param kotaPengirim the kotaPengirim to set
     */
    public void setKotaPengirim(int kotaPengirim) {
        this.kotaPengirim = kotaPengirim;
    }

    /**
     * @return the alamatPengirim
     */
    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    /**
     * @param alamatPengirim the alamatPengirim to set
     */
    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    /**
     * @return the namaPenerima
     */
    public String getNamaPenerima() {
        return namaPenerima;
    }

    /**
     * @param namaPenerima the namaPenerima to set
     */
    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    /**
     * @return the teleponPenerima
     */
    public String getTeleponPenerima() {
        return teleponPenerima;
    }

    /**
     * @param teleponPenerima the teleponPenerima to set
     */
    public void setTeleponPenerima(String teleponPenerima) {
        this.teleponPenerima = teleponPenerima;
    }

    /**
     * @return the kotaPenerima
     */
    public int getKotaPenerima() {
        return kotaPenerima;
    }

    /**
     * @param kotaPenerima the kotaPenerima to set
     */
    public void setKotaPenerima(int kotaPenerima) {
        this.kotaPenerima = kotaPenerima;
    }

    /**
     * @return the alamatPenerima
     */
    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    /**
     * @param alamatPenerima the alamatPenerima to set
     */
    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    /**
     * @return the tipePaket
     */
    public String getTipePaket() {
        return tipePaket;
    }

    /**
     * @param tipePaket the tipePaket to set
     */
    public void setTipePaket(String tipePaket) {
        this.tipePaket = tipePaket;
    }

    /**
     * @return the namaPaket
     */
    public String getNamaPaket() {
        return namaPaket;
    }

    /**
     * @param namaPaket the namaPaket to set
     */
    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
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

    /**
     * @return the asuransi
     */
    public Character getAsuransi() {
        return asuransi;
    }

    /**
     * @param asuransi the asuransi to set
     */
    public void setAsuransi(Character asuransi) {
        this.asuransi = asuransi;
    }

    /**
     * @return the hargaBarang
     */
    public Double getHargaBarang() {
        return hargaBarang;
    }

    /**
     * @param hargaBarang the hargaBarang to set
     */
    public void setHargaBarang(Double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    /**
     * @return the jenisLayanan
     */
    public String getJenisLayanan() {
        return jenisLayanan;
    }

    /**
     * @param jenisLayanan the jenisLayanan to set
     */
    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    /**
     * @return the tarif
     */
    public int getTarif() {
        return tarif;
    }

    /**
     * @param tarif the tarif to set
     */
    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    /**
     * @return the totalTarif
     */
    public Double getTotalTarif() {
        return totalTarif;
    }

    /**
     * @param totalTarif the totalTarif to set
     */
    public void setTotalTarif(Double totalTarif) {
        this.totalTarif = totalTarif;
    }

    /**
     * @return the noResi
     */
    public String getNoResi() {
        return noResi;
    }

    /**
     * @param noResi the noResi to set
     */
    public void setNoResi(String noResi) {
        this.noResi = noResi;
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

    

    }