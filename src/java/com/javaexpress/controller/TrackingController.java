
package com.javaexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Tracking")
public class TrackingController {
    
    @RequestMapping
    public String Tracking(Model model){
        String Tracking = null;
        return Tracking;
    }
    
    @RequestMapping("/trackingresult")
    public String trackingResultPage(Model model){
        String Tracking = null;
        return "trackingresult";
    }
    
}
