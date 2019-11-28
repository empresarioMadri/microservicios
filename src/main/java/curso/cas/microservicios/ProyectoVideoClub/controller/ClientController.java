package curso.cas.microservicios.ProyectoVideoClub.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;
import curso.cas.microservicios.ProyectoVideoClub.repositories.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@PostMapping(path = "/insertar")
	public @ResponseBody String insertarCliente(@RequestParam Map<String,String> parametros) {

		Cliente cliente = new Cliente();
		cliente.setName(parametros.get("nombre"));
		cliente.setEmail(parametros.get("email"));
		cliente.setTelephone(parametros.get("telephone"));

		clientRepository.save(cliente);

		return "Todo perfecto";

	}

	@GetMapping(path = "/todos")
	public @ResponseBody Iterable<Cliente> recogerTodosClientes() {
		return clientRepository.findAll();
	}

}
