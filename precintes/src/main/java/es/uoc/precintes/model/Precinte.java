package es.uoc.precintes.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

//TODO: Afegir Validacions JSR
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
	@ManyToOne
	@JoinColumn(name = "entitatId", insertable = false, updatable = false)
	private Entitat entitat;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "entitatId", referencedColumnName = "entitatId"),
			@JoinColumn(name = "concepteId", referencedColumnName = "id") })
	private Concepte concepte;
	@ManyToOne
	@JoinColumn(name = "motiuId", insertable = false, updatable = false)
	private Motiu motiu;

	public Precinte() {

	}

	public Precinte(PrecinteDto precinte, Entitat entitat, Concepte concepte, Usuari usuari, Motiu motiu) {
		this.id = precinte.getId();
		this.referencia = precinte.getReferencia();
		this.obspre = precinte.getObspre();
		this.obsdes = precinte.getObsdes();
		this.usuari = usuari;
		this.entitat = entitat;
		this.concepte = concepte;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.datpre = sdf.parse(precinte.getDatpre());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (precinte.getDatdes() != null) {
			try {
				this.datdes = sdf.parse(precinte.getDatdes());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.motiu=motiu;

		
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

}
