package es.uoc.precintes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uoc.precintes.dao.PrecintesDao;
import es.uoc.precintes.dto.PrecinteDto;

@Service
public class PrecintesServiceImpl implements PrecintesService {
	@Autowired
	private PrecintesDao precDao;

	@Override
	public List<PrecinteDto> findPrecintesByCriteris(String criteri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long registerPrecinte(PrecinteDto precinte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerDesprecinte(PrecinteDto desprecinte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrecinteDto getPrecinte(long precinteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editPrecinte(PrecinteDto precinte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editDesPrecinte(PrecinteDto desprecinte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelDesPrecinte(PrecinteDto desprecinte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumPrecintesVigents(String matricula) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
