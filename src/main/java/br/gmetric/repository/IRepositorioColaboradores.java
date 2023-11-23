package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gmetric.model.Colaboradores;

@Repository
public interface IRepositorioColaboradores extends MongoRepository<Colaboradores,String>, RepositorioColaboradoresCustomizado{

}
