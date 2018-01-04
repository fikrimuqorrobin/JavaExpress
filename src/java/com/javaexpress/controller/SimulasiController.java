
package com.javaexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/simulasi")
public class SimulasiController {
    
    @RequestMapping()
    public String simulasiPage(Model model){
        return "simulasi";
    }
    
    @RequestMapping("/simulasiresult")
    public String simulasiResultPage(Model model){
        return "simulasiresult";
    }
    
}
