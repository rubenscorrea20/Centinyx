package centinyx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="despesa")
public class Despesa {
	
	public Despesa(){}

	public Despesa(int idDespesa, String criacao, String tipoDespesa, String descricao,
			PagamentoFuncionario pagamentoFuncionario) {
		super();
		this.idDespesa = idDespesa;
		this.criacao = criacao;
		this.tipoDespesa = tipoDespesa;
		this.descricao = descricao;
		this.pagamentoFuncionario = pagamentoFuncionario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa")
	private int idDespesa;
	
	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Column(name = "tipo_despesa", length = 50, nullable = false)
	private String tipoDespesa;
	
	@Column(name = "descricao", length = 150)
	private String descricao;

	@OneToOne
	@JoinColumn(name = "id_pagamento_funcionario")
	private PagamentoFuncionario pagamentoFuncionario;

	public int getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipo_despesa) {
		this.tipoDespesa = tipo_despesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public PagamentoFuncionario getPagamentoFuncionario() {
		return pagamentoFuncionario;
	}

	public void setPagamentoFuncionario(PagamentoFuncionario pagamentoFuncionario) {
		this.pagamentoFuncionario = pagamentoFuncionario;
	}

}
