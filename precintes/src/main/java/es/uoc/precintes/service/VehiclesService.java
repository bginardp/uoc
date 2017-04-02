package es.uoc.precintes.service;

import es.uoc.precintes.dto.PersonaDto;
import es.uoc.precintes.dto.VehicleDto;

public interface VehiclesService {
	
	VehicleDto findVehicleByMatricula(String matric);
	VehicleDto getVehicle(Long vehicleId);
	Long saveVehicle(VehicleDto vehicle);
	PersonaDto getTitular(Long titularId);
	Long saveTitular(PersonaDto titular);
	
	
}
