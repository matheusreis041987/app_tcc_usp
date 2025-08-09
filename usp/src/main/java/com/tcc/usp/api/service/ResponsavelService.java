package com.tcc.usp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcc.usp.api.model.entity.Responsavel;


public interface ResponsavelService {

	//CRUD
	
	Responsavel salvar (Responsavel respParam);
	
	Responsavel atualizar (Responsavel respParam);
	
	void deletar (Responsavel respParam);
	
	List<Responsavel> buscar(Responsavel responsavel);
	
	
	Optional<Responsavel> consultarPorId (Long id);
	
}
