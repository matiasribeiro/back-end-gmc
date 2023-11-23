package br.gmetric.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.gmetric.dto.IssueDTO;
import br.gmetric.model.Issue;
import br.gmetric.model.IssueEvents;
import br.gmetric.model.view.IssueDatasContribuinteView;
import br.gmetric.repository.RepositorioIssueEventsCustomizado;


public class RepositorioIssueEventsCustomizadoImpl implements RepositorioIssueEventsCustomizado, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MongoTemplate mongoTemplate;

	public RepositorioIssueEventsCustomizadoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	public List<IssueEvents> getTodasIssueEvents() {
		
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "id"));
		List<IssueEvents> issueEvents = mongoTemplate.find(query, IssueEvents.class);
		
		return issueEvents;
	}
	
	
	@Override
	public List<Issue> getIssueEventsPorAno(String ano) {

		ProjectionOperation convertDateOp = Aggregation.project("created_at").and(StringOperators.Substr.valueOf("dataFechamento").substring(0, 4)).as("ano")
				.andInclude("repo_name","usuario","issue");
		//GroupOperation groupOperation = Aggregation.group("dataFechamento").first(StringOperators.Substr.valueOf("dataFechamento").substring(0, 4))

		 // Aggregation aggregation=Aggregation.newAggregation(groupOperation);
		//<AggData> aggregationResults=mongoTemplate.aggregate(aggregation, "integer_test",AggData.class);
		  
		  
		//AggregationOperation project = Aggregation.project().and(DateOperators.dateOf(StringOperators.Substr("dataFechamento") ).year()).as("ano");
		AggregationOperation match = Aggregation.match(Criteria.where("ano").is(ano) );
		 
		Aggregation aggregation = Aggregation.newAggregation(convertDateOp, match);
		
		List<Issue> results = mongoTemplate.aggregate(aggregation, Issue.class, Issue.class).getMappedResults();
		 
        return results;
	}


	
	public List<IssueDTO> calcularTempoDecorrido() {
	    MatchOperation match = Aggregation.match(
	        Criteria.where("issue.created_at").exists(true).ne(null)
	            .and("issue.closed_at").exists(true).ne(null)
	    );

	    ProjectionOperation project = Aggregation.project()
	        .and("_id").as("id")
	        .and("actor.login").as("login") // Inclui o campo "actor.login" no resultado
	        .andExpression(
	            "subtract(dateFromString('$issue.closed_at'), dateFromString('$issue.created_at'))"
	        ).as("tempoDecorrido");

	    MatchOperation filterNull = Aggregation.match(
	        Criteria.where("tempoDecorrido").ne(null)
	    );

	    Aggregation aggregation = Aggregation.newAggregation(match, project, filterNull);

	    AggregationResults<IssueDTO> groupResults = mongoTemplate.aggregate(aggregation, "issueEvents", IssueDTO.class);
	    List<IssueDTO> result = groupResults.getMappedResults();

	    return result;
	}

	
	
}
