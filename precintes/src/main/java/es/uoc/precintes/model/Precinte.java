package es.uoc.precintes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.utils.Convert;

@Entity
@Table(name = "precintes")
public class Precinte {
	@Id
	@GeneratedValue(generator = "PrecSeq")
	@SequenceGenerator(name = "PrecSeq", sequenceName = "tfg.precintes_seq", allocationSize = 1)
	private Long id;
	@NotNull
	private Date datpre;
	private String referencia;
	private String obspre;
	private Date datdes;
	private String obsdes;
	private String usuariId;
	@ManyToOne
	@JoinColumn(name = "usuariId", insertable = false, updatable = false)
	private Usuari usuari;
	@NotNull
	private String entitatId;
	@ManyToOne
	@JoinColumn(name = "entitatId", insertable = false, updatable = false)
	private Entitat entitat;
	@NotNull
	private String concepteId;
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "entitatId", referencedColumnName = "entitatId", insertable = false, updatable = false),
			@JoinColumn(name = "concepteId", referencedColumnName = "id", insertable = false, updatable = false) })
	private Concepte concepte;
	@ManyToOne
	@JoinColumn(name = "motiuId")
	private Motiu motiu;
	@NotNull
	private Long vehicleId;
	@ManyToOne
	@JoinColumn(name = "vehicleId", insertable = false, updatable = false)
	private Vehicle vehicle;

	public Precinte() {

	}

	public Precinte(Date datpre, String referencia, String obspre, Long vehicleId, String usuariId, String entitatId,
			String concepteId) {
		this.datpre = datpre;
		this.referencia = referencia;
		this.obspre = obspre;
		this.vehicleId = vehicleId;
		this.usuariId = usuariId;
		this.entitatId = entitatId;
		this.concepteId = concepteId;

	}

	public Precinte(PrecinteDto precinte) {
		this.id = precinte.getId();
		this.referencia = precinte.getReferencia();
		this.obspre = precinte.getObspre();
		this.obsdes = precinte.getObsdes();
		this.vehicleId = precinte.getVehicle().getId();
		this.entitatId = precinte.getEntitat().getId();
		this.concepteId = precinte.getConcepte().getId();
		this.vehicle = Convert.toDao(precinte.getVehicle());
		this.usuari = Convert.toDao(precinte.getUsuari());
		if (this.usuari != null) {
			this.usuariId = this.usuari.getId();
		}
		this.entitat = Convert.toDao(precinte.getEntitat());
		this.concepte = Convert.toDao(precinte.getConcepte());
		this.motiu = Convert.toDao(precinte.getMotiu());
		this.datpre = precinte.getDatpre();
		this.datdes = precinte.getDatdes();
		this.motiu = Convert.toDao(precinte.getMotiu());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatpre() {
		return datpre;
	}

	public void setDatpre(Date datpre) {
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

	public Date getDatdes() {
		return datdes;
	}

	public void setDatdes(Date datdes) {
		this.datdes = datdes;
	}

	public String getObsdes() {
		return obsdes;
	}

	public void setObsdes(String obsdes) {
		this.obsdes = obsdes;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getUsuariId() {
		return usuariId;
	}

	public void setUsuariId(String usuariId) {
		this.usuariId = usuariId;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public Entitat getEntitat() {
		return entitat;
	}

	public void setEntitat(Entitat entitat) {
		this.entitat = entitat;
	}

	public Concepte getConcepte() {
		return concepte;
	}

	public void setConcepte(Concepte concepte) {
		this.concepte = concepte;
	}

	public Motiu getMotiu() {
		return motiu;
	}

	public void setMotiu(Motiu motiu) {
		this.motiu = motiu;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
