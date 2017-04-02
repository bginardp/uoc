package es.uoc.precintes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.dto.MotiuDto;

@Entity
@Table(name = "motius")
public class Motiu {
	@Id
	@NotNull
	@Size(min = 4, max = 10)
	private String id;
	@NotNull
	@Size(min = 4, max = 40)
	private String descripcio;

	public Motiu() {
	}
	
	public Motiu (String id, String descripcio) {
		this.id=id;
		this.descripcio=descripcio;
	}
	public Motiu(MotiuDto motiuDto) {
		this.id = motiuDto.getId();
		this.descripcio = motiuDto.getDescripcio();
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
