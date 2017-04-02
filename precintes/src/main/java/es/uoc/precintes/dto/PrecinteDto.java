package es.uoc.precintes.dto;

import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;

import es.uoc.precintes.model.Precinte;

public class PrecinteDto extends BaseDto{
	
	
	private Long id;
	@NotNull
	private String datpre;
	private String referencia;
	private String obspre;
	private String datdes;
	private String obsdes;
	@NotNull
	private String usuariId;
	@NotNull
	private String concepteId;
	@NotNull
	private String concepteDesc;
	@NotNull
	private String entitatId;
	@NotNull
	private String entitatDesc;
	private MotiuDto motiu;
	
	
	public PrecinteDto(Precinte precinte) {
		this.id=precinte.getId();
		this.referencia=precinte.getReferencia();
		this.obspre=precinte.getObspre();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.datpre=sdf.format( precinte.getDatpre());
		this.datdes=sdf.format(precinte.getDatdes());
		this.obsdes=precinte.getObsdes();
		this.usuariId=precinte.getUsuariId();
		this.concepteId=precinte.getConcepte().getId().getId();
		this.concepteDesc=precinte.getConcepte().getDescripcio();
		this.entitatId=precinte.getEntitat().getId();
		this.entitatDesc=precinte.getEntitat().getDescripcio();
		if (precinte.getMotiu()!=null) {
			this.motiu=new MotiuDto(precinte.getMotiu());
		}
		
		
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

	public String getDatpre() {
		return datpre;
	}

	public void setDatpre(String datpre) {
		this.datpre = datpre;
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

	public String getDatdes() {
		return datdes;
	}

	public void setDatdes(String datdes) {
		this.datdes = datdes;
	}

	public String getObsdes() {
		return obsdes;
	}

	public void setObsdes(String obsdes) {
		this.obsdes = obsdes;
	}

	public String getUsuariId() {
		return usuariId;
	}

	public void setUsuariId(String usuariId) {
		this.usuariId = usuariId;
	}

	public String getConcepteId() {
		return concepteId;
	}

	public void setConcepteId(String concepteId) {
		this.concepteId = concepteId;
	}

	public String getConcepteDesc() {
		return concepteDesc;
	}

	public void setConcepteDesc(String concepteDesc) {
		this.concepteDesc = concepteDesc;
	}

	public String getEntitatId() {
		return entitatId;
	}

	public void setEntitatId(String entitatId) {
		this.entitatId = entitatId;
	}

	public String getEntitatDesc() {
		return entitatDesc;
	}

	public void setEntitatDesc(String entitatDesc) {
		this.entitatDesc = entitatDesc;
	}

}
