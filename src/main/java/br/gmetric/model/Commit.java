package br.gmetric.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "commits")
public class Commit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Field(name="_id")
	private String id;
	
	@Field(name="comments_url")
	private String comentariosURL;
	
	@Field(name="repo_name")
	private String nomeRepositorio;
	
	@Field(name="stats")
	private Stat stats;
	
	@Field(name="url")
	private String url;
	
	@Field(name="files")
	private List<Arquivo> arquivos;
	
	@Field(name="commit")
	private SubCommit subCommit;


}
