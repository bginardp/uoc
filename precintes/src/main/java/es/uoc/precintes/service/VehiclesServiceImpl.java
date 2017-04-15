package es.uoc.precintes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uoc.precintes.dao.VehiclesDao;
import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PersonaDto;
import es.uoc.precintes.dto.VehicleDto;
import es.uoc.precintes.model.Persona;
import es.uoc.precintes.model.Vehicle;
import es.uoc.precintes.utils.Convert;

@Service
public class VehiclesServiceImpl implements VehiclesService {
	@Autowired
	private VehiclesDao vehDao;
	
	
	@Override
	public VehicleDto findVehicleByMatricula(String matric) {
		VehicleDto vehDto = null;
		Vehicle vehicle = vehDao.findVehicleByMatricula(matric);
		if (vehicle != null) {
			vehDto = new VehicleDto(vehicle);
		} else {
			vehDto = new VehicleDto();
			ErrorDto error = new ErrorDto("error.vehicle.invalid");
			vehDto.getErrores().add(error);
		}

		return vehDto;
	}

	@Override
	public VehicleDto getVehicle(Long vehicleId) {
		if (vehicleId != null) {
			Vehicle vehicle = vehDao.getVehicle(vehicleId);
			VehicleDto vehDto=new VehicleDto(vehicle);
			return vehDto;
		}
		return null;
	}

	@Override
	public Long saveVehicle(VehicleDto vehDto) {
		Persona persona=Convert.toDao(vehDto.getPersona());
//		Persona persona= vehDao.getPersona(vehDto.getPersonaId());
		Vehicle vehicle=Convert.toDao(vehDto);
		vehDao.savePersona(persona);
		vehDao.saveVehicle(vehicle);
		return vehicle.getId();
	}

	@Override
	public PersonaDto getTitular(Long titularId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveTitular(PersonaDto titular) {
		// TODO Auto-generated method stub
		return null;
	}

}
