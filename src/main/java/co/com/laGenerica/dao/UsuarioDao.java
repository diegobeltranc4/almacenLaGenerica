package co.com.laGenerica.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.laGenerica.model.Usuario;

public interface UsuarioDao extends MongoRepository<Usuario, Integer>{

}
