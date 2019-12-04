package curso.cas.microservicios.ProyectoVideoClub.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String telephone;

	private String email;

	@ManyToMany
	@JoinTable(name = "Cliente_Peliculas", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
	private List<Pelicula> peliculas;

	@ManyToOne
	@JoinColumn(name = "direccion_id", nullable = false, updatable = false)
	private Direccion direccion;

	@OneToMany(mappedBy = "cliente")
	List<PeliculaValoracion> valoraciones;
	
	@OneToMany(mappedBy = "cliente")
	List<PeliculaRegistro> registros;

}
