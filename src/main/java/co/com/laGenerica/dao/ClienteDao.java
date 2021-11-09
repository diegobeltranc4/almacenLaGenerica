package co.com.laGenerica.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.laGenerica.model.Cliente;

public interface ClienteDao extends MongoRepository<Cliente, Integer>{

}
