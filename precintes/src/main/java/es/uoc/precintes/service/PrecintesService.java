package es.uoc.precintes.service;

import java.util.List;

import es.uoc.precintes.dto.PrecinteDto;

public interface PrecintesService {
// TODO
//	public Page<PrecinteDto> findPrecintesByCriteris(Date despre, Date finspre, Date desdespre, Date finddespre, String entitatId, String concepteId);
	public List<PrecinteDto> findPrecintesByCriteris(String criteri);
	Long registerPrecinte(PrecinteDto precinte);
	void registerDesprecinte(PrecinteDto desprecinte);
	PrecinteDto getPrecinte(long precinteId);
	void editPrecinte(PrecinteDto precinte);
	void editDesPrecinte(PrecinteDto desprecinte);
	void cancelDesPrecinte(PrecinteDto desprecinte);
	int getNumPrecintesVigents(String matricula);
}
