package com.tcc.usp.api.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "processo", schema = "sch_processos")
public class Processo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "eh_dado_sensivel")
	private boolean ehDadoSensivel;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
	// CRIAR MÉTIDO PARA INSERIR A DATA DO MOMENTO0 DA ATUALIZAÇÃO

	@Column(name = "proc_compra")
	private String proCompra;

	@Column(name = "controle")
	private String controle;

	@Column(name = "nome_org_transf")
	private String nomeOrgTransf;

	@Column(name = "id_responsavel")
	private Long responsavel;

	@Column(name = "obj_proc_compra")
	private String objProcCompra;

	@Column(name = "descricao_controle")
	private String descricaoControle;

	@Column(name = "pais_org_transf")
	private String paisOrgTransf;

	@Column(name = "dado_org_transf")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controle == null) ? 0 : controle.hashCode());
		result = prime * result + ((dadoOrgTransf == null) ? 0 : dadoOrgTransf.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((descricaoControle == null) ? 0 : descricaoControle.hashCode());
		result = prime * result + (ehDadoSensivel ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeOrgTransf == null) ? 0 : nomeOrgTransf.hashCode());
		result = prime * result + ((objProcCompra == null) ? 0 : objProcCompra.hashCode());
		result = prime * result + ((paisOrgTransf == null) ? 0 : paisOrgTransf.hashCode());
		result = prime * result + ((proCompra == null) ? 0 : proCompra.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (controle == null) {
			if (other.controle != null)
				return false;
		} else if (!controle.equals(other.controle))
			return false;
		if (dadoOrgTransf == null) {
			if (other.dadoOrgTransf != null)
				return false;
		} else if (!dadoOrgTransf.equals(other.dadoOrgTransf))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (descricaoControle == null) {
			if (other.descricaoControle != null)
				return false;
		} else if (!descricaoControle.equals(other.descricaoControle))
			return false;
		if (ehDadoSensivel != other.ehDadoSensivel)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeOrgTransf == null) {
			if (other.nomeOrgTransf != null)
				return false;
		} else if (!nomeOrgTransf.equals(other.nomeOrgTransf))
			return false;
		if (objProcCompra == null) {
			if (other.objProcCompra != null)
				return false;
		} else if (!objProcCompra.equals(other.objProcCompra))
			return false;
		if (paisOrgTransf == null) {
			if (other.paisOrgTransf != null)
				return false;
		} else if (!paisOrgTransf.equals(other.paisOrgTransf))
			return false;
		if (proCompra == null) {
			if (other.proCompra != null)
				return false;
		} else if (!proCompra.equals(other.proCompra))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		return true;
	}

}
