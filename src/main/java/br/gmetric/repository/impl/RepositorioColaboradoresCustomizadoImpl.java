package br.gmetric.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;

import br.gmetric.model.Colaboradores;
import br.gmetric.model.view.ColaboradoresView;
import br.gmetric.repository.RepositorioColaboradoresCustomizado;

public class RepositorioColaboradoresCustomizadoImpl implements RepositorioColaboradoresCustomizado, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MongoTemplate mongoTemplate;

	
	public RepositorioColaboradoresCustomizadoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	public List<ColaboradoresView> listarTodos(){
		
		Aggregation agg = newAggregation(
				project()       
				.andExpression("contributions.repo_name").as("repositorio"));
		
		AggregationResults<ColaboradoresView> groupResults = mongoTemplate.aggregate(agg, Colaboradores.class, ColaboradoresView.class);
	    List<ColaboradoresView> result = groupResults.getMappedResults();
		
		return result;
		
	}
	
//	public List<ColaboradoresView> getTodos(){
//		
//		Query query = new Query();
//		query.with(Sort.by(Sort.Direction.ASC, "id"));
//		List<ColaboradoresView> colaboradores = mongoTemplate.find(query, ColaboradoresView.class);
//		
//		return colaboradores;
//	}
	
	@Override
	public List<Object> getNomesLogin() {
		
//		Query query = new Query();
//		query.with(Sort.by(Sort.Direction.ASC, "login"));
//		List<Contribuidor> contribuintes = mongoTemplate.findDistinct(query, "login", Contribuidor.class, Contribuidor.class);
//		
//		//List<Contribuidor> listContribuintes = StreamSupport.stream(contribuintesDistinct.spliterator(), true).collect(Collectors.toList());
//	
//		return contribuintes;
		
	    Aggregation agg = Aggregation.newAggregation(
	            Aggregation.group("login"),
	            Aggregation.sort(Sort.Direction.DESC, "login")
	    );
	    return mongoTemplate.aggregate(agg, Colaboradores.class, Object.class)
	            .getMappedResults();
	    
	}
	

}
