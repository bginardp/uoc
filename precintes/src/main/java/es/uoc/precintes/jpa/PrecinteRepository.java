package es.uoc.precintes.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.uoc.precintes.model.Precinte;

public interface PrecinteRepository extends PagingAndSortingRepository<Precinte, Long> {
}
