package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import centinyx.enums.TipoPeriodoEnum;

@Entity
@Table(name = "periodo_alocacao")
public class PeriodoAlocacao {

	public PeriodoAlocacao() {
	}

	public PeriodoAlocacao(int idPeriodoAlocacao, String criacao, TipoPeriodoEnum tipoPeriodo, String periodoInicio,
			String periodoFim, List<Alocacao> alocacao) {
		super();
		this.idPeriodoAlocacao = idPeriodoAlocacao;
		this.criacao = criacao;
		this.tipoPeriodo = tipoPeriodo;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.alocacao = alocacao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_periodo_alocacao")
	private int idPeriodoAlocacao;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Column(name = "tipo_periodo", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPeriodoEnum tipoPeriodo;

	@Column(name = "periodo_inicio", length = 4, nullable = false)
	private String periodoInicio;

	@Column(name = "periodo_fim", length = 4, nullable = false)
	private String periodoFim;

	@ManyToMany(mappedBy = "periodoAlocacao")
	//@JoinColumn(name = "id_alocacao")
	private List<Alocacao> alocacao;

	public int getIdPeriodoAlocacao() {
		return idPeriodoAlocacao;
	}

	public void setIdPeriodoAlocacao(int idPeriodoAlocacao) {
		this.idPeriodoAlocacao = idPeriodoAlocacao;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public TipoPeriodoEnum getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodoEnum tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public String getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(String periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public String getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(String periodoFim) {
		this.periodoFim = periodoFim;
	}

	public List<Alocacao> getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(List<Alocacao> alocacao) {
		this.alocacao = alocacao;
	}

}
