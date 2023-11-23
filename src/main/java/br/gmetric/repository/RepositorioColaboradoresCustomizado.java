package br.gmetric.repository;

import java.util.List;

import br.gmetric.model.Colaboradores;
import br.gmetric.model.view.ColaboradoresView;
import br.gmetric.model.view.IdContribuinteVIew;

public interface RepositorioColaboradoresCustomizado {
	
	public List<ColaboradoresView> listarTodos();
	
	public List<Object> getNomesLogin();

}
