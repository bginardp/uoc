package es.uoc.precintes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.dto.EntitatDto;



@Entity
@Table(name = "entitats")

public class Entitat {
	@Id
	@NotNull
	@Size(min=4,max=10)
	private String id;
	@NotNull
	@Size(min=4,max=40)
	private String descripcio;

	public Entitat() {
	}

	public Entitat(EntitatDto entitatDto) {
		this.id = entitatDto.getId();
		this.descripcio = entitatDto.getDescripcio();
	}

	public Entitat(String id, String dem) {
		this.id = id;
		this.descripcio = dem;
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