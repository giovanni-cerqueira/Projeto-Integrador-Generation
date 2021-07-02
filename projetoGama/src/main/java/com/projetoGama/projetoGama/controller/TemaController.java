package com.projetoGama.projetoGama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetoGama.projetoGama.model.Tema;
import com.projetoGama.projetoGama.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	
		
	}	// teste de If else para busca de ID
	@GetMapping("idifelse/{id}")
	public ResponseEntity<Tema> getByIdIfElse(@PathVariable long id) {

		Optional<Tema> tema = TemaRepository.findById(id);
		if (postagem.isPresent()) {
			return ResponseEntity.ok(tema.get());
		}
		return ResponseEntity.notFound().build();
	}
		
		

	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Tema>> GetByTitulo(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PostMapping
	public ResponseEntity<Tema> post ( @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));	
		
	}
	
	@PutMapping
	public ResponseEntity<Tema> put ( @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));	
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
		
	}

}
