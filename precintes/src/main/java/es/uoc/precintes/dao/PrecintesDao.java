package es.uoc.precintes.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uoc.precintes.jpa.PrecinteRepository;
import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.model.Vehicle;

@Component
public class PrecintesDao {
	@Autowired
	private PrecinteRepository precinteRepository;
	

	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels) {
			result.add(label);
		}
		return result;
	}

	
	public Vehicle findPrecintesByCriteris(String criteris){
		//TODO
		return null;
	}

	public Vehicle findPrecintesByMatricula(String matricula){
		//TODO
		return null;
	}	

	public void savePrecinte(Precinte precinte) {
		if (precinte != null) {
			precinteRepository.save(precinte);
		}
	}
	
	public Precinte getPrecinte(Long precinteId) {
		if (precinteId != null) {
			return precinteRepository.findOne(precinteId);
		}
		return null;
	}

	public int getNumPrecintesVigents(String matricula) {
		//TODO
		return 0;
	}
	
	
	
}
