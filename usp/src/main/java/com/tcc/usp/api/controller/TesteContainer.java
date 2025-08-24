package com.tcc.usp.api.controller;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/teste")
@CrossOrigin(origins = "*") 
@Tag (name = "Teste de container", description = "Endpoint para testar o funcionamento do container.")
public class TesteContainer {

	@Operation(summary = "Verificar o funcionamento do container",
            	description = "Retorna a informação do container em funcionamento.")
	@ApiResponse(responseCode = "404", description = "Aplicação parada")
	@GetMapping("/teste_container")
	public ResponseEntity<String> testarContainer(){
		
		LocalDateTime agora = LocalDateTime.now();
		String resposta = "<Container em funcionamento - classe teste - " + agora + ">";
		
		return ResponseEntity.ok(resposta);
		
	}
	
}
