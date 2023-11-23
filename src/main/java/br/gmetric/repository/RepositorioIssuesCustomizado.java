package br.gmetric.repository;

import java.util.List;

import br.gmetric.model.view.IssueDatasContribuinteView;
import br.gmetric.model.view.IssueQuantidadeUsuario;

public interface RepositorioIssuesCustomizado {
	
	public List<IssueQuantidadeUsuario> getQuantidadeIssuePorContribuinte();
	
	public List<IssueDatasContribuinteView> getDatasIssuePorContribuinte(Long id);

}
