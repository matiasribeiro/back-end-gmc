package br.gmetric.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueQuantidadeUsuario {
	
	private GrupoIdIssueView id;
	
	private Integer quantidade;
	
	private String dataAbertura;
	
	private String dataFechamento;

}
