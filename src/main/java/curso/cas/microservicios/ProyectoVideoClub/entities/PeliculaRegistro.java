package curso.cas.microservicios.ProyectoVideoClub.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
@Entity
public class PeliculaRegistro {
	
	@Id
	Integer id;
	
	@ManyToOne
	@JoinColumn(name="pelicula_id")
	Pelicula pelicula;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	Cliente cliente;
	
	LocalDateTime fechaRegistro;
	
}
