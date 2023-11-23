package br.gmetric.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "issueEvents")
public class IssueEvents implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field(name="_id")
	private Long id;
	
	@Field(name="created_at")
	private String dataFechamento;
	
	@Field(name="repo_name")
	private String nomeRepositorio;
	
	@Field(name="url")
	private String url;
	
	@Field(name="actor")
	private Usuario2 usuario;
	
	@Field(name="issue")
	private Issue issue;
	
	public IssueEvents () {}

	public IssueEvents(String nomeRepositorio) {
		this.nomeRepositorio = nomeRepositorio;
	}


	
	
}
