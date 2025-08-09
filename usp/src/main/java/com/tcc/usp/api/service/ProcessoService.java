package com.tcc.usp.api.service;

import com.tcc.usp.api.model.entity.Processo;

import java.util.List;
import java.util.Optional;

public interface ProcessoService {

	//CRUD
	
	Processo salvar(Processo processoParam);
	
	Processo atualizar(Processo processoParam);
	
	String deletar (Processo processoParam);
	
	List<Processo> buscar(Processo processo);
	
	List<Processo> buscarAll(Processo processo);
	
	Optional<Processo> consultarPorId(Long id);
}
