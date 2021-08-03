package com.aponte.APonte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aponte.APonte.model.Tema;
import com.aponte.APonte.repository.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin ("*")
public class TemaController {

	@Autowired 
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll() {
        return ResponseEntity.ok(repository.findAll());

    }
	
	
	
}
