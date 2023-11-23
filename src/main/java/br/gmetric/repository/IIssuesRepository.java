package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gmetric.model.Issue;

@Repository
public interface IIssuesRepository extends MongoRepository<Issue, Long>, RepositorioIssuesCustomizado {

}
