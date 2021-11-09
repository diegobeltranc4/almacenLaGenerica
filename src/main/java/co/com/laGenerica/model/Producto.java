package co.com.laGenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Producto {
	
	@Id
	private int codigo;
	private String nombre;
	private int nit_proveedor;
	private double precio_compra;
	private double iva;
	private double precio_venta;
}
