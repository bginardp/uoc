package es.uoc.precintes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import es.uoc.precintes.dao.AdminDao;
import es.uoc.precintes.dao.PrecintesDao;
import es.uoc.precintes.dto.ErrorDto;
import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.model.Usuari;
import es.uoc.precintes.utils.Convert;
import es.uoc.precintes.utils.ModelUtils;

@Service
public class PrecintesServiceImpl implements PrecintesService {
	@Autowired
	private PrecintesDao precDao;
	@Autowired
	private AdminDao adminDao;

	public List<PrecinteDto> findPrecintesByCriteris(Date datdespre, Date datfipre, Date datdesdespre, Date datfidespre,
			String entitatId, String concepteId, String motiuId) {
		List<Precinte> precintes = precDao.findPrecintesByCriteris(datdespre, datfipre, datdesdespre, datfidespre,
				entitatId, concepteId, motiuId);
		List<PrecinteDto> content = new ArrayList<PrecinteDto>();
		for (Precinte precinte : precintes) {
			content.add(Convert.toDto(precinte));
		}
		return content;
	}

	@Override
	public Long registerPrecinte(PrecinteDto precinteDto) {
		Precinte precinte = Convert.toDao(precinteDto);
		// PrecinteDto precinteDtoNew=new PrecinteDto();
		try {
			precDao.savePrecinte(precinte);
			// precinteDtoNew=Convert.toDto(precinte);
		} catch (Exception e) {
			// TODO: handle error
			e.printStackTrace();
		}
		return precinte.getId();
	}

	@Override
	public PrecinteDto registerDesprecinte(PrecinteDto desprecinteDto) {
		ErrorDto error = null;
		if (ModelUtils.afterThat(desprecinteDto.getDatpre(), desprecinteDto.getDatdes())) {
			error = new ErrorDto(ModelUtils.ERROR_DATA_DESPRECINTE_KEY);
			desprecinteDto.getErrores().add(error);
		}
		if (StringUtils.isEmpty(desprecinteDto.getMotiu().getId())) {
			error = new ErrorDto(ModelUtils.ERROR_MOTIU_DESPRECINTE_OBLIGATORI_KEY);
			desprecinteDto.getErrores().add(error);
		}
		if (!desprecinteDto.hasErrores()) {
			Precinte precinte = Convert.toDao(desprecinteDto);
			PrecinteDto precinteDto = new PrecinteDto();

			try {
				precDao.savePrecinte(precinte);
				precinteDto = Convert.toDto(precinte);
			} catch (Exception e) {
				e.printStackTrace();
				error = new ErrorDto(e.getMessage());
				desprecinteDto.getErrores().add(error);
			}
			return precinteDto;
		} else {
			return desprecinteDto;
		}

	}

	@Override
	public PrecinteDto getPrecinte(long precinteId) {
		PrecinteDto precinte = Convert.toDto(precDao.getPrecinte(precinteId));
		return precinte;
	}

	@Override
	public void editPrecinte(PrecinteDto precinteDto) {
		Precinte precinte = Convert.toDao(precinteDto);
		try {
			precDao.savePrecinte(precinte);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelDesPrecinte(Long precinteId, String usuariId) {
		try {
			Precinte precinte = precDao.getPrecinte(precinteId);
			Usuari usuari = adminDao.getUsuari(usuariId);
			precinte.setDatdes(null);
			precinte.setMotiu(null);
			precinte.setUsuari(usuari);
			precDao.savePrecinte(precinte);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
