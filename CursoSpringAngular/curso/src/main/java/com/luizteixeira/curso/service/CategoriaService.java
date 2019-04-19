package com.luizteixeira.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizteixeira.curso.model.Categoria;
import com.luizteixeira.curso.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria salvar(Categoria categoria) throws Exception{
		if(categoria == null) {
			throw new Exception("Parametros Invalidos");
		}
		
		if(categoria.getNome() == null || categoria.getNome().isEmpty()) {
			throw new Exception("Nome Invalido");
		}
		
		return repository.save(categoria);
		
	}
	
	public List<Categoria> listar() {
		return repository.findAll();
	}
	
	public Categoria listar(Integer id) {
		if(id == null || id <= 0) {
			return null;
		}

		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		if(id == null || id <= 0) {
			return;
		}
		
		repository.deleteById(id);
	}
}
