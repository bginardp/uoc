package es.uoc.precintes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uoc.precintes.service.PrecintesService;

@Controller
public class AltresController {
	@Autowired
	PrecintesService precService;
	
	@ModelAttribute("page")
	public String module() {
		return "altres";
	}
	
	@RequestMapping("/altres")
	public String listPrecintes(Model model) {
//		EntitatDto entitat=new EntitatDto();	
//		model.addAttribute("entitats", precService.findAllEntitats());
		return "altres";
	}

}
