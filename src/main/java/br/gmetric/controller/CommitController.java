package br.gmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gmetric.model.Commit;
import br.gmetric.model.view.CommitView;
import br.gmetric.model.view.QuantidadeCommitAnoView;
import br.gmetric.model.view.QuantidadeCommitMesAnoView;
import br.gmetric.model.view.QuantidadeCommitMesView;
import br.gmetric.repository.ICommitRepository;
import br.gmetric.repository.RepositorioCommitCustomizado;
import br.gmetric.repository.impl.RepositorioCommitCustomizadoImpl;
import br.gmetric.service.CommitService;

@RestController
@RequestMapping(value = "/commits")
@CrossOrigin(origins = "*")
public class CommitController {

	@Autowired
	private CommitService commitService;
	
	@Autowired
	private ICommitRepository repositorioCommit;

	
	@GetMapping("")
	public ResponseEntity<List<Commit>> listarTodos(){
		
		List<Commit> commit = repositorioCommit.findAll();
		
		return ResponseEntity.ok(commit);
		
	}
	
	@GetMapping("/mes")
	public ResponseEntity<List<QuantidadeCommitMesView>> listarCommitMes(){
		
		List<QuantidadeCommitMesView> commit = commitService.getCommitsPorMes();
		
		return ResponseEntity.ok(commit);
	}
	
	@GetMapping("/ano")
	public ResponseEntity<List<QuantidadeCommitAnoView>> listarCommitAno(){
		
		List<QuantidadeCommitAnoView> commit = commitService.getCommitsPorAno();
		
		return ResponseEntity.ok(commit);
	}
	
	@GetMapping("/mesAno")
	public ResponseEntity<List<QuantidadeCommitMesAnoView>> listarCommitMesAno(){
		
		List<QuantidadeCommitMesAnoView> commit = commitService.getCommitsPorMesAno();
		
		return ResponseEntity.ok(commit);
	}
	
}
