package es.uoc.precintes.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.uoc.precintes.model.Motiu;



public interface MotiuRepository extends PagingAndSortingRepository<Motiu, String> {

}
