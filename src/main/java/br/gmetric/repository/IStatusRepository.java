package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gmetric.model.Commit;
import br.gmetric.model.Status;

@Repository
public interface IStatusRepository extends MongoRepository<Status,String>, RepositorioStatusCustomizado {
	
	

}
