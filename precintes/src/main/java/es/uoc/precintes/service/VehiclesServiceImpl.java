package es.uoc.precintes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uoc.precintes.dao.PrecintesDao;
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
	@Autowired
	private PrecintesDao precDao;
	
	@Override
	public VehicleDto findVehicleByMatricula(String matric) {
		VehicleDto vehDto = null;
		Vehicle vehicle = vehDao.findVehicleByMatricula(matric);
		if (vehicle != null) {
			vehDto = Convert.toDto(vehicle);
			if (vehDto.getId()!=null) {
				long numpre=precDao.getNumPrecintesVigents(vehDto.getId());
				vehDto.setNumpre(numpre);
			}
		} else {
			vehDto = new VehicleDto();
			ErrorDto error = new ErrorDto("error.vehicle.invalid");
			vehDto.getErrores().add(error);
		}

		return vehDto;
	}

	@Override
	public VehicleDto getVehicle(Long vehicleId) {
		VehicleDto vehDto= null;
		if (vehicleId != null) {
			Vehicle vehicle = vehDao.getVehicle(vehicleId);
			vehDto= Convert.toDto(vehicle);
			if (vehDto.getId()!=null) {
				long numpre=precDao.getNumPrecintesVigents(vehDto.getId());
				vehDto.setNumpre(numpre);
			}
		}
		return vehDto;
	}

	@Override
	@Transactional
	public Long saveVehicle(VehicleDto vehDto) {
		Persona persona=Convert.toDao(vehDto.getPersona());
		vehDao.savePersona(persona);
		Vehicle vehicle=Convert.toDao(vehDto);
		vehicle.setPersona(persona);
		vehicle.setPersonaId(persona.getId());
		try {
			vehDao.saveVehicle(vehicle);
		} catch (Exception e) {
			//TODO: handle error
			e.printStackTrace();
		}
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
