package curso.cas.microservicios.ProyectoVideoClub.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.cas.microservicios.ProyectoVideoClub.beans.ClienteResponse;
import curso.cas.microservicios.ProyectoVideoClub.entities.Cliente;
import curso.cas.microservicios.ProyectoVideoClub.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<ClienteResponse> findByNameOrEmail(String name,String email){
		List<ClienteResponse> retorno = new ArrayList<ClienteResponse>();
		List<Cliente> clientes = clientRepository.findByNameOrEmail(name, email);
		for (Cliente cliente : clientes) {
			ModelMapper modelMapper = new ModelMapper();
			ClienteResponse clienteR = modelMapper.map(cliente,ClienteResponse.class);
			retorno.add(clienteR);
		}
		return retorno;
		
	}

}
