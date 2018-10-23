/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.spvpetromoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nando Cortez
 */
@Controller

public class EstatisticaController {
    
    @GetMapping("/estatisticas")
    public ModelAndView estatisticas(ModelAndView model){
        model.setViewName("estatisticas_view");
     
        return model;
    }
    
}
