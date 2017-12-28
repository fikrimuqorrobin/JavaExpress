package com.javaexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class AdminController {

    @RequestMapping()
    public String halamanIndex(Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/{username}")
    public String tampilAdmin(Model model){
        return "index";
    }
}
