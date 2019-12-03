package curso.cas.microservicios.ProyectoVideoClub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;

public interface ClientRepository extends CrudRepository<Cliente, Integer>{

	
	Optional<Cliente> findById(Integer id);
	
	List<Cliente> findByNameOrEmail(String name,String email);

}
