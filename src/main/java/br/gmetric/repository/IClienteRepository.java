package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.gmetric.model.Cliente;
import br.gmetric.model.Usuario;

public interface IClienteRepository extends MongoRepository<Cliente, String> {

	 Boolean existsByEmail(String email);
	 
	 public void save(Usuario usuario);
	
}
