package es.uoc.precintes.dto;

import es.uoc.precintes.model.Usuari;

public class UsuariDto {
	private String id;
	private String password;
	private String role;

	public UsuariDto() {
		
	}
	
	public UsuariDto(Usuari usuari) {
		this.id=usuari.getId();
		this.password=usuari.getPassword();
		this.role=usuari.getRole();
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

	public boolean isAdmin() {
		return ("ADMIN".equals(this.role));
	}

}
