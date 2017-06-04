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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uoc.precintes.dto.AltresForm;
import es.uoc.precintes.dto.ConcepteDto;
import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.service.AdminService;
import es.uoc.precintes.service.PrecintesService;
import es.uoc.precintes.utils.ModelUtils;
/**
 * Classe que gestiona les peticion de les consultes Altres
 * @author BERNAT1
 *
 */
@Controller
public class AltresController {
	@Autowired
	AdminService adminService;
	@Autowired
	PrecintesService precService;
	
	@ModelAttribute("page")
	public String module() {
		return "altres";
	}
	
	@RequestMapping("/altres")
	public String listPrecintes(Model model,Principal principal,
			@Valid @ModelAttribute("criteris") AltresForm criteris) {
		List<PrecinteDto> precintes=new ArrayList<PrecinteDto>();
		model.addAttribute("usuari", principal.getName());
		model.addAttribute("precintes",precintes);
		return gotoAltres(model,criteris);
	}
	
	private String gotoAltres(Model model, AltresForm criteris) {
		List<ConcepteDto> conceptes=new ArrayList<ConcepteDto>();
		model.addAttribute("entitats", adminService.findAllEntitats());
		model.addAttribute("criteris",criteris);
		if (criteris.getEntitatId()!=null) {
			String entitatId=criteris.getEntitatId();
			conceptes.add(new ConcepteDto(entitatId,"","Selecciona un concepte ...."));
			conceptes.addAll(adminService.findConceptesByEntitat(entitatId));
		}
		model.addAttribute("conceptes", conceptes);
		model.addAttribute("motius", adminService.findAllMotius());
		return "altres";
	}
	
	@PostMapping(value="/altres/search")
	public String findPrecintesByCriteris (Model model, Principal principal,
			@Valid @ModelAttribute("criteris") AltresForm criteris,	BindingResult results) {
		List<PrecinteDto> precintes=null;
		if (!results.hasErrors()) {
			criteris=validaFormulariAltres(criteris);
			if (!criteris.hasErrores()) {
			   precintes=precService.findPrecintesByCriteris(criteris.getDatdespre(), criteris.getDatfinpre(), criteris.getDatdesdespre(), 
			   criteris.getDatfindespre(), criteris.getEntitatId(), criteris.getConcepteId(), criteris.getMotiuId());
			} 
		}
		model.addAttribute("precintes", precintes);
		model.addAttribute("usuari", principal.getName());
		return gotoAltres(model, criteris);
	}

	private AltresForm validaFormulariAltres(AltresForm criteris) {
		List<ErrorDto> errors = new ArrayList<ErrorDto>();
		ErrorDto error=null;
		if (ModelUtils.afterThat(criteris.getDatdespre(), criteris.getDatfinpre())) {
			error = new ErrorDto(ModelUtils.ERROR_RANG_DATES_KEY);
			errors.add(error);
		}
		if (ModelUtils.afterThat(criteris.getDatdesdespre(), criteris.getDatfindespre())) {
			error = new ErrorDto(ModelUtils.ERROR_RANG_DATES_KEY);
			errors.add(error);
		}
		criteris.setErrores(errors);
		return criteris;
	}

}
