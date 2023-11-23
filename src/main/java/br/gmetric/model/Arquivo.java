package br.gmetric.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Arquivo {
	
	@Field(name="sha")
	private String id;
	
	@Field(name="filename")
	private String nome;
	
	@Field(name="status")
	private String status;
	
	@Field(name="additions")
	private int adicionados;
	
	@Field(name="deletions")
	private int excluidos;
	
	@Field(name="changes")
	private int mudancas;
	
	@Field(name="blob_url")
	private String blobURL;
	
	@Field(name="raw_url")
	private String ralURL;
	
	@Field(name="contents_url")
	private String contentsURL;
	
	@Field(name="patch")
	private String patch;
	
	
	
}
