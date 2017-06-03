package es.uoc.precintes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.uoc.precintes.dto.ConcepteDto;
import es.uoc.precintes.dto.EntitatDto;
import es.uoc.precintes.dto.MotiuDto;
import es.uoc.precintes.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@ModelAttribute("page")
	public String module() {
		return "admin";
	}

	
	@RequestMapping(value = "/entitats", method = RequestMethod.GET)
	public String findAllEntitats(Model model) {
		List<EntitatDto> entitats= adminService.findAllEntitats();
		model.addAttribute("entitats", entitats);
		return "admin/entitats/list";
	}

	@RequestMapping(value = {"/entitat/{id}", "/entitat/new"}, method = RequestMethod.GET)
	public String editEntitat(Model model, @PathVariable(value = "id", required = false) String entitatId) {
		EntitatDto entitat = null;
		if (entitatId != null) {
			entitat = adminService.getEntitat(entitatId);
		} else {
			entitat = new EntitatDto();
		}

		return gotoEditEntitat(model, entitat);
	}

	private String gotoEditEntitat(Model model, EntitatDto entitat) {
		model.addAttribute("entitat", entitat);
		return "admin/entitats/edit";
	}

	@RequestMapping(value = "/entitat/save", method = RequestMethod.POST)
	public String saveEntitat(Model model, @Valid @ModelAttribute("entitat") EntitatDto entitat,
			BindingResult results) {
		if (results.hasErrors()) {
			return gotoEditEntitat(model, entitat);
		} else {
			adminService.saveEntitat(entitat);
			return "redirect:/admin/entitat/"+entitat.getId().toUpperCase() + "?msg=ok";
		}
	}

	@RequestMapping(value="/entitat/remove",method=RequestMethod.POST)
	public String removeEntitat(@RequestParam("id") String id){
		adminService.removeEntitat(id);
		return "redirect:/admin/entitats/";
	}
	
	
	@RequestMapping(value = "/motius", method = RequestMethod.GET)
	public String findAllMotius(Model model) {
		List<MotiuDto> motius= adminService.findAllMotius();
		model.addAttribute("motius", motius);
		return "admin/motius/list";
	}
	
	
	@RequestMapping(value = {"/motiu/{id}", "/motiu/new"}, method = RequestMethod.GET)
	public String editMotiu(Model model, @PathVariable(value = "id", required = false) String motiuId) {
		MotiuDto motiu = null;
		if (motiuId != null) {
			motiu = adminService.getMotiu(motiuId);
		} else {
			motiu = new MotiuDto();
		}

		return gotoEditMotiu(model, motiu);
	}

	private String gotoEditMotiu(Model model, MotiuDto motiu) {
		model.addAttribute("motiu", motiu);
		return "admin/motius/edit";
	}

	@RequestMapping(value = "/motiu/save", method = RequestMethod.POST)
	public String saveMotiu(Model model, @Valid @ModelAttribute("motiu") MotiuDto motiu,
			BindingResult results) {
		if (results.hasErrors()) {
			return gotoEditMotiu(model, motiu);
		} else {
			adminService.saveMotiu(motiu);
			return "redirect:/admin/motiu/"+motiu.getId().toUpperCase() + "?msg=ok";
		}
	}

	@RequestMapping(value="/motiu/remove",method=RequestMethod.POST)
	public String removeMotiu(@RequestParam("id") String id){
		adminService.removeMotiu(id);
		return "redirect:/admin/motius/";
	}
	
	
	@RequestMapping(value = "/conceptes/{entitatId}", method = RequestMethod.GET)
	public String findConceptesByEntitat(Model model, @PathVariable(value = "entitatId", required = true) String entitatId){
		
		model.addAttribute("entitat", entitatId);
		model.addAttribute("conceptes", adminService.findConceptesByEntitat(entitatId));

		return "admin/conceptes/list";
	}

	@RequestMapping(value = {"/concepte/{entitatId}/{id}", "/concepte/{entitatId}/new"}, method = RequestMethod.GET)
	public String editConcepte(Model model, 
			@PathVariable(value = "entitatId", required = true) String entitatId,
			@PathVariable(value = "id", required = false) String concepteId) {
		ConcepteDto concepte = null;
		if (concepteId != null) {
			concepte = adminService.getConcepte(entitatId,concepteId);
		} else {
			concepte = new ConcepteDto(entitatId);
		}

		return gotoEditConcepte(model, concepte);
	}

	private String gotoEditConcepte(Model model, ConcepteDto concepte) {
		model.addAttribute("concepte", concepte);
		return "admin/conceptes/edit";
	}

	@RequestMapping(value = "/concepte/save", method = RequestMethod.POST)
	public String saveConcepte(Model model, @Valid @ModelAttribute("concepte") ConcepteDto concepte,
			BindingResult results) {
		if (results.hasErrors()) {
			return gotoEditConcepte(model, concepte);
		} else {
			adminService.saveConcepte(concepte);
			return "redirect:/admin/concepte/"+concepte.getEntitatId()+"/"+concepte.getId().toUpperCase() + "?msg=ok";
		}
	}

	@RequestMapping(value="/concepte/remove",method=RequestMethod.POST)
	public String removeConcepte(@RequestParam("entitatId") String entitatId,@RequestParam("id") String id){
		adminService.removeConcepte(entitatId,id);
		return "redirect:/admin/conceptes/"+entitatId;
	}
	
	
}
