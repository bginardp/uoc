package es.uoc.precintes.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PersonaDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.dto.VehicleDto;
import es.uoc.precintes.service.PrecintesService;
import es.uoc.precintes.service.VehiclesService;
@RequestMapping(value="/vehicle")
@Controller
public class VehiclesController {
	@Autowired
	VehiclesService vehService;
	@Autowired
	PrecintesService precService;
	@ModelAttribute("page")
	public String module() {
		return "home";
	}
	
	private String gotoEdit(Model model, VehicleDto vehicle) {
		model.addAttribute("vehicle", vehicle);
//		model.addAttribute("formasPago",factuService.findAllFormaspago());
		return "vehicles/edit";
	}
	
	@RequestMapping(value ={"/{id}","/new"}, method=RequestMethod.GET)
	public String editVehicle(
			Model model,
			@PathVariable(value="id",required=false) Long vehicleId){
		VehicleDto vehicle=null;
		if (vehicleId!=null) {
		  vehicle = vehService.getVehicle(vehicleId);
		} else {
		  vehicle= new VehicleDto();	
		}
			
		return gotoEdit(model,vehicle);
	}

	@PostMapping(value="/save")
	public String saveVehicle(
			Model model,
			@Valid @ModelAttribute("vehicle") VehicleDto vehicle, 
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, vehicle);
		} else {
			Long vehId=vehService.saveVehicle(vehicle);
			return "redirect:/vehicle/"+vehId+"?msg=ok";
		}
	}
	
	@RequestMapping(value="/titular/save", method=RequestMethod.POST)
	public String saveTitular(
			Model model,
			@Valid @ModelAttribute("titular") PersonaDto persona,
			BindingResult results){
		// TODO
		return null;
		
	}
	
	
	@RequestMapping(value ={"titular/{id}"}, method=RequestMethod.GET)
	public String editTitular(
			Model model,
			@PathVariable(value="id",required=false) Long titularId){
		// todo 
		return null;
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
	
	/**
	 * catura les peticions /view/ , /view/?matric=xxxxxxx
	 * 
	 * a la vista home.html hi ha un tag input amb un name="matric" i quan es far summmit s'afegeix el parametre a la url.
	 * 
	 * @param model
	 * @param matric
	 * @return
	 */
		@RequestMapping(value = ("/view"))
		public String findVehicleByMatricula(Principal principal, Model model,@RequestParam(value="matric",required=false) String matric ) {
			if (matric!=null) {
				VehicleDto vehicle= vehService.findVehicleByMatricula(matric);
				
				if (vehicle.hasErrores()) {
				    return gotoHome(model, principal, matric,vehicle.getErrores());
				} else {
					List<PrecinteDto> precintes = precService.findPrecintesByVehicleId(vehicle.getId());
					model.addAttribute("vehicle", vehicle);
					model.addAttribute("precintes", precintes);
					return "/vehicles/view";} 
			} else {
				ErrorDto e = new ErrorDto("error.nomatric");
				List<ErrorDto> errors=new ArrayList<ErrorDto>();
				errors.add(e);
				return gotoHome(model, principal, matric,errors);
			
			// return "redirect:/admin/entitat/"+entitat.getId() + "?msg=ok";
			
			}
		}
				
			
}
