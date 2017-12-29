/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import com.javaexpress.dao.PengirimanDAO;
import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PengirimanDAO PDAO;

    @RequestMapping()
    public String halamanIndex(Model model) {
        InsertFormBean formInsertData = new InsertFormBean();
        List<Kota> kotas = PDAO.findAllKota();
        model.addAttribute("kota", kotas);
        model.addAttribute("insertData", formInsertData);
        return "insertdata";
    }

    @RequestMapping(value = "/kota")
    public String showAllProduct(Model model) {
        List<Kota> kotas = PDAO.findAllKota();
        model.addAttribute("kota", kotas);
        return "insertdatasuccess";
    }

    @RequestMapping(value = "/insert")
    public String insertData(@ModelAttribute("insertData") InsertFormBean insertFormBean, Model model) {
        Pengiriman pengiriman = new Pengiriman();
        Admin admin = new Admin();
        admin = PDAO.findAdminById(insertFormBean.getCreatedBy());
        Kota kotaPengirim = new Kota();
        kotaPengirim = PDAO.findKotaById(insertFormBean.getKotaPengirim());
        Kota kotaPenerima = new Kota();
        kotaPenerima =PDAO.findKotaById(insertFormBean.getKotaPenerima());
        Status status = new Status();
        status = PDAO.findStatusById(insertFormBean.getStatus());
        Tarif tarif = new Tarif();
        tarif = PDAO.findTarifById(insertFormBean.getTarif());
        //pengiriman.setNamaPengirim(insertFormBean.getNamaPengirim());
        //System.out.println("Nama Pengirim : " + pengiriman.getNamaPengirim());

        pengiriman.setNamaPengirim(insertFormBean.getNamaPengirim());
        pengiriman.setTeleponPengirim(insertFormBean.getTeleponPengirim());
        pengiriman.setKotaPenerima(kotaPengirim);
        pengiriman.setAlamatPengirim(insertFormBean.getAlamatPengirim());
        pengiriman.setNamaPenerima(insertFormBean.getNamaPenerima());
        pengiriman.setTeleponPenerima(insertFormBean.getTeleponPenerima());
        pengiriman.setKotaPenerima(kotaPenerima);
        pengiriman.setAlamatPenerima(insertFormBean.getAlamatPenerima());
        pengiriman.setTipePaket(insertFormBean.getTipePaket());
        pengiriman.setNamaPaket(insertFormBean.getNamaPaket());
        pengiriman.setBeratBarang(insertFormBean.getBeratBarang());
        pengiriman.setAsuransi(insertFormBean.getAsuransi());
        pengiriman.setHargaBarang(BigDecimal.valueOf(insertFormBean.getHargaBarang()));
        pengiriman.setJenisLayanan(insertFormBean.getJenisLayanan());
        pengiriman.setTarif(tarif);
        pengiriman.setTotalTarif(BigDecimal.valueOf(insertFormBean.getTotalTarif()));
        pengiriman.setNoResi(insertFormBean.getNoResi());
        pengiriman.setCreatedBy(admin);
        pengiriman.setUpdatedBy(admin);
        pengiriman.setCreatedTime(new Date());
        pengiriman.setUpdatedTime(new Date());
        pengiriman.setStatus(status);

        model.addAttribute("data", pengiriman);

        PDAO.savePengiriman(pengiriman);

        return "insertdatasuccess";
    }

}
