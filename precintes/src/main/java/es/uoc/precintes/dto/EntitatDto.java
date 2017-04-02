package es.uoc.precintes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.model.Entitat;

public class EntitatDto {
		@NotNull
		@Size(min=4,max=10)
		private String id;
		@NotNull
		@Size(min=4,max=30)
		private String descripcio;
				
		public EntitatDto() {
			
		}

		public EntitatDto(Entitat entitat) {
			this.id=entitat.getId();
			this.descripcio=entitat.getDescripcio();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDescripcio() {
			return descripcio;
		}

		public void setDescripcio(String descripcio) {
			this.descripcio = descripcio;
		}

		

		
	}