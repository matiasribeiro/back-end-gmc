package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gmetric.model.Commit;

@Repository
public interface ICommitRepository extends MongoRepository<Commit,String>, RepositorioCommitCustomizado {
	
	

}
