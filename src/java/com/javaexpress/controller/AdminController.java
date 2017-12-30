/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import com.javaexpress.bean.TarifBean;
import com.javaexpress.dao.TarifDao;
import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class AdminController {

    @Autowired
    TarifDao dao;

    @RequestMapping()
    public String halamanIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "/kota")
    public String showAll(Model model) {
        TarifBean trf = new TarifBean();
        List<Kota> kota = dao.showAllKota();
        List<Tarif> tf = dao.showAllTarif();
        model.addAttribute("tarif", tf);
        model.addAttribute("TarifBean", trf);
        model.addAttribute("kota", kota);
        return "Tarif";
    }
    
    @RequestMapping(value = "/datatarif")
    public String showAllTarif(Model model){
        List<Tarif> tf = dao.showAllTarif();
        model.addAttribute("tarif", tf);
        return "DataTarif";
    }

    @RequestMapping(value = "/save")
    public String tarifSave(@ModelAttribute("TarifBean") TarifBean tf) throws ParseException {
        Tarif tr = new Tarif();
        Admin admin = new Admin();
        admin = dao.getDataById(tf.getCreatedBy());
        Status status = new Status();
        status = dao.getDataStatusById(tf.getStatus());
//        DateFormat format = new SimpleDateFormat("yyyy-M-dd");

        tr.setKotaAsal(tf.getKotaAsal());
        tr.setKotaTujuan(tf.getKotaTujuan());
        tr.setReguler(BigDecimal.valueOf(tf.getReguler()));
        tr.setKilat(BigDecimal.valueOf(tf.getKilat()));
        tr.setOns(BigDecimal.valueOf(tf.getOns()));
        tr.setSds(BigDecimal.valueOf(tf.getSds()));
        tr.setHds(BigDecimal.valueOf(tf.getHds()));
        tr.setCreatedBy(admin);
        tr.setUpdatedBy(admin);
//        System.out.println("Datetime : "+format.parse(tf.getCreatedTime()));
//        tr.setCreatedTime(format.parse(tf.getCreatedTime()));
//        tr.setUpdatedTime(format.parse(tf.getUpdatedTime()));
        tr.setCreatedTime(new Date());
        tr.setUpdatedTime(new Date());
        tr.setStatus(status);
        dao.saveTarif(tr);
        return "redirect:../home/datatarif";
    }

}
