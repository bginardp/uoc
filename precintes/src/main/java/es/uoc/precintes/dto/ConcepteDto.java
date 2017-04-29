package es.uoc.precintes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.model.Concepte;

public class ConcepteDto {
	@NotNull
	@Size(min = 4, max = 10)
	private String entitatId;
	@NotNull
	@Size(min = 4, max = 10)
	private String id;
	@NotNull
	@Size(min = 4, max = 40)
	private String descripcio;

	public ConcepteDto() {

	}

	public ConcepteDto(String entitatId) {
		this.entitatId = entitatId;
	}

	public ConcepteDto(Concepte concepte) {
		this.entitatId = concepte.getId().getEntitatId();
		this.id = concepte.getId().getId();
		this.descripcio = concepte.getDescripcio();
	}

	public String getEntitatId() {
		return entitatId;
	}

	public void setEntitatId(String entitatId) {
		this.entitatId = entitatId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

}
