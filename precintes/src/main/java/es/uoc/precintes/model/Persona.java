package es.uoc.precintes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.dto.PersonaDto;

@Entity
@Table(name = "persones")
public class Persona {

	@Id
	@GeneratedValue(generator = "PerSeq")
	@SequenceGenerator(name = "PerSeq", sequenceName = "tfg.persones_seq", allocationSize = 1)
	private Long id;
	@NotNull
	@Size(max = 9)
	private String nif;
	@NotNull
	@Size(max = 30)
	private String nom;
	@NotNull
	@Size(max = 30)
	private String ll1per;
	@Size(max = 30)
	private String ll2per;
	@Size(max = 40)
	private String domicili;
	@Size(max = 40)
	private String municipi;
	@Size(max = 5)
	private String codpos;
	@Size(max = 40)
	private String provincia;
	@Size(max = 9)
	private String telefono;
	@Size(max = 40)
	private String email;

	/**
	 * Class constructor methods
	 */
	public Persona() {
		super();
	}
	
	public Persona(PersonaDto persona) {
	this.id=persona.getId();
	this.nif=persona.getNif().toUpperCase();
	this.nom=persona.getNom().toUpperCase();
	this.ll1per=persona.getLl1per().toUpperCase();
	this.ll2per=persona.getLl2per().toUpperCase();
	this.domicili=persona.getDomicili();
	this.municipi=persona.getMunicipi().toUpperCase();
	this.provincia=persona.getProvincia().toUpperCase();
	this.codpos=persona.getCodpos();
	this.telefono=persona.getTelefono();
	this.email=persona.getEmail();
	
}


	public Persona(String nif, String nom, String ll1per, String ll2per, String domicili, String municipi,
			String codpos, String provincia,  String telefono, String email) {
		super();
		this.nif = nif;
		this.nom = nom;
		this.ll1per = ll1per;
		this.ll2per = ll2per;
		this.domicili = domicili;
		this.municipi = municipi;
		this.codpos = codpos;
		this.provincia = provincia;
		this.telefono = telefono;
		this.email = email;
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

	public void setNif(String cif) {
		this.nif = cif;
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

}
