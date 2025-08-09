package com.tcc.usp.api.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.tcc.usp.api.model.entity.Processo;
import com.tcc.usp.api.model.repository.ProcessoRepository;
import com.tcc.usp.api.service.ProcessoService;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProcessoServiceImpl implements ProcessoService {
	
	private ProcessoRepository repository;
	
	public ProcessoServiceImpl (ProcessoRepository repo) {
		this.repository = repo;
	}
	
	

	@Override
	@Transactional
	public Processo salvar(Processo processoParam) {
		
		try {
			return repository.save(processoParam);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	
	}

	@Override
	@Transactional
	public Processo atualizar(Processo processoParam) {
		
		try {
			Objects.requireNonNull(processoParam.getId());
			return repository.save(processoParam);			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}

	@Override
	@Transactional
	public String deletar(Processo processoParam) {
		
		try {
			Objects.requireNonNull(processoParam.getId());
			repository.delete(processoParam);
			String msg = "Processo deletado com sucesso!";
			return msg;
		} catch (Exception e) {
			e.getMessage();
			return "Falha ao deletar";
		}

	
	}

	@Override
	@Transactional
	public List<Processo> buscar(Processo processo) {
	    Specification<Processo> specification = (root, query, criteriaBuilder) -> {
	        if (processo.getId() != null) {
	            return criteriaBuilder.equal(root.get("id"), processo.getId());
	        }

	        return criteriaBuilder.isTrue(criteriaBuilder.literal(false));

	    };

	    return repository.findAll(specification);
	}

	@Override
	@Transactional
	public Optional<Processo> consultarPorId(Long id) {
		try {
			return repository.findById(id);
		} catch (Exception e) {
			e.getMessage();
			return Optional.empty();
		}

	}



	@Override
	@Transactional
	public List<Processo> buscarAll(Processo processo) {
		
		Specification<Processo> specification = (root, query, criteriaBuilder) -> {
	        if (processo.getNome() != null) {
	            return criteriaBuilder.equal(root.get("nome"), processo.getNome());
	        } else if (processo.getControle() != null) {
	        	return criteriaBuilder.equal(root.get("controle"), processo.getControle());
	        } else if (processo.getDataCriacao() != null) {
	        	return criteriaBuilder.equal(root.get("dataCriacao"), processo.getDataCriacao());
	        } else if (processo.getDataAtualizacao() != null) {
	        	return criteriaBuilder.equal(root.get("dataAtualizacao"), processo.getDataAtualizacao());
	        } else if (processo.getObjProcCompra() != null) {
	        	return criteriaBuilder.equal(root.get("proCompra"), processo.getObjProcCompra());
	        } else if (processo.getDadoOrgTransf() != null) {
	        	return criteriaBuilder.equal(root.get("nomeOrgTransf"), processo.getDadoOrgTransf());
	        } else if (processo.getResponsavel() != null) {
	        	return criteriaBuilder.equal(root.get("responsavel"), processo.getResponsavel());
	        } else if (processo.getObjProcCompra() != null) {
	        	return criteriaBuilder.equal(root.get("objProcCompra"), processo.getObjProcCompra());
	        } else if (processo.getDescricaoControle() != null) {
	        	return criteriaBuilder.equal(root.get("descricaoControle"), processo.getDescricaoControle());
	        } else if (processo.getPaisOrgTransf() != null) {
	        	return criteriaBuilder.equal(root.get("paisOrgTransf"), processo.getPaisOrgTransf());
	        } else if (processo.getDadoOrgTransf() != null) {
	        	return criteriaBuilder.equal(root.get("dadoOrgTransf"), processo.getDadoOrgTransf());
	        } else if (processo.getId() != null) {
	        	return criteriaBuilder.equal(root.get("id"), processo.getId());
	        }

	        return criteriaBuilder.isTrue(criteriaBuilder.literal(false));

	    };

	    return repository.findAll(specification);

	}

}
