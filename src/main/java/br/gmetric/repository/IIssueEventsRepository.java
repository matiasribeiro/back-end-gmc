package br.gmetric.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gmetric.model.IssueEvents;

@Repository
public interface IIssueEventsRepository extends MongoRepository<IssueEvents, Long>, RepositorioIssueEventsCustomizado {

}
