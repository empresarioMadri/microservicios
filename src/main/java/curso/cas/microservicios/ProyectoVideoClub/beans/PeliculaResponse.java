package curso.cas.microservicios.ProyectoVideoClub.beans;

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
public class PeliculaResponse {
	
	private Integer id;
	
	private String nombre;
	
	private String director;
	
}
