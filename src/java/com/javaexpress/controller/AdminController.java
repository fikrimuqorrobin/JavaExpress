/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import com.javaexpress.bean.TarifBean;
import com.javaexpress.dao.TarifDao;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Status;
import com.javaexpress.model.Tarif;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showAll(Model model, HttpSession session) {
        TarifBean tarifBean = new TarifBean();
        List<Kota> kota = dao.showAllKota();
        List<Tarif> tarif = dao.showAllTarif();
        model.addAttribute("tarif", tarif);
        model.addAttribute("TarifBean", tarifBean);
        model.addAttribute("kota", kota);
        session.invalidate();
        return "Tarif";
    }

    @RequestMapping(value = "/save")
    public String tarifSave(@Valid @ModelAttribute("TarifBean") TarifBean tarifBean, BindingResult result, Model model, HttpSession session) {
        String tujuan = "";
        if (result.hasErrors() && dao.cekStatusKota(tarifBean) == false) {
            System.out.println("Masuk Errors");
            List<Tarif> tarif = dao.showAllTarif();
            List<Kota> kota = dao.showAllKota();
            model.addAttribute("TarifBean", tarifBean);
            model.addAttribute("tarif", tarif);
            model.addAttribute("kota", kota);
            session.setAttribute("validasi", "Data Gagal Disimpan Karena Kota Asal Dan Kota Tujuan Sudah Terdaftar");
            tujuan = "Tarif"; // kembalikan ke JSP jangan REDIRECT!, hati2 bro... 2 hari saya gak tidur grgr ini!
        } else {
            System.out.println("Masuk Ke Save...");
            dao.saveTarif(tarifBean);
            session.setAttribute("validasi", "Data Berhasil Disimpan");
            tujuan = "redirect:../home/kota";

        }
        return tujuan;
    }

    @RequestMapping(value = "/updateStatus/{idTarif}")
    public String updateStatus(@PathVariable Integer idTarif) {
        dao.updateStatus(idTarif);
        return "redirect:../kota";
    }

    @RequestMapping(value = "/Get/{idTarif}")
    public String showDataTarifById(@PathVariable Integer idTarif, Model model) {
        TarifBean tarifBean = new TarifBean();
        Tarif tarif = (Tarif) dao.getDataByIdTarif(idTarif);
        model.addAttribute("TarifBean", tarifBean);
        model.addAttribute("atrb", tarif);
        return "UpdateTarif";
    }

    @RequestMapping(value = "/updateTarif/{idTarif}")
    public String updateTarif(@ModelAttribute("TarifBean") TarifBean tarifBean, @PathVariable Integer idTarif) throws ParseException {
        dao.updateTarif(tarifBean, idTarif);
        return "redirect:../kota";
    }
}
