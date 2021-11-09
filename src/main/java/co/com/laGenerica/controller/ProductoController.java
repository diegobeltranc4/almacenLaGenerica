package co.com.laGenerica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import co.com.laGenerica.dao.ProductoDao;
import co.com.laGenerica.model.Producto;

@CrossOrigin
@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoDao productoDao;
	
	@GetMapping("")
	List<Producto> getProductos(){
		return productoDao.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoDao.save(producto);
	}
	
	@PutMapping("{codigo}")
	public Producto actualizarProducto(@PathVariable int codigo, @RequestBody Producto producto) {
		Producto productoBase = productoDao
				.findById(codigo)
				.orElseThrow(RuntimeException::new);
		
		productoBase.setNit_proveedor(producto.getNit_proveedor());
		productoBase.setPrecio_compra(producto.getPrecio_compra());
		productoBase.setPrecio_venta(producto.getPrecio_venta());
		productoBase.setIva(producto.getIva());
		
		return productoDao.save(productoBase);		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@DeleteMapping("{codigo}")
	public void borrarProducto(@PathVariable int codigo) {
		Producto producto = productoDao
				.findById(codigo)
				.orElseThrow(RuntimeException::new);
		productoDao.delete(producto);
	}
	
	@GetMapping("{codigo}")
	public Producto buscarPorCodigo(@PathVariable int codigo) {
		return productoDao.findById(codigo).get();
	}
	
}
