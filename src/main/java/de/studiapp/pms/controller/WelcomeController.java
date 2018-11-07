package de.studiapp.pms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author AH/DH
 * 
 * @return mv -> ModelAndView
 * 
 * Controller für Requestmapping/Routing /welcome
 *
 */


@Controller
public class WelcomeController {

	  @RequestMapping("/welcome")
	    public ModelAndView welcome() {

			ModelAndView mv = new ModelAndView();
			mv.addObject("title", "TEST TITLE aus welcome CTRL");
			mv.addObject("message", "TEST MESSAGE aus welcome CTRL");
			mv.setViewName("test");
			return mv;
	    }
}