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

import co.com.laGenerica.dao.UsuarioDao;
import co.com.laGenerica.model.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("")
	List<Usuario> getUsuarios(){
		return usuarioDao.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioDao.save(usuario);
	}
	
	@PutMapping("{id}")
	public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
		Usuario usuarioBase = usuarioDao
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		usuarioBase.setEmail(usuario.getEmail());
		usuarioBase.setPassword(usuario.getPassword());
		
		return usuarioDao.save(usuarioBase);		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@DeleteMapping("{id}")
	public void borrarUsuario(@PathVariable int id) {
		Usuario usuario = usuarioDao
				.findById(id)
				.orElseThrow(RuntimeException::new);
		usuarioDao.delete(usuario);
	}
	
	@GetMapping("{id}")
	public Usuario buscarPorId(@PathVariable int id) {
		return usuarioDao.findById(id).get();
	}
	
	}
