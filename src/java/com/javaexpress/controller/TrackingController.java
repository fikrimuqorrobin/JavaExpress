package com.javaexpress.controller;

import com.javaexpress.DAO.TrackingDao;
import com.javaexpress.Taglib.FormTarif;
import com.javaexpress.Taglib.FormTracking;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("Consumer")
public class TrackingController {
    @RequestMapping("trackingBarang")
    public String trackingData(Model model, @RequestParam("ft") FormTracking formTracking){
                
        TrackingDao tdao = new TrackingDao();
        tdao.selectTracking(formTracking.getNoResi());
        return "trackingBarang";
    }
    
    @RequestMapping("hasilTracking")
    public String hasilTracking(Model model, @RequestParam("ft") FormTracking formTracking )
    {
        
        return "trackingBarang";
    }
}

