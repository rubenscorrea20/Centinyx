package centinyx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centinyx.enums.TipoPedidoEnum;

@Entity
@Table(name = "pedido")
public class Pedido {

	public Pedido() {
	}

	public Pedido(int idPedido, String criacao, Cliente cliente, Alocacao alocacao, TipoPedidoEnum tipoPedido,
			PagamentoCliente pagamentoCliente, int numeroPedido) {
		super();
		this.idPedido = idPedido;
		this.criacao = criacao;
		this.cliente = cliente;
		this.alocacao = alocacao;
		this.tipoPedido = tipoPedido;
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

	@OneToOne
	@JoinColumn(name = "id_alocacao")
	private Alocacao alocacao;
	
	@Column(nullable = false, name = "tipo_pedido")
	@Enumerated(EnumType.STRING)
	private TipoPedidoEnum tipoPedido;

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

	public Alocacao getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(Alocacao alocacao) {
		this.alocacao = alocacao;
	}

	public TipoPedidoEnum getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedidoEnum tipoPedido) {
		this.tipoPedido = tipoPedido;
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
