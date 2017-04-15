package es.uoc.precintes.dto;

import es.uoc.precintes.model.Usuari;

public class UsuariDto {
	private String id;
	private String password;
	
	public UsuariDto() {
		
	}
	
	public UsuariDto(Usuari usuari) {
		this.id=usuari.getId();
		this.password=usuari.getPassword();
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
