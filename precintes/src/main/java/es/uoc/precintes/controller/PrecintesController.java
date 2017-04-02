package es.uoc.precintes.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.service.PrecintesService;

@Controller
public class PrecintesController extends WebMvcConfigurerAdapter {
	@Autowired
	PrecintesService precService;

	@ModelAttribute("page")
	public String module() {
		return "home";
	}

	@GetMapping(value = "")
	public String welcome(Model model, Principal principal) {
		String matric = null;
		List<ErrorDto> errors = new ArrayList<ErrorDto>();
		return gotoHome(model, principal, matric, errors);
	}

	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@RequestMapping("/precinte/add")
	public String registerPrecinte(Model model, Principal principal) {
		
		return null;
	}
	
	@RequestMapping("/precinte/view")
	public String getPrecinte(Model model, Principal principal) {
		
		return null;
	}
	@RequestMapping("/desprecinte/add")
	public String registerDesPrecinte(Model model, Principal principal, 
			@Valid @ModelAttribute("precinte") PrecinteDto precinte,
			BindingResult results) {
		
		return null;
	}
	
	@RequestMapping("/desprecinte/cancel")
	public String cancelDesPrecinte(Model model, Principal principal, 
				@Valid @ModelAttribute("precinte") PrecinteDto precinte,
				BindingResult results) {
			
			return null;
		}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	
	private String gotoHome(Model model, Principal principal, String matric, List<ErrorDto> errors) {
		if (principal != null) {
			model.addAttribute("usuari", principal.getName());
		}
		if (matric != null) {
			model.addAttribute("matric", matric);
		}
		if (errors != null) {
			model.addAttribute("errors", errors);
		}
		return "home";
	}

}
