package es.uoc.precintes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uoc.precintes.dao.PrecintesDao;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.utils.Convert;

@Service
public class PrecintesServiceImpl implements PrecintesService {
	@Autowired
	private PrecintesDao precDao;

	public List<PrecinteDto> findPrecintesByCriteris(Date datdespre, Date datfipre, Date datdesdespre, Date datfidespre, String entitatId, String concepteId, String motiuId) {
		List<Precinte> precintes=precDao.findPrecintesByCriteris(datdespre, datfipre, datdesdespre, datfidespre, entitatId, concepteId, motiuId);
		List<PrecinteDto> content=new ArrayList<PrecinteDto>();
		for (Precinte precinte : precintes){
			content.add(Convert.toDto(precinte));
		}
		return content;
	}
	
	
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
	public int getNumPrecintesVigents(Long idVehicle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PrecinteDto> findPrecintesByVehicleId(Long idVehicle) {
		List<Precinte> precintes = precDao.findPrecintesByVehicleId(idVehicle);
		List<PrecinteDto> content = new ArrayList<PrecinteDto>();
		for (Precinte precinte : precintes) {
			content.add(new PrecinteDto(precinte));
		}
		return content;
	}

}
