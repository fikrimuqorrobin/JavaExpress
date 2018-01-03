
package com.javaexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/contactus")
public class ContactController {

    @RequestMapping()
    public String contactPage(Model model) {
        return "contactus";
    }
}
