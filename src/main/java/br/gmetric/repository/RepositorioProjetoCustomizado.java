package br.gmetric.repository;

import java.util.List;

import br.gmetric.model.Projeto;
import br.gmetric.model.view.ProjetoView;

public interface RepositorioProjetoCustomizado {
	
	public List<ProjetoView> getTodos();

}
