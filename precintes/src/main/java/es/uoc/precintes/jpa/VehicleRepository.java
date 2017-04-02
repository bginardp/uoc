package es.uoc.precintes.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.uoc.precintes.model.Vehicle;



public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {
	Vehicle findByMatriculaIgnoreCase(String matricula);
}
