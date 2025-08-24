package com.tcc.usp.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.apache.bcel.classfile.Module.Require;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.usp.api.dto.ProcessoDTO;
import com.tcc.usp.api.dto.ResponsavelDTO;
import com.tcc.usp.api.exception.RegraNegocioException;
import com.tcc.usp.api.model.entity.Processo;
import com.tcc.usp.api.model.entity.Responsavel;
import com.tcc.usp.api.model.repository.ResponsavelRepository;
import com.tcc.usp.api.service.ProcessoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/processo")
@CrossOrigin(origins = "*") 
@Tag (name = "Processo", description = "Endpoint para tratamento das informações dos Processos.")
public class ProcessoController {
	
	ProcessoService service;
	
	public ProcessoController(ProcessoService service) {
		this.service = service;
	}
	
	
	private Processo converter(ProcessoDTO dto) {
		
		  
		  
		
		Processo  processo = new Processo (); 
			processo.setControle(dto.getControle());
			processo.setDadoOrgTransf(dto.getDadoOrgTransf());
			processo.setDataAtualizacao(dto.getDataAtualizacao());
			processo.setDataCriacao(dto.getDataCriacao());
			processo.setDescricaoControle(dto.getDescricaoControle());
			processo.setEhDadoSensivel(dto.isEhDadoSensivel());
			processo.setNome(dto.getNome());
			processo.setNomeOrgTransf(dto.getNomeOrgTransf());
			processo.setProCompra(dto.getProCompra());
			processo.setPaisOrgTransf(dto.getPaisOrgTransf());
			
			processo.setResponsavel(dto.getResponsavel());
	
			
			processo.setObjProcCompra(dto.getObjProcCompra());
			if(dto.getId() != null) {
				processo.setId(dto.getId());
			}
			
		return processo;

	}
	
	
	
	@Operation(summary = "Salvar Processos", description = "Salva no sistema os processos")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
	@ApiResponse(responseCode = "400", description = "Problema na requisição")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
   	@PostMapping("/salvar-processo")
	public ResponseEntity salvar (@RequestBody @Valid ProcessoDTO dto) {
		
			try {
				Processo entidadeProcesso = converter(dto);
				entidadeProcesso = service.salvar(entidadeProcesso);
				return ResponseEntity.ok(entidadeProcesso);
				
			} catch (RegraNegocioException regraNegocioException) {
				return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
			}
	}
	
	
	@Operation(summary = "Deletar Processos", description = "Deletar um processo do sistema")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
	@ApiResponse(responseCode = "400", description = "Problema na requisição")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	@DeleteMapping("/deletar-processo/{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		
		return service.consultarPorId(id).map(entity -> {
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> ResponseEntity.badRequest().body(
				"O id do processo informado não foi encontrado na base de dados, por isso não pode ser excluído."));
	}
	
	
	
	@Operation(summary = "Buscar Processos por ID", description = "Buscar um ou mais processos no sistema pelo ID do processo")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
	@ApiResponse(responseCode = "400", description = "Problema na requisição")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	@GetMapping("/buscar-processo-id")
	public ResponseEntity buscar (
			@RequestParam(value = "id", required = false) Long id
			) {

	    System.out.println("ID recebido na requisição: " + id);
	    
	    Processo processoFiltro = new Processo();
	    processoFiltro.setId(id);

	    
	    // Adicione um log para ver o objeto de filtro
	    System.out.println("Objeto de filtro criado: " + processoFiltro);
	    
	    List<Processo> processos = service.buscar(processoFiltro);
	    return ResponseEntity.ok(processos);
	}
	
	@Operation(summary = "Buscar Processos", description = "Buscar um ou mais processos no sistema")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
	@ApiResponse(responseCode = "400", description = "Problema na requisição")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	@GetMapping("/buscar-processos")
	public ResponseEntity buscarTudo(
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "controle", required = false) String controle,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "dataCriacao", required = false) LocalDate dataCriacao,
			@RequestParam(value = "dataAtualizacao", required = false) LocalDate dataAtualizacao,
			@RequestParam(value = "nomeOrgTransf", required = false) String nomeOrgTransf,
			@RequestParam(value = "responsavel", required = false) Long responsavel,
			@RequestParam(value = "descricaoControle", required = false) String descricaoControle,
			@RequestParam(value = "paisOrgTransf", required = false) String paisOrgTransf,
			@RequestParam(value = "dadoOrgTransf", required = false) String dadoOrgTransf
			
			){
		
		Processo processoFiltro = new Processo();
		processoFiltro.setNome(nome);
		processoFiltro.setControle(controle);
		processoFiltro.setId(id);
		processoFiltro.setDadoOrgTransf(dadoOrgTransf);
		processoFiltro.setDataAtualizacao(dataAtualizacao);
		processoFiltro.setDataAtualizacao(dataAtualizacao);
		processoFiltro.setDataCriacao(dataCriacao);
		processoFiltro.setDescricaoControle(descricaoControle);
		processoFiltro.setNomeOrgTransf(nomeOrgTransf);
		processoFiltro.setPaisOrgTransf(paisOrgTransf);
		processoFiltro.setResponsavel(responsavel);
		
		List<Processo> processos = service.buscarAll(processoFiltro);
		return ResponseEntity.ok(processos);
		
	}
	 
	
	@Operation(summary = "Atualizar Processo", description = "Atualizar as informações de processo do sistema")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida")
	@ApiResponse(responseCode = "400", description = "Problema na requisição")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	@PutMapping("/atualizar-processo/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ProcessoDTO dto) {
		
		return service.consultarPorId(id).map(entity -> {
			try {
				Processo processo = converter(dto);
				processo.setId(entity.getId());
				service.atualizar(processo);
				return ResponseEntity.ok(processo);
			} catch (RegraNegocioException regraNegocioException) {
				return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
			}
		}).orElseGet(() -> ResponseEntity.badRequest()
				.body( "O id do processo informado não foi encontrado na base."));
		
	}
	
	

}
