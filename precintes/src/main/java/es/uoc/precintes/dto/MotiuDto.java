package es.uoc.precintes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.uoc.precintes.model.Motiu;

public class MotiuDto {
		@NotNull
		@Size(min=4,max=10)
		private String id;
		@NotNull
		@Size(min=4,max=30)
		private String descripcio;
				
		public MotiuDto() {
			
		}

		public MotiuDto(Motiu motiu) {
			this.id=motiu.getId();
			this.descripcio=motiu.getDescripcio();
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