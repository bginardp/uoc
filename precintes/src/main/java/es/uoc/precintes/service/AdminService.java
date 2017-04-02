package es.uoc.precintes.service;

import java.util.List;

import es.uoc.precintes.dto.ConcepteDto;
import es.uoc.precintes.dto.EntitatDto;
import es.uoc.precintes.dto.MotiuDto;

public interface AdminService {
	
	public List<EntitatDto> findAllEntitats();
	public List<ConcepteDto> findConceptesByEntitat(String entitatId);
	public List<MotiuDto> findAllMotius();

	EntitatDto getEntitat(String entitatId);
	ConcepteDto getConcepte (String entitatId, String concepteId);
	MotiuDto getMotiu (String motiuId);
		
	void removeEntitat(String entitatId);
	void removeConcepte(String entitatId, String concepteId);
	void removeMotiu(String motiuId);
	
	void saveEntitat(EntitatDto entitatDto);
	void saveConcepte(ConcepteDto concepteDto);
	void saveMotiu(MotiuDto motiuDto);
		
}
