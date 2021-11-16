package co.com.laGenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Usuario {
	
	@Id
	private int cedula;
	private String email;
	private String nombre;
	private String password;
	private String usuario;
	
	//prueba github
}
