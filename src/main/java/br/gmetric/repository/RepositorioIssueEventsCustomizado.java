package br.gmetric.repository;

import java.util.List;

import br.gmetric.dto.IssueDTO;
import br.gmetric.model.Issue;
import br.gmetric.model.IssueEvents;
import br.gmetric.model.view.IssueQuantidadeUsuario;

public interface RepositorioIssueEventsCustomizado {

	public List<Issue> getIssueEventsPorAno(String ano);
	
	public List<IssueDTO> calcularTempoDecorrido();
	

}
