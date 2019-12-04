package curso.cas.microservicios.ProyectoVideoClub.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class PeliculaValoracionKey implements Serializable{
	
	@Column(name="pelicula_id")
	Integer pelicula_id;
	
	@Column(name="cliente_id")
	Integer cliente_id;

}
