package es.uoc.precintes.service;

import es.uoc.precintes.dto.VehicleDto;

public interface VehiclesService {
	
	VehicleDto findVehicleByMatricula(String matric);
	VehicleDto getVehicle(Long vehicleId);
	VehicleDto saveVehicle(VehicleDto vehicle);
	
}
