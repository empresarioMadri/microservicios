package curso.cas.microservicios.ProyectoVideoClub.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import curso.cas.microservicios.ProyectoVideoClub.repositories.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value="/upload", method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String ficheroUpload(@RequestParam("file") MultipartFile file) throws IOException{
		File fichero = new File("c:/tmp/" + file.getOriginalFilename());
		fichero.createNewFile();
		FileOutputStream fout = new FileOutputStream(fichero);
		fout.write(file.getBytes());
		fout.close();
		return "Todo ha ido perfecto";
	}

	@PostMapping(path = "/insertar/{nombre}/{telefono}")
	public @ResponseBody String insertarCliente(@PathVariable String nombre, @RequestParam String email,
			@PathVariable String telefono) {

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
