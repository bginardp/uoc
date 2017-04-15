package es.uoc.precintes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.dto.UsuariDto;

@Entity
@Table(name = "usuaris")
public class Usuari {
	@Id
	@NotNull
	@Size(min = 4, max = 10)
	private String id;
	@NotNull
	@Size(min = 4, max = 30)
	private String password;

	public Usuari() {
	}
	
	public Usuari(UsuariDto usuari) {
		this.id=usuari.getId();
		this.password=usuari.getPassword();
	}
	
	public Usuari(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
