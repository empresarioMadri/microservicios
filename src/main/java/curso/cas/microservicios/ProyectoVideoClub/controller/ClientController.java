package curso.cas.microservicios.ProyectoVideoClub.controller;

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
	public @ResponseBody String insertarCliente(@RequestParam(defaultValue = "David") String nombre, @RequestParam String email,
			@RequestParam(required = false) String telephone) {

		Cliente cliente = new Cliente();
		cliente.setName(nombre);
		cliente.setEmail(email);
		cliente.setTelephone(telephone);

		clientRepository.save(cliente);

		return "Todo perfecto";

	}

	@GetMapping(path = "/todos")
	public @ResponseBody Iterable<Cliente> recogerTodosClientes() {
		return clientRepository.findAll();
	}

}
