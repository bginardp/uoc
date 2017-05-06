package es.uoc.precintes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.dto.ConcepteDto;

@Entity
@Table(name = "conceptes")
public class Concepte {
	@EmbeddedId
	private ConcepteId id;
	@NotNull
	@Size(min = 4, max = 40)
	private String descripcio;
	@ManyToOne
	@JoinColumn(name = "entitatId", insertable = false, updatable = false)
	private Entitat entitat;

	public Concepte() {
	}

	public Concepte(ConcepteDto concepteDto) {
		this.id = new ConcepteId(concepteDto.getEntitatId().toUpperCase(), concepteDto.getId().toUpperCase());
		if (concepteDto.getDescripcio() != null) {
			this.descripcio = concepteDto.getDescripcio().toUpperCase();
		}
	}

	public Concepte(String entitat, String concepte, String descripcio) {
		this.id = new ConcepteId(entitat, concepte);
		this.descripcio = descripcio;
	}

	public ConcepteId getId() {
		return id;
	}

	public void setId(ConcepteId id) {
		this.id = id;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Entitat getEntitat() {
		return entitat;
	}

	public void setEntitat(Entitat entitat) {
		this.entitat = entitat;
	}

}
