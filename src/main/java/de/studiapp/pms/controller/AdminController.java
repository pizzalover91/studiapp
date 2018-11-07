package de.studiapp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author AH/DH
 * 
 * @return mv -> ModelAndView
 * 
 * Controller für Requestmapping/Routing zum Administationsbereich
 *
 */


@Controller
public class AdminController {

	  @RequestMapping("/admin")
	    public ModelAndView admin() {

			ModelAndView mv = new ModelAndView();
			mv.addObject("title", "TEST TITLE aus Admin-Controller/admin CTRL");
			mv.addObject("message", "TEST MESSAGE aus Admin-Controller/admin CTRL");
			mv.setViewName("admin");
			return mv;
	    }
	  
	  @RequestMapping("/login")
	  	public ModelAndView login() {
		  ModelAndView mv = new ModelAndView();
//		  mv.addObject("title", "Test Title aus Admin-Controller/login");
//		  mv.addObject("message", "Test Message aus Admin-Controller/login");
		  mv.setViewName("login");
		  return mv;
	  }
	  
	  @RequestMapping(value="/logout", method = RequestMethod.GET)
	  public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	      org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	          new SecurityContextLogoutHandler().logout(request, response, auth);
	      }
	      return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	  }
}