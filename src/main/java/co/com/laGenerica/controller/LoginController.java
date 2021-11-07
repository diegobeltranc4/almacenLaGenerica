package co.com.laGenerica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.com.laGenerica.dao.UsuarioDao;
import co.com.laGenerica.model.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@GetMapping("/")
	public String mostrarLogin(){
		return "login.html";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("login.html");
		return modelo;
	}
	
	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public ModelAndView getMenu() {
		String mensaje = "<h3>Error de usuario o contraseña</h3>";
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("menu.html");
		modelo.addObject(mensaje);
		return modelo;
	}
	
	@RequestMapping(value ="validador",  method = RequestMethod.GET)
	public ModelAndView getValidLogin(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelo = new ModelAndView();
		String usuario = req.getParameter("user");
		String password = req.getParameter("password");
		List<Usuario> usuarios = usuarioDao.findAll();
		
		for(Usuario auxUsuario : usuarios) { 
			if(usuario.equals(auxUsuario.getUsuario()) && password.equals(auxUsuario.getPassword())) {
				modelo.setViewName("menu");
			}else {
				modelo.setViewName("login");
			}
		}
		return modelo;
	}
	//prueba git 2
}
