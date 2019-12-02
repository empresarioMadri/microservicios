package curso.cas.microservicios.ProyectoVideoClub.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;
import curso.cas.microservicios.ProyectoVideoClub.errores.ClientNotfoundException;
import curso.cas.microservicios.ProyectoVideoClub.repositories.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String ficheroUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if (file.getOriginalFilename().toLowerCase().endsWith(".png")) {
			File fichero = new File("c:/tmp/" + file.getOriginalFilename());
			fichero.createNewFile();
			FileOutputStream fout = new FileOutputStream(fichero);
			fout.write(file.getBytes());
			fout.close();
			return "Todo ha ido perfecto";
		} else {
			return "fichero no permitido";
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> descargaFichero() throws IOException {
		String ruta = "c:/tmp/imagen.jpg";
		File file = new File(ruta);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("image/jpg")).body(resource);

		return responseEntity;
	}

	@PostMapping(path = "/insertar/{nombre}/{telefono}")
	public @ResponseBody String insertarCliente(@PathVariable String nombre, @RequestParam String email,
			@PathVariable String telefono) throws ClientNotfoundException {

		if(nombre.equals("David")) {
			throw new ClientNotfoundException();
		}
		Cliente cliente = new Cliente();
		cliente.setName(nombre);
		cliente.setEmail(email);
		cliente.setTelephone(telefono);

		clientRepository.save(cliente);

		return "Todo perfecto";

	}

	@GetMapping(path = "/todos")
	public @ResponseBody Iterable<Cliente> recogerTodosClientes() {
		return clientRepository.findAll();
	}

}
