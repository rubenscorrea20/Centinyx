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
@Table(name="holerite")
public class Holerite {
	
	public Holerite(){}

	public Holerite(int idHolerite, String criacao, PagamentoFuncionario pagamentoFuncionario, float salario,
			float dsrHora, float periculosidade, float horaExtra50, float horaExtra100, float dsrExtra,
			float adicionalNoturno, float premio, float aluguelMoto, float aluguelCombustivel, float inss,
			int porcentagemInss, float adiantamentoSalarial, float adiantamentoPorcentagem, float custoCombustivel,
			int faltas, float descontoFaltas, float dsrSobreFaltas, float salarioBase, float salarioContribuição,
			float totalVencimento, float totalDesconto, float baseFGTS, float fGTSMes, float calculoIR, float liquido,
			float taxas, int horasTrabalhadas) {
		super();
		this.idHolerite = idHolerite;
		this.criacao = criacao;
		this.pagamentoFuncionario = pagamentoFuncionario;
		this.salario = salario;
		this.dsrHora = dsrHora;
		this.periculosidade = periculosidade;
		this.horaExtra50 = horaExtra50;
		this.horaExtra100 = horaExtra100;
		this.dsrExtra = dsrExtra;
		this.adicionalNoturno = adicionalNoturno;
		this.premio = premio;
		this.aluguelMoto = aluguelMoto;
		this.aluguelCombustivel = aluguelCombustivel;
		this.inss = inss;
		this.porcentagemInss = porcentagemInss;
		this.adiantamentoSalarial = adiantamentoSalarial;
		this.adiantamentoPorcentagem = adiantamentoPorcentagem;
		this.custoCombustivel = custoCombustivel;
		this.faltas = faltas;
		this.descontoFaltas = descontoFaltas;
		this.dsrSobreFaltas = dsrSobreFaltas;
		this.salarioBase = salarioBase;
		this.salarioContribuição = salarioContribuição;
		this.totalVencimento = totalVencimento;
		this.totalDesconto = totalDesconto;
		this.baseFGTS = baseFGTS;
		FGTSMes = fGTSMes;
		this.calculoIR = calculoIR;
		this.liquido = liquido;
		this.taxas = taxas;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_holerite")
	private int idHolerite;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@OneToOne
	@JoinColumn(name = "id_pagamento_funcionario")
	private PagamentoFuncionario pagamentoFuncionario;

	@Column(name = "salario", length = 5, nullable = false)
	private float salario;

	@Column(name = "dsr_hora", length = 5)
	private float dsrHora;

	@Column(name = "periculosidade", length = 5)
	private float periculosidade;

	@Column(name = "hora_extra_50", length = 5)
	private float horaExtra50;

	@Column(name = "hora_extra_100", length = 5)
	private float horaExtra100;

	@Column(name = "dsr_extra", length = 5)
	private float dsrExtra;

	@Column(name = "adicional_noturno", length = 5)
	private float adicionalNoturno;

	@Column(name = "premio", length = 5)
	private float premio;

	@Column(name = "aluguel_moto", length = 5)
	private float aluguelMoto;

	@Column(name = "aluguel_combustivel", length = 5)
	private float aluguelCombustivel;

	@Column(name = "inss", length = 5)
	private float inss;

	@Column(name = "porcentagem_inss", length = 5)
	private int porcentagemInss;

	@Column(name = "adiantamento_salarial", length = 5)
	private float adiantamentoSalarial;

	@Column(name = "adiantamento_porcentagem", length = 5)
	private float adiantamentoPorcentagem;

	@Column(name = "custo_combustivel", length = 5)
	private float custoCombustivel;

	@Column(name = "quantidade_faltas", length = 2)
	private int faltas;

	@Column(name = "desconto_faltas", length = 5)
	private float descontoFaltas;

	@Column(name = "dsr_sobre_faltas", length = 5)
	private float dsrSobreFaltas;

	@Column(name = "salario_base", length = 5)
	private float salarioBase;

	@Column(name = "salario_contribuição", length = 5)
	private float salarioContribuição;

	@Column(name = "total_vencimento", length = 5)
	private float totalVencimento;

	@Column(name = "total_desconto", length = 5)
	private float totalDesconto;

	@Column(name = "base_FGTS", length = 5)
	private float baseFGTS;

	@Column(name = "FGTS_mes", length = 5)
	private float FGTSMes;

	@Column(name = "calculo_IR", length = 5)
	private float calculoIR;

	@Column(name = "liquido_recebivel", length = 5)
	private float liquido;

	@Column(name = "taxas", length = 5)
	private float taxas;

	@Column(name = "horas_trabalhadas", length = 3)
	private int horasTrabalhadas;

	public int getIdHolerite() {
		return idHolerite;
	}

	public void setIdHolerite(int idHolerite) {
		this.idHolerite = idHolerite;
	}

	public PagamentoFuncionario getPagamentoFuncionario() {
		return pagamentoFuncionario;
	}

	public void setPagamentoFuncionario(PagamentoFuncionario pagamentoFuncionario) {
		this.pagamentoFuncionario = pagamentoFuncionario;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getDsrHora() {
		return dsrHora;
	}

	public void setDsrHora(float dsrHora) {
		this.dsrHora = dsrHora;
	}

	public float getPericulosidade() {
		return periculosidade;
	}

	public void setPericulosidade(float periculosidade) {
		this.periculosidade = periculosidade;
	}

	public float getHoraExtra50() {
		return horaExtra50;
	}

	public void setHoraExtra50(float horaExtra50) {
		this.horaExtra50 = horaExtra50;
	}

	public float getHoraExtra100() {
		return horaExtra100;
	}

	public void setHoraExtra100(float horaExtra100) {
		this.horaExtra100 = horaExtra100;
	}

	public float getDsrExtra() {
		return dsrExtra;
	}

	public void setDsrExtra(float dsrExtra) {
		this.dsrExtra = dsrExtra;
	}

	public float getAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(float adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}

	public float getPremio() {
		return premio;
	}

	public void setPremio(float premio) {
		this.premio = premio;
	}

	public float getAluguelMoto() {
		return aluguelMoto;
	}

	public void setAluguelMoto(float aluguelMoto) {
		this.aluguelMoto = aluguelMoto;
	}

	public float getAluguelCombustivel() {
		return aluguelCombustivel;
	}

	public void setAluguelCombustivel(float aluguelCombustivel) {
		this.aluguelCombustivel = aluguelCombustivel;
	}

	public float getInss() {
		return inss;
	}

	public void setInss(float inss) {
		this.inss = inss;
	}

	public int getPorcentagemInss() {
		return porcentagemInss;
	}

	public void setPorcentagemInss(int porcentagemInss) {
		this.porcentagemInss = porcentagemInss;
	}

	public float getAdiantamentoSalarial() {
		return adiantamentoSalarial;
	}

	public void setAdiantamentoSalarial(float adiantamentoSalarial) {
		this.adiantamentoSalarial = adiantamentoSalarial;
	}

	public float getAdiantamentoPorcentagem() {
		return adiantamentoPorcentagem;
	}

	public void setAdiantamentoPorcentagem(float adiantamentoPorcentagem) {
		this.adiantamentoPorcentagem = adiantamentoPorcentagem;
	}

	public float getCustoCombustivel() {
		return custoCombustivel;
	}

	public void setCustoCombustivel(float custoCombustivel) {
		this.custoCombustivel = custoCombustivel;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public float getDescontoFaltas() {
		return descontoFaltas;
	}

	public void setDescontoFaltas(float descontoFaltas) {
		this.descontoFaltas = descontoFaltas;
	}

	public float getDsrSobreFaltas() {
		return dsrSobreFaltas;
	}

	public void setDsrSobreFaltas(float dsrSobreFaltas) {
		this.dsrSobreFaltas = dsrSobreFaltas;
	}

	public float getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}

	public float getSalarioContribuição() {
		return salarioContribuição;
	}

	public void setSalarioContribuição(float salarioContribuição) {
		this.salarioContribuição = salarioContribuição;
	}

	public float getTotalVencimento() {
		return totalVencimento;
	}

	public void setTotalVencimento(float totalVencimento) {
		this.totalVencimento = totalVencimento;
	}

	public float getTotalDesconto() {
		return totalDesconto;
	}

	public void setTotalDesconto(float totalDesconto) {
		this.totalDesconto = totalDesconto;
	}

	public float getBaseFGTS() {
		return baseFGTS;
	}

	public void setBaseFGTS(float baseFGTS) {
		this.baseFGTS = baseFGTS;
	}

	public float getFGTSMes() {
		return FGTSMes;
	}

	public void setFGTSMes(float fGTSMes) {
		FGTSMes = fGTSMes;
	}

	public float getCalculoIR() {
		return calculoIR;
	}

	public void setCalculoIR(float calculoIR) {
		this.calculoIR = calculoIR;
	}

	public float getLiquido() {
		return liquido;
	}

	public void setLiquido(float liquido) {
		this.liquido = liquido;
	}

	public float getTaxas() {
		return taxas;
	}

	public void setTaxas(float taxas) {
		this.taxas = taxas;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

}
