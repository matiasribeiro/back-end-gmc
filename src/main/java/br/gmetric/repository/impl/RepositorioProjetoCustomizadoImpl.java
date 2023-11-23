package br.gmetric.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import br.gmetric.model.view.ProjetoView;
import br.gmetric.repository.RepositorioProjetoCustomizado;

public class RepositorioProjetoCustomizadoImpl implements RepositorioProjetoCustomizado, Serializable {


	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MongoTemplate mongoTemplate;
	
	

	public RepositorioProjetoCustomizadoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}




	@Override
	public List<ProjetoView> getTodos() {
		
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "id"));
		List<ProjetoView> projetos = mongoTemplate.find(query, ProjetoView.class);
		
		return projetos;
	}

	
	
	
	
}
