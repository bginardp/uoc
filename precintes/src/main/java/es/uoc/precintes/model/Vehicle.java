package es.uoc.precintes.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import es.uoc.precintes.dto.VehicleDto;
//TODO: Afegir Validacions JSR
@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(generator="VehSeq")
    @SequenceGenerator(name="VehSeq",sequenceName="tfg.vehicles_seq", allocationSize=1)
	private Long id;
	private String matricula;
   	private String bastidor;
	private String marca;
	private String model;
	@NotNull
	private Date datmat;
	private Long personaId;
	@ManyToOne
	@JoinColumn(name = "personaId", insertable = false, updatable = false)
	private Persona persona;
	
	public Vehicle () {
		
	}
	
	
	
	public Vehicle(String matricula, String bastidor, String marca, String model, Date datmat, Long personaId) {
		super();
		this.matricula = matricula;
		this.bastidor = bastidor;
		this.marca = marca;
		this.model = model;
		this.datmat = datmat;
		this.personaId = personaId;
	}



	public Vehicle(VehicleDto vehicle, Persona persona) {
		this.id=vehicle.getId();
		this.matricula=vehicle.getMatricula();
		this.bastidor=vehicle.getBastidor();
		this.marca=vehicle.getMarca();
		this.model=vehicle.getModel();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.datmat=sdf.parse(vehicle.getDatmat());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.persona=persona;
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
	public Long getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
