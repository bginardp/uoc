package es.uoc.precintes.utils;

import es.uoc.precintes.dto.ConcepteDto;
import es.uoc.precintes.dto.EntitatDto;
import es.uoc.precintes.dto.MotiuDto;
import es.uoc.precintes.dto.PersonaDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.dto.UsuariDto;
import es.uoc.precintes.dto.VehicleDto;
import es.uoc.precintes.model.Concepte;
import es.uoc.precintes.model.Entitat;
import es.uoc.precintes.model.Motiu;
import es.uoc.precintes.model.Persona;
import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.model.Usuari;
import es.uoc.precintes.model.Vehicle;

public class Convert {

	public static PersonaDto toDto(Persona persona) {
		PersonaDto personaDto = null;
		if (persona != null) {
			personaDto = new PersonaDto(persona);
		}
		return personaDto;
	}

	public static Persona toDao(PersonaDto personaDto) {
		Persona persona = null;
		if (personaDto != null) {
			persona = new Persona(personaDto);
		}
		return persona;
	}

	public static VehicleDto toDto(Vehicle vehicle) {
		VehicleDto vehicleDto = null;
		if (vehicle != null) {
			vehicleDto = new VehicleDto(vehicle);
		}
		return vehicleDto;

	}
	
	public static EntitatDto toDto(Entitat entitat) {
		EntitatDto entitatDto = null;
		if (entitat != null) {
			entitatDto = new EntitatDto(entitat);
		}
		return entitatDto;

	}
	
	public static ConcepteDto toDto(Concepte concepte) {
		ConcepteDto concepteDto = null;
		if (concepte != null) {
			concepteDto = new ConcepteDto(concepte);
		}
		return concepteDto;

	}
	public static MotiuDto toDto(Motiu motiu) {
		MotiuDto motiuDto = null;
		if (motiu != null) {
			motiuDto = new MotiuDto(motiu);
		}
		return motiuDto;

	}
	
	public static UsuariDto toDto(Usuari usuari) {
		UsuariDto usuariDto = null;
		if (usuari != null) {
			usuariDto = new UsuariDto(usuari);
		}
		return usuariDto;

	}
	

	public static PrecinteDto toDto(Precinte precinte) {
		PrecinteDto precinteDto = null;
		if (precinte != null) {
			precinteDto = new PrecinteDto(precinte);
		}
		return precinteDto;

	}
	public static Vehicle toDao(VehicleDto vehicleDto) {
		Vehicle vehicle = null;
		if (vehicleDto != null) {
			vehicle = new Vehicle(vehicleDto);
		}
		return vehicle;
	}
	
	public static Precinte toDao(PrecinteDto precinteDto) {
		Precinte precinte = null;
		if (precinteDto != null) {
			precinte = new Precinte(precinteDto);
		}
		return precinte;
	}
	
	public static Entitat toDao(EntitatDto entitatDto) {
		Entitat entitat = null;
		if (entitatDto != null) {
			entitat = new Entitat(entitatDto);
		}
		return entitat;
	}
	public static Concepte toDao(ConcepteDto concepteDto) {
		Concepte concepte = null;
		if (concepteDto != null) {
			concepte = new Concepte(concepteDto);
		}
		return concepte;
	}
	public static Motiu toDao(MotiuDto motiuDto) {
		Motiu motiu = null;
		if (motiuDto != null) {
			motiu = new Motiu(motiuDto);
		}
		return motiu;
	}
	
	public static Usuari toDao(UsuariDto usuariDto) {
		Usuari usuari = null;
		if (usuariDto != null) {
			usuari = new Usuari(usuariDto);
		}
		return usuari;
	}
	
	
	
}
