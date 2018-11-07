package de.studiapp.pms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author AH/DH
 * 
 * @category controller
 * 
 * handling ./ routing
 *
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}