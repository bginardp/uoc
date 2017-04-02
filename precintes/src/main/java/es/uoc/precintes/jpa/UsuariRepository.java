package es.uoc.precintes.jpa;


import org.springframework.data.repository.CrudRepository;

import es.uoc.precintes.model.Usuari;

public interface UsuariRepository extends CrudRepository<Usuari, String> {

}
