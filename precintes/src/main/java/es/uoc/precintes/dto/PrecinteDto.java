package es.uoc.precintes.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.utils.Convert;

public class PrecinteDto extends BaseDto{
	
	
	private Long id;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datpre;
	private String referencia;
	private String obspre;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datdes;
	private String obsdes;
	private VehicleDto vehicle;
	private UsuariDto usuari;
	private ConcepteDto concepte;
	private EntitatDto entitat;
	private MotiuDto motiu;
	
	public PrecinteDto() {
		this.datpre=new Date();
	}
	
	public PrecinteDto(Precinte precinte) {
		this.id=precinte.getId();
		this.referencia=precinte.getReferencia();
		this.obspre=precinte.getObspre();
		this.datpre=precinte.getDatpre();
		this.datdes=precinte.getDatdes();
		this.obsdes=precinte.getObsdes();
		this.vehicle=Convert.toDto(precinte.getVehicle());
		this.usuari=Convert.toDto(precinte.getUsuari());
		this.concepte=Convert.toDto(precinte.getConcepte());
		this.entitat=Convert.toDto(precinte.getEntitat());
		this.motiu=Convert.toDto(precinte.getMotiu());
	
	}

	public VehicleDto getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDto vehicle) {
		this.vehicle = vehicle;
	}

	public MotiuDto getMotiu() {
		return motiu;
	}

	public void setMotiu(MotiuDto motiu) {
		this.motiu = motiu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getObspre() {
		return obspre;
	}

	public void setObspre(String obspre) {
		this.obspre = obspre;
	}

	
	public String getObsdes() {
		return obsdes;
	}

	public void setObsdes(String obsdes) {
		this.obsdes = obsdes;
	}

	
	public UsuariDto getUsuari() {
		return usuari;
	}

	public void setUsuari(UsuariDto usuari) {
		this.usuari = usuari;
	}

	public Date getDatpre() {
		return datpre;
	}

	public void setDatpre(Date datpre) {
		this.datpre = datpre;
	}

	public Date getDatdes() {
		return datdes;
	}

	public void setDatdes(Date datdes) {
		this.datdes = datdes;
	}

	public ConcepteDto getConcepte() {
		return concepte;
	}

	public void setConcepte(ConcepteDto concepte) {
		this.concepte = concepte;
	}

	public EntitatDto getEntitat() {
		return entitat;
	}

	public void setEntitat(EntitatDto entitat) {
		this.entitat = entitat;
	}
	
	public boolean isDesprecintat() {
		return (datdes!=null);
	}

	@Override
	public String toString() {
		return "PrecinteDto [id=" + id + ", datpre=" + datpre + ", referencia=" + referencia + ", obspre=" + obspre
				+ ", datdes=" + datdes + ", obsdes=" + obsdes + ", vehicle=" + vehicle + ", usuari=" + usuari
				+ ", concepte=" + concepte + ", entitat=" + entitat + ", motiu=" + motiu + "]";
	}

	
}
