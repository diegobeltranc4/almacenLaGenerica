package co.com.laGenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cliente {
	
	@Id
	private int cedula;
	private String nombre;
	private String direccion;
	private int telefono;
	private String email;
}
