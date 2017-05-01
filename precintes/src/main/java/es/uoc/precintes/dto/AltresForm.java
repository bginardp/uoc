package es.uoc.precintes.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AltresForm extends BaseDto {
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datdespre;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datfinpre;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datdesdespre;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datfindespre;
	private String entitatId;
	private String concepteId;
	private String motiuId;
	
	public AltresForm() {
		
	}

	public Date getDatdespre() {
		return datdespre;
	}

	public void setDatdespre(Date datdespre) {
		this.datdespre = datdespre;
	}

	public Date getDatfinpre() {
		return datfinpre;
	}

	public void setDatfinpre(Date datfinpre) {
		this.datfinpre = datfinpre;
	}

	public Date getDatdesdespre() {
		return datdesdespre;
	}

	public void setDatdesdespre(Date datdesdespre) {
		this.datdesdespre = datdesdespre;
	}

	public Date getDatfindespre() {
		return datfindespre;
	}

	public void setDatfindespre(Date datfindespre) {
		this.datfindespre = datfindespre;
	}

	public String getEntitatId() {
		return entitatId;
	}

	public void setEntitatId(String entitatId) {
		this.entitatId = entitatId;
	}

	public String getConcepteId() {
		return concepteId;
	}

	public void setConcepteId(String concepteId) {
		this.concepteId = concepteId;
	}

	public String getMotiuId() {
		return motiuId;
	}

	public void setMotiuId(String motiuId) {
		this.motiuId = motiuId;
	}
	
	
}
