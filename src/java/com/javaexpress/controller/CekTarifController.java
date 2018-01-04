/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import com.javaexpress.bean.CekTarifFormBean;
import com.javaexpress.dao.CekTarifDAO;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/cektarif")
public class CekTarifController {

    @Autowired
    CekTarifDAO dao;

    @RequestMapping()
    public String halamanIndex(Model model) {
        CekTarifFormBean tarifFormBean = new CekTarifFormBean();
        List<Kota> kotas = dao.findAllKota();
        model.addAttribute("kota", kotas);
        model.addAttribute("cekTarif", tarifFormBean);
        return "cektarif";
    }
    
    @RequestMapping(value = "/tarif")
    public String tarif(@ModelAttribute("cekTarif") CekTarifFormBean tarifFormBean, Model model){
            Tarif tarif = new Tarif();
            Kota kotaAsal = new Kota();
            Pengiriman pengiriman = new Pengiriman();
            pengiriman.setBeratBarang(tarifFormBean.getBeratBarang());
            kotaAsal = dao.findKotaById(tarifFormBean.getKotaAsal());
            Kota kotaTujuan = new Kota();
            kotaTujuan = dao.findKotaById(tarifFormBean.getKotaTujuan());
            tarif = dao.findTarifByIdKota(kotaAsal,kotaTujuan);
            model.addAttribute("berat",pengiriman);
            model.addAttribute("kotaAsal", kotaAsal);
            model.addAttribute("kotaTujuan",kotaTujuan);
            model.addAttribute("tarif", tarif);
        return "detailtarif";
    }
}

