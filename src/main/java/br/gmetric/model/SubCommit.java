package br.gmetric.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubCommit {

	@Field(name="author")
	private Autor autor;
	
	@Field(name="committer")
	private Committer committer;
	
}
