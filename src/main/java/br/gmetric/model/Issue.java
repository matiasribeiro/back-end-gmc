package br.gmetric.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "issues")
public class Issue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Field(name="id")
	private Long id;
	
	@Field(name="title")
	private String titulo;
	
	@Field(name="repo_name")
	private String nomeRepositorio;
	
	@Field(name="body")
	private String comentario;
	
	@Field(name="created_at")
	private String dataAbertura;
	
	@Field(name="closed_at")
	private String dataFechamento;
	
	@Field(name="user")
	private Usuario2 usuario;

	public Issue () {}

	public Issue(String nomeRepositorio) {
		this.nomeRepositorio = nomeRepositorio;
	}

}
