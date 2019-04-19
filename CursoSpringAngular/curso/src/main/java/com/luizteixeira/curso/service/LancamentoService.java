package com.luizteixeira.curso.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizteixeira.curso.model.Lancamento;
import com.luizteixeira.curso.repository.LancamentoRepository;

@Service
public class LancamentoService{

	@Autowired
	private LancamentoRepository repository;
	
	public Lancamento salvar(Lancamento lancamento) throws Exception{
		if(lancamento == null) {
			throw new Exception("Parametros Invalidos");
		}
		
		if(lancamento.getDescricao() == null) {
			throw new Exception("Descrição Invalida");
		}
		
		if(lancamento.getData() == null) {
			throw new Exception("Data Invalida");
		}
		
		if(lancamento.getTipo() == null) {
			throw new Exception("Tipo Invalido");
		}
		
		if(lancamento.getValor() == null||
				lancamento.getValor().compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("Valor Invalido");
		}
		
		return repository.save(lancamento);
		
	}
	
	public List<Lancamento> listar() {
		return repository.findAll();
	}
	
	public Lancamento listar(Integer id) {
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
