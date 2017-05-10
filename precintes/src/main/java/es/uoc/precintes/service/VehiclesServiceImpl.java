package es.uoc.precintes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uoc.precintes.PrecintesException;
import es.uoc.precintes.dao.PrecintesDao;
import es.uoc.precintes.dao.VehiclesDao;
import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.VehicleDto;
import es.uoc.precintes.model.Persona;
import es.uoc.precintes.model.Vehicle;
import es.uoc.precintes.utils.Convert;
import es.uoc.precintes.utils.ModelUtils;

@Service
public class VehiclesServiceImpl implements VehiclesService {
	@Autowired
	private VehiclesDao vehDao;
	@Autowired
	private PrecintesDao precDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public VehicleDto findVehicleByMatricula(String matric) {
		VehicleDto vehDto = null;
		Vehicle vehicle = vehDao.findVehicleByMatricula(matric);
		if (vehicle != null) {
			vehDto = Convert.toDto(vehicle);
			if (vehDto.getId() != null) {
				long numpre = precDao.getNumPrecintesVigents(vehDto.getId());
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
		VehicleDto vehDto = null;
		if (vehicleId != null) {
			Vehicle vehicle = vehDao.getVehicle(vehicleId);
			vehDto = Convert.toDto(vehicle);
			if (vehDto.getId() != null) {
				long numpre = precDao.getNumPrecintesVigents(vehDto.getId());
				vehDto.setNumpre(numpre);
			}
		}
		return vehDto;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class, PrecintesException.class })
	public VehicleDto saveVehicle(VehicleDto vehDto) {
		try {
			Persona persona = Convert.toDao(vehDto.getPersona());
			Vehicle vehicle = Convert.toDao(vehDto);
			vehicle.setPersona(persona);
			if (vehicle.getId() == null) {
				Vehicle veh1 = vehDao.findVehicleByMatricula(vehicle.getMatricula());
				if (veh1 != null) {
					throw new PrecintesException(ModelUtils.ERROR_MATRICULA_JAEXISTEIX_KEY);
				} else {
					veh1 = vehDao.findVehicleByBastidor(vehicle.getBastidor());
					if (veh1 != null) {
						throw new PrecintesException(ModelUtils.ERROR_BASTIDOR_JAEXISTEIX_KEY);
					} else {
						vehDao.savePersona(persona);
						vehicle.setPersonaId(persona.getId());
						vehDao.saveVehicle(vehicle);
						vehDto = Convert.toDto(vehicle);
					}
				}
			} else {
				vehDao.saveVehicle(vehicle);
				vehDto = Convert.toDto(vehicle);
			}
		} catch (PrecintesException e) {
			vehDto.getErrores().add(new ErrorDto(e.getKey()));
		} catch (Exception e) {
			vehDto.getErrores().add(new ErrorDto(ModelUtils.ERROR_DESCONEGUT_KEY));
			logger.error(e.getStackTrace().toString());
		}
		return vehDto;
	}

}
