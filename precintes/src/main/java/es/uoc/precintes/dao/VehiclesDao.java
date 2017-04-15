package es.uoc.precintes.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uoc.precintes.jpa.PersonaRepository;
import es.uoc.precintes.jpa.PrecinteRepository;
import es.uoc.precintes.jpa.VehicleRepository;
import es.uoc.precintes.model.Persona;
import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.model.Vehicle;

@Component
public class VehiclesDao {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private PrecinteRepository precinteRepository;

	@PostConstruct
	private void init() {
		Persona bernat=new Persona("41699128J","BERNAT","GINARD","PRATS","CE JOVELLANOS num:14 pis 2 pta A","PALMA","07003","ILLES BALEARS","971123456","bginardp@uoc.com");
		Persona laia = new Persona("59942414K","LAIA","GINARD","LLABRES","CE JOVELLANOS num:14 pis 2 pta A","PALMA","07003","ILLES BALEARS","971123456","lginardl@gmail.com");
		Persona isabel = new Persona("31212124C","ISABEL","LLABRES","SERRA","CE GRAN num:4 pis Baixos","LLUBI","07003","ILLES BALEARS","971123456","llabres@gmail.com");
		
		personaRepository.save(bernat);
		personaRepository.save(laia);
		personaRepository.save(isabel);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
		try {
			data = sdf.parse("01/02/2000");
			vehicleRepository.save(new Vehicle("1111BBC","W122112345RT54Y6W","SEAT","LEON",data,bernat.getId()));
			Vehicle veh1=vehicleRepository.findByMatriculaIgnoreCase("1111BBC");
			Precinte precinte= new Precinte(data,"REF. 123456789","CAS NRO 11234",veh1.getId(),"user","JUDI","JUGJAT01");
			precinteRepository.save(precinte);
			
			data = sdf.parse("01/05/2016");
			vehicleRepository.save(new Vehicle("2222JCS","Q123112345RT54Y6W","REANULT","LAGUNA",data,laia.getId()));
			Vehicle veh2=vehicleRepository.findByMatriculaIgnoreCase("2222JCS");
			precinte= new Precinte(data,"REF. 123456789","CAS NRO 11234",veh2.getId(),"user","JUDI","JUGJAT02");
			precinteRepository.save(precinte);
			
			data = sdf.parse("01/02/2017");
			vehicleRepository.save(new Vehicle("3333JKS","WR22112345R454Y6W","FORD","FOCUS",data,isabel.getId()));
			Vehicle veh3=vehicleRepository.findByMatriculaIgnoreCase("3333JKS");
			precinte= new Precinte(data,"REF. 123456789","CAS NRO 11234",veh3.getId(),"admin","JUDI","JUGJAT03");
			precinteRepository.save(precinte);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels) {
			result.add(label);
		}
		return result;
	}

	public Vehicle findVehicleByMatricula(String matricula){
		if (matricula != null) {
			return vehicleRepository.findByMatriculaIgnoreCase(matricula);
		}
		return null;
	}

	public void savePersona(Persona persona) {
		if (persona != null) {
			personaRepository.save(persona);
		}
	}
	
	public void saveVehicle(Vehicle vehicle) {
		if (vehicle != null) {
			vehicleRepository.save(vehicle);
		}
	}

	public Vehicle getVehicle(Long vehicleId) {
		if (vehicleId != null) {
			return vehicleRepository.findOne(vehicleId);
		}
		return null;
	}
	
	public Persona getPersona(Long personaId) {
		if (personaId != null) {
			return personaRepository.findOne(personaId);
		}
		return null;
	}
	
	
	
}
