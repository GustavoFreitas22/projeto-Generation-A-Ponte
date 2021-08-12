package com.aponte.APonte.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aponte.APonte.model.Tema;
import com.aponte.APonte.repository.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin(value = "*", allowedHeaders = "*" )
public class TemaController {

	@Autowired 
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }
	
	@PostMapping
    public ResponseEntity<Tema> post(@RequestBody Tema tema ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }
	
	@PutMapping
    public ResponseEntity<Tema> put(@RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id){
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByDesc(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
}
