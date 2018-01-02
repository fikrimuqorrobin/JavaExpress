/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import com.javaexpress.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/index")
public class MainController {
    
    
    @Autowired
    TarifDAO tarifDAO;
    
    @Autowired
    TrackingDAO trackingDAO;
    
    
    @RequestMapping()
    public String index(){
        
        return "mainIndex";
    }
    @RequestMapping(value="/simulasi")
    public String simulasiHarga(Model model){
        
        return "simulasiHarga";
     }
    @RequestMapping(value="/cektracking")
    public String cekTracking(Model model){
        return "tracking";
    }
    @RequestMapping("/about")
    public String aboutMe(Model model){
        
        return "about";
    }
    @RequestMapping("/produk")
    public String produkContent(Model model){
        
        return "produkLayanan";
    }
    
}
