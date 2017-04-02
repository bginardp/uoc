package es.uoc.precintes.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.uoc.precintes.model.Persona;



public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> {

}
