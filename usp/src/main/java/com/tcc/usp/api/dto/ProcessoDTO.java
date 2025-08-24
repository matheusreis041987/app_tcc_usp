package com.tcc.usp.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.usp.api.model.entity.Responsavel;

import jakarta.validation.Valid;

public class ProcessoDTO {

	private Long id;
	private String nome;
	private boolean ehDadoSensivel;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;
	private String proCompra;
	private String controle;
	private String nomeOrgTransf;
	

	private Long responsavel;

	
	
	private String objProcCompra;
	private String descricaoControle;
	private String paisOrgTransf;
	private String dadoOrgTransf;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isEhDadoSensivel() {
		return ehDadoSensivel;
	}
	public void setEhDadoSensivel(boolean ehDadoSensivel) {
		this.ehDadoSensivel = ehDadoSensivel;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getProCompra() {
		return proCompra;
	}
	public void setProCompra(String proCompra) {
		this.proCompra = proCompra;
	}
	public String getControle() {
		return controle;
	}
	public void setControle(String controle) {
		this.controle = controle;
	}
	public String getNomeOrgTransf() {
		return nomeOrgTransf;
	}
	public void setNomeOrgTransf(String nomeOrgTransf) {
		this.nomeOrgTransf = nomeOrgTransf;
	}
	
	
	
	public Long getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Long responsavel) {
		this.responsavel = responsavel;
	}
	public String getObjProcCompra() {
		return objProcCompra;
	}
	public void setObjProcCompra(String objProcCompra) {
		this.objProcCompra = objProcCompra;
	}
	public String getDescricaoControle() {
		return descricaoControle;
	}
	public void setDescricaoControle(String descricaoControle) {
		this.descricaoControle = descricaoControle;
	}
	public String getPaisOrgTransf() {
		return paisOrgTransf;
	}
	public void setPaisOrgTransf(String paisOrgTransf) {
		this.paisOrgTransf = paisOrgTransf;
	}
	public String getDadoOrgTransf() {
		return dadoOrgTransf;
	}
	public void setDadoOrgTransf(String dadoOrgTransf) {
		this.dadoOrgTransf = dadoOrgTransf;
	}
	
	
	
	
}
