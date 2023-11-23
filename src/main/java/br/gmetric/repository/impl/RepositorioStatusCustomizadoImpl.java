package br.gmetric.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import br.gmetric.model.Status;
import br.gmetric.repository.RepositorioStatusCustomizado;

public class RepositorioStatusCustomizadoImpl implements RepositorioStatusCustomizado, Serializable {


	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MongoTemplate mongoTemplate;
	
	

	public RepositorioStatusCustomizadoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}




	@Override
	public List<Status> getTodos() {
		
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "id"));
		List<Status> status = mongoTemplate.find(query, Status.class);
		
		return status;
	}

	
	
	
	
}
