package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	public Pedido() {
	}

	public Pedido(int idPedido, String criacao, Cliente cliente, List<Alocacao> alocacao,
			PagamentoCliente pagamentoCliente, int numeroPedido) {
		super();
		this.idPedido = idPedido;
		this.criacao = criacao;
		this.cliente = cliente;
		this.alocacao = alocacao;
		this.pagamentoCliente = pagamentoCliente;
		this.numeroPedido = numeroPedido;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private int idPedido;

	@Column(name = "data_criacao", length = 20)
	private String criacao;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido")
	private List<Alocacao> alocacao;

	@OneToOne(optional = false, mappedBy = "pedido")
	//@JoinColumn(name = "id_pagamento_cliente")
	private PagamentoCliente pagamentoCliente;
	
	@Column(name = "numero_pedido")
	private int numeroPedido;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}
	
	public List<Alocacao> getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(List<Alocacao> alocacao) {
		this.alocacao = alocacao;
	}

	public PagamentoCliente getPagamentoCliente() {
		return pagamentoCliente;
	}

	public void setPagamentoCliente(PagamentoCliente pagamentoCliente) {
		this.pagamentoCliente = pagamentoCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

}
