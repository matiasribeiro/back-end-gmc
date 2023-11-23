package br.gmetric.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "stats")
public class Status {
	
	@Field(name="commits")
	private Integer commits;
	
	@Field(name="contributors")
	private Integer contribuintes;
	
	@Field(name="issue_events")
	private Integer eventosIssue;
	
	@Field(name="issues")
	private Integer issue;
	
	@Field(name="repo_name")
	private String nomeRepositorio;

}
