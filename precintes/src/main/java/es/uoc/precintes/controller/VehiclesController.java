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

import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.dto.VehicleDto;
import es.uoc.precintes.service.PrecintesService;
import es.uoc.precintes.service.VehiclesService;

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

	@GetMapping(value = "")
	public String welcome(Model model, Principal principal) {
		String matric = null;
		List<ErrorDto> errors = new ArrayList<ErrorDto>();
		return gotoHome(model, principal, matric, errors);
	}

	@RequestMapping(value = { "/vehicle/{id}", "/vehicle/new" }, method = RequestMethod.GET)
	public String editVehicle(Model model, @PathVariable(value = "id", required = false) Long vehicleId,
			@RequestParam(value = "page", required = false) String page) {
		VehicleDto vehicle = null;
		if (vehicleId != null) {
			vehicle = vehService.getVehicle(vehicleId);
		} else {
			vehicle = new VehicleDto();
		}

		//return gotoEdit(model, vehicle, page);
		return gotoEdit(model, vehicle);
	}

	@PostMapping(value = "/vehicle/save")
	public String saveVehicle(Model model, @Valid @ModelAttribute("vehicle") VehicleDto vehicle,
			BindingResult results) {
		if (results.hasErrors()) {
			return gotoEdit(model, vehicle);
		} else {
			vehicle = vehService.saveVehicle(vehicle);
			if (vehicle.hasErrores()) {
				model.addAttribute("errors", vehicle.getErrores());
				return gotoEdit(model, vehicle);
			}
			return "redirect:/vehicle/" + vehicle.getId() + "?msg=ok";
		}
	}

	private String gotoEdit(Model model, VehicleDto vehicle) {
		model.addAttribute("vehicle", vehicle);
		// model.addAttribute("page", page);
		return "vehicles/edit";
	}

	/**
	 * captura les peticions /view/ , /view/?matric=xxxxxxx
	 * 
	 * a la vista home.html hi ha un tag input amb un name="matric" i quan es
	 * far summmit s'afegeix el parametre a la url.
	 * 
	 * @param model
	 * @param matric
	 * @return
	 */
	@RequestMapping(value = ("/vehicle/view"))
	public String findVehicleByMatricula(Principal principal, Model model,
			@RequestParam(value = "matric", required = false) String matric) {
		if (matric != null) {
			VehicleDto vehicle = vehService.findVehicleByMatricula(matric);
			if (vehicle.hasErrores()) {
				return gotoHome(model, principal, matric, vehicle.getErrores());
			} else {
				List<PrecinteDto> precintes = precService.findPrecintesByVehicleId(vehicle.getId());
				model.addAttribute("vehicle", vehicle);
				model.addAttribute("precintes", precintes);
				return "/vehicles/view";
			}
		} else {
			ErrorDto e = new ErrorDto("error.nomatric");
			List<ErrorDto> errors = new ArrayList<ErrorDto>();
			errors.add(e);
			return gotoHome(model, principal, matric, errors);

		}
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
