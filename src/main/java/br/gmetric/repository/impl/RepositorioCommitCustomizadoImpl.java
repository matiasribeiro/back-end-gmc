package br.gmetric.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.io.Serializable;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.gmetric.model.Commit;
import br.gmetric.model.view.CommitView;
import br.gmetric.model.view.QuantidadeCommitView;
import br.gmetric.repository.RepositorioCommitCustomizado;


public class RepositorioCommitCustomizadoImpl implements RepositorioCommitCustomizado, Serializable {


	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MongoTemplate mongoTemplate;
	
	

	public RepositorioCommitCustomizadoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}




	@Override
	public List<CommitView> getTodos() {
		
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "id"));
		List<CommitView> projetos = mongoTemplate.find(query, CommitView.class);
		
		return projetos;
	}

	
	public List<QuantidadeCommitView> getQuantidadeCommit() {
		
		  Aggregation aggregation = Aggregation.newAggregation(
	                Aggregation.project()
	                        .andExpression("commit.author.email").as("email")
	                        .andExpression("repo_name").as("nomeRepositorio")
	                        .andExpression("substr(commit.committer.date, 0, 4)").as("ano"),
	                Aggregation.match(Criteria.where("ano").is("2023")),
	                Aggregation.group("nomeRepositorio", "email")
	                        .sum(ConditionalOperators.when(new Criteria("type").ne("nomeRepositorio")).then(1).otherwise(0)).as("total"),
	                Aggregation.group("nomeRepositorio")
	                        .sum("total").as("totalEmails")
	                        .sum("totalCommits").as("totalCommits")
	                        .push(new Document("email", "$_id.email").append("total", "$total")).as("emails"),
	                Aggregation.project()
	                        .andExclude("_id")
	                        .andInclude("nomeRepositorio", "totalCommits", "totalEmails"));
	                        
	                Aggregation.match(Criteria.where("totalCommits").gt(0).and("totalEmails").gt(0));

	        AggregationResults<QuantidadeCommitView> results = mongoTemplate.aggregate(aggregation, "commits", QuantidadeCommitView.class);
	        List<QuantidadeCommitView> mappedResults = results.getMappedResults();
	        
	        return mappedResults;
	}
	
	
	public List<QuantidadeCommitView> getQuantidadeCommitPorMesAno() {
		
		Aggregation agg = newAggregation(
				project()       
				.andExpression("subCommit.autor.email").as("email")
		        .andExpression("substr(subCommit.committer.data, 0, 7)").as("mesAno")
		        .andExpression("nomeRepositorio").as("nomeRepositorio"),
				group("email","mesAno","nomeRepositorio")
				.sum(ConditionalOperators.when(new Criteria("type").ne("nomeRepositorio")).then(1).otherwise(0)).as("total"));
	            
		AggregationResults<QuantidadeCommitView> groupResults = mongoTemplate.aggregate(agg, Commit.class, QuantidadeCommitView.class);
	    List<QuantidadeCommitView> result = groupResults.getMappedResults();
	        
	    return result;    
	}
	
	public List<QuantidadeCommitView> getQuantidadeCommitPorMes() {
		
		Aggregation agg = newAggregation(
				project()       
				.andExpression("subCommit.autor.email").as("email")
		        .andExpression("substr(subCommit.committer.data, 5, 2)").as("mes")
		        .andExpression("nomeRepositorio").as("nomeRepositorio"),
				group("email","mes","nomeRepositorio")
				.sum(ConditionalOperators.when(new Criteria("type").ne("nomeRepositorio")).then(1).otherwise(0)).as("total"));
	            
		AggregationResults<QuantidadeCommitView> groupResults = mongoTemplate.aggregate(agg, Commit.class, QuantidadeCommitView.class);
	    List<QuantidadeCommitView> result = groupResults.getMappedResults();
	        
	    return result;    
	}

	public List<QuantidadeCommitView> getQuantidadeCommitPorAno() {
		
		Aggregation agg = newAggregation(
				project()       
				.andExpression("subCommit.autor.email").as("email")
		        .andExpression("substr(subCommit.committer.data, 0, 4)").as("ano")
		        .andExpression("nomeRepositorio").as("nomeRepositorio"),
				group("email","ano","nomeRepositorio")
				.sum(ConditionalOperators.when(new Criteria("type").ne("nomeRepositorio")).then(1).otherwise(0)).as("total"));
	            
		AggregationResults<QuantidadeCommitView> groupResults = mongoTemplate.aggregate(agg, Commit.class, QuantidadeCommitView.class);
	    List<QuantidadeCommitView> result = groupResults.getMappedResults();
	        
	    return result;    
	}
	
	

	
	
	
}
