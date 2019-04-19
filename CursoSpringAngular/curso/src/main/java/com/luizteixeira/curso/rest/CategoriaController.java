package com.luizteixeira.curso.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizteixeira.curso.model.Categoria;
import com.luizteixeira.curso.service.CategoriaService;

@RestController
@RequestMapping("categorias")
@CrossOrigin
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Categoria categoria) {
		try {
			service.salvar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		return new ResponseEntity<>(service.listar(id), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		service.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
