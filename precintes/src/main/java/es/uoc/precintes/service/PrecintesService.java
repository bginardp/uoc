package es.uoc.precintes.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import es.uoc.precintes.dto.PrecinteDto;

public interface PrecintesService {

	public List<PrecinteDto> findPrecintesByCriteris(Date datdespre, Date datfipre, Date datdesdespre, Date datfidespre, String entitatId, String concepteId, String motiuId);
	public List<PrecinteDto> findPrecintesByCriteris(String criteri);
	public List<PrecinteDto> findPrecintesByVehicleId(Long idVehicle);
	Long registerPrecinte(PrecinteDto precinte);
	void registerDesprecinte(PrecinteDto desprecinte);
	PrecinteDto getPrecinte(long precinteId);
	void editPrecinte(PrecinteDto precinte);
	void editDesPrecinte(PrecinteDto desprecinte);
	void cancelDesPrecinte(PrecinteDto desprecinte);
	int getNumPrecintesVigents(Long idVehicle);
}
