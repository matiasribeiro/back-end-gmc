package br.gmetric.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.gmetric.model.Categoria;
import br.gmetric.model.Grupo;

public interface IGrupoRepository extends MongoRepository<Grupo, String>{
	
	Optional<Grupo> findByCategoria(Categoria categoria);

}
