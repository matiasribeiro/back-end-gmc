package br.gmetric.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.StringOperators;
import org.springframework.data.mongodb.core.query.Criteria;

import br.gmetric.model.Issue;
import br.gmetric.model.view.IssueDatasContribuinteView;
import br.gmetric.model.view.IssueQuantidadeUsuario;
import br.gmetric.repository.RepositorioIssuesCustomizado;

public class RepositorioIssuesCustomizadoImpl implements RepositorioIssuesCustomizado, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MongoTemplate mongoTemplate;

	public RepositorioIssuesCustomizadoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	// passar o contribuinte, retornar issue, datas de abertura e fechamento 
	
	@Override
	public List<IssueDatasContribuinteView> getDatasIssuePorContribuinte(Long id){
		
		ProjectionOperation convertDateOp = Aggregation.project("created_at").and(StringOperators.Substr.valueOf("dataAbertura").substring(0, 19)).as("timestampAbertura")
				.and(StringOperators.Substr.valueOf("closed_at").substring(0, 19)).as("timestampFechamento")
				.andInclude("usuario.login","repositorio","dataAbertura","dataFechamento");
		
		AggregationOperation match = Aggregation.match(Criteria.where("usuario.id").is(id) ); 
		Aggregation agg = Aggregation.newAggregation(convertDateOp, match);
		
        AggregationResults<IssueDatasContribuinteView> groupResults = mongoTemplate.aggregate(agg, Issue.class, IssueDatasContribuinteView.class);
        List<IssueDatasContribuinteView> result = groupResults.getMappedResults();
        
        return result;
	}
	

	// quantidade de Issue para os contribuintes
	@Override
	public List<IssueQuantidadeUsuario> getQuantidadeIssuePorContribuinte(){

		Aggregation agg = newAggregation(
			group("usuario.login","repositorio").count().as("quantidade")
        );
		

        AggregationResults<IssueQuantidadeUsuario> groupResults = mongoTemplate.aggregate(agg, Issue.class, IssueQuantidadeUsuario.class);
        List<IssueQuantidadeUsuario> result = groupResults.getMappedResults();
        
        return result;
	}

}
