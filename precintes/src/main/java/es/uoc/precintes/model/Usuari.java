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
	private String role;
	
	public Usuari() {
	}
	
	public Usuari(UsuariDto usuari) {
		this.id=usuari.getId();
		this.password=usuari.getPassword();
		this.role=usuari.getRole();
	}
	
	public Usuari(String id, String password, String role) {
		this.id = id;
		this.password = password;
		this.role=role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
