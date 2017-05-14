package es.uoc.precintes.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import es.uoc.precintes.model.Vehicle;
import es.uoc.precintes.utils.Convert;

public class VehicleDto extends BaseDto{
	
  private Long id;
  @NotNull
  @Size(min=7,max=10)
  private String matricula;
  @NotNull
  @Size(min=1,max=17)
  private String bastidor;
  @NotNull
  @Size(min=2,max=40)
  private String marca;
  @NotNull
  @Size(min=2,max=40)
  private String model;
  @NotNull
  @DateTimeFormat(pattern="dd/MM/yyyy")
  private Date datmat;
  @Valid
  private PersonaDto persona;
  private long numpre;
 
public VehicleDto() {
  super();
}
	  
public VehicleDto(List<ErrorDto> errors) {
	super(errors);
}

public VehicleDto(Vehicle vehicle) {
	this.id = vehicle.getId();
	this.matricula = vehicle.getMatricula();
	this.bastidor = vehicle.getBastidor();
	this.marca = vehicle.getMarca();
	this.model = vehicle.getModel();
	this.datmat=vehicle.getDatmat();
	this.persona=Convert.toDto(vehicle.getPersona());
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

public Date getDatmat() {
	return datmat;
}

public void setDatmat(Date datmat) {
	this.datmat = datmat;
}

public PersonaDto getPersona() {
	return persona;
}

public void setPersona(PersonaDto persona) {
	this.persona = persona;
}

public String getNomComplet() {
	String ret="";
	if (this.persona!=null) {
	  ret=this.persona.getLl1per()+" "+ this.persona.getLl2per()+", "+this.persona.getNom();
	}
	return ret;
}

public String getMarcaModel() {
	String ret=this.marca+" "+this.model;
	return ret;
}



public long getNumpre() {
	return numpre;
}

public void setNumpre(long numpre) {
	this.numpre = numpre;
}

@Override
public String toString() {
	return "VehicleDto [id=" + id + ", matricula=" + matricula + ", bastidor=" + bastidor + ", marca=" + marca
			+ ", model=" + model + ", datmat=" + datmat + ", persona=" + persona + "]";
}


}
