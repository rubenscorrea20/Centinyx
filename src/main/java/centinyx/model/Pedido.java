package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	public Pedido(){}

	public Pedido(int idPedido, String criacao, long codigoControle, Escalas escala, List<Alocacao> alocacao,
			PagamentoCliente pagamentoCliente) {
		super();
		this.idPedido = idPedido;
		this.criacao = criacao;
		this.codigoControle = codigoControle;
		this.escala = escala;
		this.alocacao = alocacao;
		this.pagamentoCliente = pagamentoCliente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private int idPedido;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Column(name = "codigo_controle", length = 8, nullable = false)
	private long codigoControle;

	@ManyToOne
	@JoinColumn(name = "id_escala")
	private Escalas escala;
	
	@ManyToMany(mappedBy = "pedido")
	//@JoinColumn(name = "id_alocacao")
	private List<Alocacao> alocacao;
	
	@OneToOne(optional = false, mappedBy = "pedido")
	//@JoinColumn(name = "id_pagamento_cliente")
	private PagamentoCliente pagamentoCliente;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public List<Alocacao> getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(List<Alocacao> alocacao) {
		this.alocacao = alocacao;
	}

	public Escalas getEscala() {
		return escala;
	}

	public void setEscala(Escalas id_escala) {
		this.escala = id_escala;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public long getCodigoControle() {
		return codigoControle;
	}

	public void setCodigoControle(long codigoControle) {
		this.codigoControle = codigoControle;
	}

	public PagamentoCliente getPagamentoCliente() {
		return pagamentoCliente;
	}

	public void setPagamentoCliente(PagamentoCliente pagamentoCliente) {
		this.pagamentoCliente = pagamentoCliente;
	}

}
