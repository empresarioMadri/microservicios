package curso.cas.microservicios.ProyectoVideoClub.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PeliculaValoracionKey implements Serializable{
	
	@Column(name="pelicula_id")
	Integer pelicula_id;
	
	@Column(name="cliente_id")
	Integer cliente_id;

}
