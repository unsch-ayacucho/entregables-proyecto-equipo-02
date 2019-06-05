package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public ModelAndView showBandejaEntrada() {
		ModelAndView model = new ModelAndView("home");
		
		return model;
	}

}
