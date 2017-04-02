package es.uoc.precintes.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConcepteId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "entitatId")
	private String entitatId;
	@Column(name = "id")
	private String id;

	public ConcepteId() {

	}

	public ConcepteId(String entitatId, String concepteId) {
		this.entitatId = entitatId;
		this.id = concepteId;
	}

	public String getEntitatId() {
		return entitatId;
	}

	public void setEntitatId(String entitatId) {
		this.entitatId = entitatId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ConcepteId))
			return false;
		ConcepteId that = (ConcepteId) o;
		return Objects.equals(getEntitatId(), that.getEntitatId()) && Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getEntitatId(), getId());
	}
}
