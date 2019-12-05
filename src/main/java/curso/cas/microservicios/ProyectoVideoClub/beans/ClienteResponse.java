package curso.cas.microservicios.ProyectoVideoClub.beans;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;
import curso.cas.microservicios.ProyectoVideoClub.entities.Direccion;
import curso.cas.microservicios.ProyectoVideoClub.entities.Pelicula;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ClienteResponse {
	
	private Integer id;

	private String name;

	private String telephone;

	private String email;

	private List<PeliculaResponse> peliculas;

	private DireccionResponse direccion;

}
