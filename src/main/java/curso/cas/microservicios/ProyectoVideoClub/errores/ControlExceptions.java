package curso.cas.microservicios.ProyectoVideoClub.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlExceptions {
	
	@ExceptionHandler(value = ClientNotfoundException.class)
	public ResponseEntity<Object> exception(ClientNotfoundException e){
		return new ResponseEntity<Object>("Cliente no encontrado",HttpStatus.NOT_FOUND);
	}

}
