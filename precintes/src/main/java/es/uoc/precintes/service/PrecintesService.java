package es.uoc.precintes.service;

import java.util.Date;
import java.util.List;

import es.uoc.precintes.dto.PrecinteDto;

public interface PrecintesService {

	public List<PrecinteDto> findPrecintesByCriteris(Date datdespre, Date datfipre, Date datdesdespre, Date datfidespre, String entitatId, String concepteId, String motiuId);
	public List<PrecinteDto> findPrecintesByVehicleId(Long idVehicle);
	Long registerPrecinte(PrecinteDto precinte);
	PrecinteDto registerDesprecinte(PrecinteDto desprecinte);
	PrecinteDto getPrecinte(long precinteId);
	void editPrecinte(PrecinteDto precinte);
	void cancelDesPrecinte(Long precinteId, String usuariId);
}
