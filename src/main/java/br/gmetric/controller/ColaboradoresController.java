package br.gmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gmetric.model.Colaboradores;
import br.gmetric.model.view.ColaboradoresView;
import br.gmetric.repository.IRepositorioColaboradores;

@RestController
@RequestMapping(value = "/colaboradores")
@CrossOrigin(origins = "*")
public class ColaboradoresController {

	@Autowired
	private IRepositorioColaboradores repositorioContribuintes;

	
	@GetMapping("")
	public ResponseEntity<List<ColaboradoresView>> listarTodos(){
		
		List<ColaboradoresView> colaboradores = repositorioContribuintes.listarTodos();
		
		return ResponseEntity.ok(colaboradores);
		
	}
	
}
