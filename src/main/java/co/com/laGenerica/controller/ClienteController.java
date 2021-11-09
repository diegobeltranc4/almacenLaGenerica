package co.com.laGenerica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.laGenerica.dao.ClienteDao;
import co.com.laGenerica.model.Cliente;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteDao clienteDao;
	
	@GetMapping("")
	List<Cliente> getClientes(){
		return clienteDao.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	@PutMapping("{cedula}")
	public Cliente actualizarCliente(@PathVariable int cedula, @RequestBody Cliente cliente) {
		Cliente clienteBase = clienteDao
				.findById(cedula)
				.orElseThrow(RuntimeException::new);
		
		clienteBase.setEmail(cliente.getEmail());
		clienteBase.setDireccion(cliente.getDireccion());
		clienteBase.setTelefono(cliente.getTelefono());
		
		return clienteDao.save(clienteBase);		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@DeleteMapping("{cedula}")
	public void borrarCliente(@PathVariable int cedula) {
		Cliente cliente = clienteDao
				.findById(cedula)
				.orElseThrow(RuntimeException::new);
		clienteDao.delete(cliente);
	}
	
	@GetMapping("{cedula}")
	public Cliente buscarPorCedula(@PathVariable int cedula) {
		return clienteDao.findById(cedula).get();
	}
	
}

