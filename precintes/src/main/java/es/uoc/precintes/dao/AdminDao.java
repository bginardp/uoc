package es.uoc.precintes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import es.uoc.precintes.jpa.ConcepteRepository;
import es.uoc.precintes.jpa.EntitatRepository;
import es.uoc.precintes.jpa.MotiuRepository;
import es.uoc.precintes.jpa.UsuariRepository;
import es.uoc.precintes.model.Concepte;
import es.uoc.precintes.model.ConcepteId;
import es.uoc.precintes.model.Entitat;
import es.uoc.precintes.model.Motiu;
import es.uoc.precintes.model.Usuari;

@Component
public class AdminDao {
	@Autowired
	private EntitatRepository entitatRepository;
	@Autowired
	private ConcepteRepository concepteRepository;
	@Autowired
	private MotiuRepository motiuRepository;
	@Autowired
	private UsuariRepository usuariRepository;

	@PostConstruct
	private void init() {
		motiuRepository.save(new Motiu("DEPA","Deute pagada"));
		motiuRepository.save(new Motiu("ERROR","Error"));
		motiuRepository.save(new Motiu("ALTRES","Altres"));
		entitatRepository.save(new Entitat("JUDI","Judicial"));
		entitatRepository.save(new Entitat("RECAP","Recaptador"));
		entitatRepository.save(new Entitat("ORGPO","Organisme Policial"));
		concepteRepository.save(new Concepte("JUDI","JUGJAT01","Judjat nro 1 primera instancia"));
		concepteRepository.save(new Concepte("JUDI","JUGJAT02","Judjat nro 2 primera instancia"));
		concepteRepository.save(new Concepte("JUDI","JUGJAT03","Judjat nro 3 primera instancia"));
		concepteRepository.save(new Concepte("RECAP","VOLUN","Recaptador de impostos en voluntaria"));
		concepteRepository.save(new Concepte("RECAP","EXECU","Recaptador de impostos executiva"));
		concepteRepository.save(new Concepte("RECAP","MULT","Recaptador de multes"));
		concepteRepository.save(new Concepte("ORGPO","LOCAL","Policia Local"));
		concepteRepository.save(new Concepte("ORGPO","NACIO","Policia Nacional"));
		usuariRepository.save(new Usuari("admin","admin","ADMIN"));
		usuariRepository.save(new Usuari("user","user","USER"));
	}

	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels) {
			result.add(label);
		}
		return result;
	}

	public List<Entitat> findAllEntitats() {
		Iterable<Entitat> entitats = entitatRepository.findAll(new Sort(new Order(Direction.ASC, "id")));
		return convertItToList(entitats);
	}

	public List<Concepte> findAllConceptesByEntitat(String entitatId) {
		Iterable<Concepte> conceptes = concepteRepository.findByEntitatIdIgnoreCase(entitatId);
		return convertItToList(conceptes);
	}
	
	public Entitat getEntitat(String entitatId) {
		if (entitatId != null) {
			return entitatRepository.findOne(entitatId);
		}
		return null;
	}

	public void removeEntitat(String entitatId) {
		if (entitatId != null) {
			entitatRepository.delete(entitatId);
		}

	}

	public void saveEntitat(Entitat entitat) {
		if (entitat != null) {
			entitatRepository.save(entitat);
		}
	}

	public List<Motiu> findAllMotius() {
		Iterable<Motiu> motius = motiuRepository.findAll(new Sort(new Order(Direction.ASC, "id")));
		return convertItToList(motius);
	}

	public Motiu getMotiu(String motiuId) {
		if (motiuId != null) {
			return motiuRepository.findOne(motiuId);
		}
		return null;
	}

	public void removeMotiu(String motiuId) {
		if (motiuId != null) {
			motiuRepository.delete(motiuId);
		}

	}

	public void saveMotiu(Motiu motiu) {
		if (motiu != null) {
			motiuRepository.save(motiu);
		}
	}

	public Concepte getConcepte(String entitatId, String concepteId) {
		if (entitatId != null && concepteId != null) {
			return concepteRepository.findOne(new ConcepteId(entitatId, concepteId));
		}
		return null;
	}

	public void removeConcepte(String entitatId, String concepteId) {
		if (entitatId != null && concepteId != null) {
			ConcepteId concepteKeyId = new ConcepteId(entitatId,concepteId);
			try {
				concepteRepository.delete(concepteKeyId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

	}

	public void saveConcepte(Concepte concepte) {
		if (concepte != null) {
			concepteRepository.save(concepte);
		}
	}
	
	public Usuari getUsuari(String usuariId) {
		Usuari usuari=null;
		if (usuariId!=null) {
			usuari= usuariRepository.findOne(usuariId);
		}
		return usuari;
	}

}
