package es.uoc.precintes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.model.Persona;

public class PersonaDto extends BaseDto {
	private Long id;
	@NotNull
	@Size(min = 8, max = 9)
	private String nif;
	@NotNull
	@Size(min = 3, max = 30)
	private String nom;
	@NotNull
	@Size(min = 3, max = 40)
	private String ll1per;
	private String ll2per;
	@NotNull
	@Size(min = 3, max = 40)
	private String domicili;
	@NotNull
	@Size(min = 2, max = 40)
	private String municipi;
	@NotNull
	@Size(max = 5)
	private String codpos;
	@NotNull
	@Size(min = 3, max = 40)
	private String provincia;
	private String telefono;
	private String email;

	public PersonaDto() {
		super();
	}

	public PersonaDto(Persona persona) {
		this.id = persona.getId();
		this.nif = persona.getNif();
		this.nom = persona.getNom();
		this.ll1per = persona.getLl1per();
		this.ll2per = persona.getLl2per();
		this.domicili = persona.getDomicili();
		this.municipi = persona.getMunicipi();
		this.codpos = persona.getCodpos();
		this.provincia = persona.getProvincia();
		this.telefono = persona.getTelefono();
		this.email = persona.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLl1per() {
		return ll1per;
	}

	public void setLl1per(String ll1per) {
		this.ll1per = ll1per;
	}

	public String getLl2per() {
		return ll2per;
	}

	public void setLl2per(String ll2per) {
		this.ll2per = ll2per;
	}

	public String getDomicili() {
		return domicili;
	}

	public void setDomicili(String domicili) {
		this.domicili = domicili;
	}

	public String getMunicipi() {
		return municipi;
	}

	public void setMunicipi(String municipi) {
		this.municipi = municipi;
	}

	public String getCodpos() {
		return codpos;
	}

	public void setCodpos(String codpos) {
		this.codpos = codpos;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonaDto [id=" + id + ", nif=" + nif + ", nom=" + nom + ", ll1per=" + ll1per + ", ll2per=" + ll2per
				+ ", domicili=" + domicili + ", municipi=" + municipi + ", codpos=" + codpos + ", provincia="
				+ provincia + ", telefono=" + telefono + ", email=" + email + "]";
	}

	
}
