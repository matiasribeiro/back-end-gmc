package br.gmetric.model.view;

import br.gmetric.model.Usuario2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueDatasContribuinteView {
	
	private Long id;

	private String timestampAbertura;
	
	private String timestampFechamento;

	private String repositorio;
	
	private Usuario2 usuario;

	private TempoDeIssueView tempoDeIssue;
	
}
