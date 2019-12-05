package curso.cas.microservicios.ProyectoVideoClub.beans;

import java.util.List;

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
public class DireccionResponse {

	private Integer id;

	private String calle;

	private String codigoPostal;

}
