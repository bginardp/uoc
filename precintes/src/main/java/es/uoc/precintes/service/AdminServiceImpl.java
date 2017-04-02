package es.uoc.precintes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uoc.precintes.dao.AdminDao;
import es.uoc.precintes.dto.ConcepteDto;
import es.uoc.precintes.dto.EntitatDto;
import es.uoc.precintes.dto.MotiuDto;
import es.uoc.precintes.model.Concepte;
import es.uoc.precintes.model.Entitat;
import es.uoc.precintes.model.Motiu;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<EntitatDto> findAllEntitats() {
		List<Entitat> entitats = adminDao.findAllEntitats();
		List<EntitatDto> content = new ArrayList<EntitatDto>();
		for (Entitat entitat : entitats) {
			content.add(new EntitatDto(entitat));
		}
		return content;
	}

	@Override
	public List<ConcepteDto> findConceptesByEntitat(String entitatId) {
		List<Concepte> conceptes = adminDao.findAllConceptesByEntitat(entitatId);
		List<ConcepteDto> content = new ArrayList<ConcepteDto>();
		for (Concepte concepte : conceptes) {
			content.add(new ConcepteDto(concepte));
		}
		return content;
	}

	@Override
	public List<MotiuDto> findAllMotius() {
		List<Motiu> motius = adminDao.findAllMotius();
		List<MotiuDto> content = new ArrayList<MotiuDto>();
		for (Motiu motiu : motius) {
			content.add(new MotiuDto(motiu));
		}
		return content;
	}

	@Override
	public EntitatDto getEntitat(String entitatId) {
		if (entitatId != null) {
			Entitat entitat = adminDao.getEntitat(entitatId);
			EntitatDto entitatDto = new EntitatDto(entitat);
			return entitatDto;
		}
		return null;
	}

	@Override
	public ConcepteDto getConcepte(String entitatId, String concepteId) {
		Concepte concepte = adminDao.getConcepte(entitatId, concepteId);
		ConcepteDto dto = new ConcepteDto(concepte);
		return dto;
	}

	@Override
	public MotiuDto getMotiu(String motiuId) {
		Motiu motiu = adminDao.getMotiu(motiuId);
		MotiuDto dto = new MotiuDto(motiu);
		return dto;
	}

	@Override
	public void removeEntitat(String entitatId) {
		adminDao.removeEntitat(entitatId);

	}

	@Override
	public void removeConcepte(String entitatId, String concepteId) {
		adminDao.removeConcepte(entitatId, concepteId);

	}

	@Override
	public void removeMotiu(String motiuId) {
		adminDao.removeMotiu(motiuId);

	}

	@Override
	public void saveEntitat(EntitatDto entitatDto) {
		Entitat entitat = new Entitat(entitatDto);
		adminDao.saveEntitat(entitat);

	}

	@Override
	public void saveConcepte(ConcepteDto concepteDto) {
		if (concepteDto != null) {
			Concepte concepte = new Concepte(concepteDto);
			adminDao.saveConcepte(concepte);
		}

	}

	@Override
	public void saveMotiu(MotiuDto motiuDto) {
		if (motiuDto != null) {
			Motiu motiu = new Motiu(motiuDto);
			adminDao.saveMotiu(motiu);
		}

	}

}
