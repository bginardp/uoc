package es.uoc.precintes.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.uoc.precintes.model.Concepte;
import es.uoc.precintes.model.ConcepteId;



public interface ConcepteRepository extends PagingAndSortingRepository<Concepte, ConcepteId> {
	List<Concepte> findByEntitatIdIgnoreCase(String entitat);
}
