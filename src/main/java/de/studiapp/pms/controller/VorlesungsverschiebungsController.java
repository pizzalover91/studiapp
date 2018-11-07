package de.studiapp.pms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.studiapp.pms.service.VorlesungsverschiebungService;

/**
 * 
 * @author AH/DH
 * 
 * @return mv -> ModelAndView
 * 
 * Controller für Requestmapping/Routing der Vorlesungsverschiebungen
 *
 */

@Controller
@RequestMapping("/vv")
public class VorlesungsverschiebungsController {

	@Autowired
	private VorlesungsverschiebungService vorlesungsverschiebungService;

	@RequestMapping(value="/findAll")
	public ModelAndView vv() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "TEST TITLE VV aus VV CTRL");
		mv.addObject("message", "TEST MESSAGE aus VV CTRL");
		mv.addObject("vorlesungsverschiebungen", vorlesungsverschiebungService.listAll());
		mv.setViewName("vv");
		return mv;
       
    }



}