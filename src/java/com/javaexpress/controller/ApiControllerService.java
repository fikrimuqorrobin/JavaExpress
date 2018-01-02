/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.controller;

import com.javaexpress.dao.TarifDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author user
 */

@RestController
@RequestMapping("/api")
public class ApiControllerService {
    
    @Autowired
    TarifDAO tarifDAO;
    
   
    
}
