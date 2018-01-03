
package com.javaexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceController {
    
    @RequestMapping()
    public String servicePage(Model model) {
        return "service";
    }
    
}
