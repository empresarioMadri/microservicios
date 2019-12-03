package curso.cas.microservicios.ProyectoVideoClub.repositories;

import org.springframework.data.repository.CrudRepository;

import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;

public interface ClientRepository extends CrudRepository<Cliente, Integer>{

}
