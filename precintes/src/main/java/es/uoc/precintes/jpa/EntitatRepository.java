package es.uoc.precintes.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.uoc.precintes.model.Entitat;



public interface EntitatRepository extends PagingAndSortingRepository<Entitat, String> {

}
