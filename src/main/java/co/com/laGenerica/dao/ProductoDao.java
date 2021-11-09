package co.com.laGenerica.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.laGenerica.model.Producto;

public interface ProductoDao extends MongoRepository<Producto, Integer>{

}
