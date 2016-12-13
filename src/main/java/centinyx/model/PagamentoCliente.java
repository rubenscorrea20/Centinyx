package centinyx.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centinyx.enums.TipoPagamento;

@Entity
@Table(name = "pagamento_cliente")
public class PagamentoCliente {
	
	public PagamentoCliente(){}

	public PagamentoCliente(int idPagamentoCliente, String criacao, long codigoControle, String statusPagamento,
			String formaPagamento, String pagamentoConfirmado, Date dataPagamento, float valorPago, float valorTotal,
			String observacao, TipoPagamento tipoPagamento, Pedido pedido) {
		super();
		this.idPagamentoCliente = idPagamentoCliente;
		this.criacao = criacao;
		this.codigoControle = codigoControle;
		this.statusPagamento = statusPagamento;
		this.formaPagamento = formaPagamento;
		this.pagamentoConfirmado = pagamentoConfirmado;
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
		this.tipoPagamento = tipoPagamento;
		this.pedido = pedido;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento_cliente")
	private int idPagamentoCliente;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Column(name = "codigo_controle", length = 8, nullable = false)
	private long codigoControle;

	@Column(name = "status_pagamento", length = 10, nullable = false)
	private String statusPagamento;

	@Column(name = "forma_pagamento", length = 50)
	private String formaPagamento;

	@Column(name = "pagamento_confirmado", length = 3)
	private String pagamentoConfirmado;

	@Column(name = "data_pagamento", length = 8)
	private Date dataPagamento;

	@Column(name = "valor_pago", length = 5)
	private float valorPago;

	@Column(name = "valor_total", length = 5)
	private float valorTotal;

	@Column(name = "observacao", length = 200)
	private String observacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagamento")
	private TipoPagamento tipoPagamento;

	@OneToOne(optional = false)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public int getIdPagamentoCliente() {
		return idPagamentoCliente;
	}

	public void setIdPagamentoCliente(int idPagamentoCliente) {
		this.idPagamentoCliente = idPagamentoCliente;
	}

	public long getCodigoControle() {
		return codigoControle;
	}

	public void setCodigoControle(long codigoControle) {
		this.codigoControle = codigoControle;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getPagamentoConfirmado() {
		return pagamentoConfirmado;
	}

	public void setPagamentoConfirmado(String pagamentoConfirmado) {
		this.pagamentoConfirmado = pagamentoConfirmado;
	}

}
