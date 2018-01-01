/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.validator;

import com.javaexpress.bean.TarifBean;
import com.javaexpress.dao.TarifDao;
import com.javaexpress.model.Tarif;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author user
 */
@Component
public class TarifValidation implements Validator{

    @Autowired
    TarifDao dao;
    
    @Override
    public boolean supports(Class clazz) {
        return TarifBean.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "kotaAsal", "tarifBean.kotaAsal.empty");
        ValidationUtils.rejectIfEmpty(errors, "kotaTujuan", "tarifBean.kotaTujuan.empty");
        
        TarifBean tarifBean = (TarifBean) target;
        int kotaAsalBean = tarifBean.getKotaAsal();
        int kotaTujuanBean = tarifBean.getKotaTujuan();
        Tarif kotaAsal = dao.getDataKotaAsal(kotaAsalBean);
        Tarif kotaTujaun = dao.getDataKotaTujuan(kotaTujuanBean);
        if(kotaAsal.getIdTarif() == kotaTujaun.getIdTarif()){
            System.out.println("Masuk Karena Kota Asal Dan Tujuan Sudah ada");
            errors.rejectValue("kotaAsal", "tarifBean.kotaAsal.already");
            errors.rejectValue("kotaTujuan", "tarifBean.kotaTujuan.already");
        }
    }
    
    
}
