package br.gmetric.model.view;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueView {
	

	
	private Long quantidade;
	
	private int mesFechamento;
	
	private String nomeRepositorio;
	
	public IssueView() {}


	public IssueView(Long quantidade, int mesFechamento, String nomeRepositorio) {
		this.quantidade = quantidade;
		this.mesFechamento = mesFechamento;
		this.nomeRepositorio = nomeRepositorio;
	}


	public IssueView(String nomeRepositorio) {
		this.nomeRepositorio = nomeRepositorio;
	}


	public IssueView(String nomeRepositorio, Long quantidade, int mesFechamento ) {
		this.nomeRepositorio = nomeRepositorio;
		this.quantidade = quantidade;
		this.mesFechamento = mesFechamento;
	}

	public IssueView(String nomeRepositorio , Long quantidade) {
		this.nomeRepositorio = nomeRepositorio;
		this.quantidade = quantidade;
	}
















	


}
