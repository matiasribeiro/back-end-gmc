package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gmetric.model.Projeto;

@Repository
public interface IProjetoRepository extends MongoRepository<Projeto, Integer>, RepositorioProjetoCustomizado {

	
	
	
}
