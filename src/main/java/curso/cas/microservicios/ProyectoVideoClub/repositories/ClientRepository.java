package curso.cas.microservicios.ProyectoVideoClub.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;

public interface ClientRepository extends CrudRepository<Cliente, Integer> {

	Optional<Cliente> findById(Integer id);

	List<Cliente> findByNameOrEmail(String name, String email);

	List<Cliente> findDistincClienteByNameOrEmail(String name, String email);

	List<Cliente> findByNameOrEmailIgnoreCase(String name, String email);

	List<Cliente> findByNameOrEmailOrderByNameAsc(String name, String email);

	List<Cliente> findByNameOrEmailOrderByNameDesc(String name, String email);

	Cliente findTopByOrderByNameDesc();

	Page<Cliente> queryFirst10ByName(String name, Pageable pageable);

	List<Cliente> findFirst10ByEmail(String email);

	@Query("select c from Cliente c where c.email = ?1")
	List<Cliente> findByEmail(String email);

	@Query(value = "select * from cliente where email = ?1", nativeQuery = true)
	List<Cliente> findByEmail2(String email);

	@Query(value = "select * from cliente where name = ?1", countQuery = "select count(*) from cliente where name = ?1", nativeQuery = true)
	Page<Cliente> findByName(String name, Pageable pageable);

	@Query("select c from Cliente c where c.name like ?1%")
	List<Cliente> busquedaNombreAsc(String name, Sort sort);

	@Query("select c from Cliente c where c.name like :name%")
	List<Cliente> busquedaNombreAsc2(@Param("name") String name, Sort sort);

	@Query("delete from Cliente c where c.name = ?1")
	@Modifying
	@Transactional
	void deleteByName(String name);

}
