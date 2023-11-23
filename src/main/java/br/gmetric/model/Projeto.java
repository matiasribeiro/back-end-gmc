package br.gmetric.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "projects")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field(name="_id")
	private int id;
	
	@Field(name="name")
	private String nome;
	
	@Field(name="visibility")
	private String visibilidade;
	
}
