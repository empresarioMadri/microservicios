package curso.cas.microservicios.ProyectoVideoClub.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PeliculaValoracion {
	
	@EmbeddedId
	PeliculaValoracionKey id;
	
	@ManyToOne
	@MapsId("pelicula_id")
	@JoinColumn(name="pelicula_id")
	Pelicula pelicula;
	
	@ManyToOne
	@MapsId("cliente_id")
	@JoinColumn(name="cliente_id")
	Cliente cliente;
	
	int valoracion;

}
