package com.tcc.usp.api.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tcc.usp.api.model.entity.Responsavel;
import com.tcc.usp.api.model.repository.ResponsavelRepository;
import com.tcc.usp.api.service.ResponsavelService;

import jakarta.transaction.Transactional;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {
	
	private ResponsavelRepository repository;
	
	
	public ResponsavelServiceImpl (ResponsavelRepository repo) {
		this.repository = repo;
	}
	
	

	@Override
	@Transactional
	public Responsavel salvar(Responsavel respParam) {
		//Objects.requireNonNull(respParam); // verificar se funciona
		return repository.save(respParam);
	}

	@Override
	@Transactional
	public Responsavel atualizar(Responsavel respParam) {
		Objects.requireNonNull(respParam.getId());
		return repository.save(respParam);
	}

	@Override
	@Transactional
	public void deletar(Responsavel respParam) {
		Objects.requireNonNull(respParam.getId());
		repository.delete(respParam);
		
		//Verificar para retornar uma resposta de retorno
		
	}

	@Override
	@Transactional
	public List<Responsavel> buscar(Responsavel responsavel) {
		Example example = Example.of(responsavel);
		return repository.findAll(example);
	}

	@Override
	@Transactional
	public Optional<Responsavel> consultarPorId(Long id) {
		
		return repository.findById(id);
	}
	
	
	
	
	


}
