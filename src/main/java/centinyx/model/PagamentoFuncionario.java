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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centinyx.enums.TipoPagamento;

@Entity
@Table(name = "pagamento_motoboy")
public class PagamentoFuncionario {
	
	public PagamentoFuncionario(){}

	public PagamentoFuncionario(int idPagamentoFuncionario, String criacao, long codigoControle, String statusPagamento,
			String pagamentoConfirmado, Date dataPagamento, float valorPago, Despesa despesas,
			TipoPagamento tipoPagamento, Holerite holerite, Funcionario funcionario) {
		super();
		this.idPagamentoFuncionario = idPagamentoFuncionario;
		this.criacao = criacao;
		this.codigoControle = codigoControle;
		this.statusPagamento = statusPagamento;
		this.pagamentoConfirmado = pagamentoConfirmado;
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
		this.despesas = despesas;
		this.tipoPagamento = tipoPagamento;
		this.holerite = holerite;
		this.funcionario = funcionario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento_funcionario")
	private int idPagamentoFuncionario;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Column(name = "codigo_controle", length = 8, nullable = false)
	private long codigoControle;

	@Column(name = "status_pagamento", length = 10, nullable = false)
	private String statusPagamento;

	@Column(name = "pagamento_confirmado", length = 3)
	private String pagamentoConfirmado;

	@Column(name = "data_pagamento", length = 8)
	private Date dataPagamento;

	@Column(name = "valor_pago", length = 5)
	private float valorPago;
	
	@OneToOne(mappedBy = "pagamentoFuncionario")
	@JoinColumn(name = "id_despesas")
	private Despesa despesas;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagamento")
	private TipoPagamento tipoPagamento;
	
	@OneToOne(mappedBy = "pagamentoFuncionario")
	//@JoinColumn(name = "id_holerite")
	private Holerite holerite;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
	public int getIdPagamentoFuncionario() {
		return idPagamentoFuncionario;
	}

	public void setIdPagamentoFuncionario(int idPagamentoFuncionario) {
		this.idPagamentoFuncionario = idPagamentoFuncionario;
	}

	public Holerite getHolerite() {
		return holerite;
	}

	public void setHolerite(Holerite holerite) {
		this.holerite = holerite;
	}

	public long getCodigoControle() {
		return codigoControle;
	}

	public void setCodigoControle(long codigoControle) {
		this.codigoControle = codigoControle;
	}

	public Despesa getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesa despesas) {
		this.despesas = despesas;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
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

	public void setPagamentoConfirmado(String pagamento_confirmado) {
		this.pagamentoConfirmado = pagamento_confirmado;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

}
