package br.gmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.*;

import br.gmetric.model.Projeto;
import br.gmetric.model.view.ProjetoView;
import br.gmetric.repository.IProjetoRepository;

@RestController
@RequestMapping(value = "/projetos")
@CrossOrigin(origins = "*")
public class ProjetoController {

	@Autowired
	private IProjetoRepository repositorioProjeto;
	
	
	
	@GetMapping()
	public List<Projeto> listarTodos(){
		
		List<Projeto> projetos = repositorioProjeto.findAll();
		
		return projetos;
		
	}
	
	
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<?> teste(String adicionarRepositorio){
		
		
		String token = "";
		String repositorio = "";
		
		
		URI uriTeste = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/github").path("adicionar").build().toUri();
		
		
		
		
				
		return ResponseEntity.created(null).build();
		
	}
	
	
}
