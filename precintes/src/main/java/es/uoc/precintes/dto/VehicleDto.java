package es.uoc.precintes.dto;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.model.Vehicle;

public class VehicleDto extends BaseDto{
	
  private Long id;
  @NotNull
  @Size(min=8,max=8)
  private String matricula;
  @NotNull
  @Size(min=4,max=30)
  private String bastidor;
  @NotNull
  @Size(min=2,max=40)
  private String marca;
  @NotNull
  @Size(min=2,max=40)
  private String model;
  @NotNull
  @Size(min=8)
  private String datmat;
  private Long personaId;
  @NotNull
  @Size(min=8,max=9)
  private String nif;
  @NotNull
  @Size(min=3,max=30)
  private String nom;
  @NotNull
  @Size(min=3,max=40)
  private String ll1per;
  private String ll2per;
  @NotNull
  @Size(min=3,max=40)
  private String domicili;
  @NotNull
  @Size(min=2,max=40)
  private String municipi;
  @NotNull
  @Size(min=3,max=40)
  private String provincia;
  private String telefono;
  private String email;

public VehicleDto() {
  super();
}
	  
public VehicleDto(List<ErrorDto> errors) {
	super(errors);
}
//TODO: Falta afegir les validacions

public VehicleDto(Vehicle vehicle) {
	this.id = vehicle.getId();
	this.matricula = vehicle.getMatricula();
	this.bastidor = vehicle.getBastidor();
	this.marca = vehicle.getMarca();
	this.model = vehicle.getModel();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	this.datmat = sdf.format( vehicle.getDatmat());
	this.personaId=vehicle.getPersonaId();
	this.nif=vehicle.getPersona().getNif();
	this.nom=vehicle.getPersona().getNom();
	this.ll1per=vehicle.getPersona().getLl1per();
	this.ll2per=vehicle.getPersona().getLl2per();
	this.domicili=vehicle.getPersona().getDomicili();
	this.municipi=vehicle.getPersona().getMunicipi();
	this.provincia=vehicle.getPersona().getProvincia();
	this.telefono=vehicle.getPersona().getTelefono();
	this.email=vehicle.getPersona().getEmail();
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public String getBastidor() {
	return bastidor;
}
public void setBastidor(String bastidor) {
	this.bastidor = bastidor;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}

public String getDatmat() {
	return datmat;
}

public void setDatmat(String datmat) {
	this.datmat = datmat;
}

public Long getPersonaId() {
	return personaId;
}

public void setPersonaId(Long personaId) {
	this.personaId = personaId;
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
