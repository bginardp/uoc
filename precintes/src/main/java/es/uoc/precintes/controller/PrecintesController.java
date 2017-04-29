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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import es.uoc.precintes.dto.ConcepteDto;
import es.uoc.precintes.dto.EntitatDto;
import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.dto.UsuariDto;
import es.uoc.precintes.dto.VehicleDto;
import es.uoc.precintes.service.AdminService;
import es.uoc.precintes.service.PrecintesService;
import es.uoc.precintes.service.VehiclesService;
import es.uoc.precintes.utils.ModelUtils;

@Controller
public class PrecintesController extends WebMvcConfigurerAdapter {
	@Autowired
	PrecintesService precService;
	@Autowired
	VehiclesService vehService;
	@Autowired
	AdminService adminService;

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

	@RequestMapping(value ={"/precinte/{id}","/precinte/{vehicleId}/new"}, method=RequestMethod.GET)
	public String getPrecinte(Model model, Principal principal,
			@PathVariable(value="id",required=false) Long precinteId,
			@PathVariable(value="vehicleId",required=false) Long vehicleId,
			@ModelAttribute PrecinteDto precinte, BindingResult result
			) {
		
		if (precinteId!=null) {
			precinte=precService.getPrecinte(precinteId);
		} else	{
			precinte=new PrecinteDto();
			precinte.setVehicle(vehService.getVehicle(vehicleId));
			precinte.setEntitat(adminService.getEntitat(ModelUtils.DEFAULTENTITAT));
		}
		return gotoEdit(model,precinte);
	}
	
	private String gotoEdit(Model model, PrecinteDto precinte) {
		VehicleDto vehicle=precinte.getVehicle();
		List<EntitatDto> entitats=adminService.findAllEntitats();
		model.addAttribute("entitats", entitats);
		List<ConcepteDto> conceptes=null;
		if (precinte.getEntitat()!=null){
			conceptes=adminService.findConceptesByEntitat(precinte.getEntitat().getId());
		}else{
		    conceptes=new ArrayList<ConcepteDto>();
	    }
		model.addAttribute("conceptes", conceptes);
		model.addAttribute("vehicle",vehicle);
		model.addAttribute("precinte", precinte);
		return "precintes/editPrecinte";
	}
	

	@RequestMapping(value="/refreshConceptes", method=RequestMethod.GET) 
	public String refreshConceptes(@RequestParam("idEntitat") String entitatId, Model model) {
		model.addAttribute("concepte",new ConcepteDto());
		model.addAttribute("conceptes",adminService.findConceptesByEntitat(entitatId));
		return "/precintes/editPrecinte :: #selconcepte";
	}
	
	
	@RequestMapping("/precinte/view/{id}")
	public String showPrecinte(Model model, Principal principal,
			@PathVariable(value="id",required=false) Long precinteId) {
		PrecinteDto precinte=precService.getPrecinte(precinteId);
		VehicleDto vehicle=precinte.getVehicle();
		List<EntitatDto> entitats=adminService.findAllEntitats();
		List<ConcepteDto> conceptes=null;
		if (precinte.getEntitat()!=null){
			conceptes=adminService.findConceptesByEntitat(precinte.getEntitat().getId());
		}
		model.addAttribute("precinte", precinte);
		model.addAttribute("entitats", entitats);
		model.addAttribute("conceptes", conceptes);
		model.addAttribute("vehicle",vehicle);
		model.addAttribute("motius", adminService.findAllMotius());
		return "precintes/viewPrecinte";
	}
	
	@PostMapping(value="/precinte/save")
	public String registerPrecinte(Model model, Principal principal, 
			@Valid @ModelAttribute("precinte") PrecinteDto precinte,
			BindingResult results) {
		UsuariDto usuari=new UsuariDto();
		usuari.setId(principal.getName());
		precinte.setUsuari(usuari);
		Long vehicleId=precinte.getVehicle().getId();
		precinte.setVehicle(vehService.getVehicle(vehicleId));
		if (results.hasErrors()) {
			return gotoEdit(model, precinte);
		} else {
			String entitatId=precinte.getEntitat().getId();
			if (precinte.getConcepte()!=null) {
				ConcepteDto concepte=precinte.getConcepte();
				concepte.setEntitatId(entitatId);
				precinte.setConcepte(concepte);
			}
			Long precId=null;
			if (precinte.getId()!=null) {
				precId=precinte.getId();
				precService.editPrecinte(precinte);
			} else {
				precId=precService.registerPrecinte(precinte);	
			}
			
			return "redirect:/precinte/"+precId+"?msg=ok";
		}
	}
	
	@RequestMapping(value ={"/desprecinte/{id}"}, method=RequestMethod.GET)
	public String getDesPrecinte(Model model, Principal principal,
			@PathVariable(value="id",required=true) Long precinteId) {
		PrecinteDto desprecinte=precService.getPrecinte(precinteId);
		UsuariDto usuari=new UsuariDto();
		usuari.setId(principal.getName());
		desprecinte.setUsuari(usuari);
		return gotoEditDesprecinte(model,desprecinte);
	}
	
	private String gotoEditDesprecinte(Model model, PrecinteDto desprecinte) {
		VehicleDto vehicle=desprecinte.getVehicle();
		List<EntitatDto> entitats=adminService.findAllEntitats();
		model.addAttribute("entitats", entitats);
		List<ConcepteDto> conceptes=adminService.findConceptesByEntitat(desprecinte.getEntitat().getId());
		model.addAttribute("conceptes",conceptes);
		model.addAttribute("vehicle",vehicle);
		model.addAttribute("precinte", desprecinte);
		model.addAttribute("motius", adminService.findAllMotius());
		return "precintes/editDesPrecinte";
	}

	@PostMapping(value="/desprecinte/save")
	public String registerDesPrecinte(Model model, Principal principal, 
			@Valid @ModelAttribute("precinte") PrecinteDto desprecinte,
			BindingResult results) {
		Long vehicleId=desprecinte.getVehicle().getId();
		desprecinte.setVehicle(vehService.getVehicle(vehicleId));
		if (results.hasErrors()) {
			return gotoEditDesprecinte(model, desprecinte);
		} else {
			desprecinte=precService.registerDesprecinte(desprecinte);
			if (desprecinte.hasErrores()) {
				return gotoEditDesprecinte(model, desprecinte);
			} else {
			return "redirect:/desprecinte/"+desprecinte.getId()+"?msg=ok";}
		}
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
