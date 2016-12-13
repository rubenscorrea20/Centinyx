package centinyx.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import centinyx.enums.TipoPeriodoEnum;

@Entity
@Table(name = "periodo_alocacao")
public class PeriodoAlocacao {
	
	public PeriodoAlocacao(){}

	public PeriodoAlocacao(int idPeriodoAlocacao, String criacao, TipoPeriodoEnum tipo_periodo, Date periodoInicio,
			Date periodoFim, List<Escalas> escala) {
		super();
		this.idPeriodoAlocacao = idPeriodoAlocacao;
		this.criacao = criacao;
		this.tipo_periodo = tipo_periodo;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.escala = escala;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_periodo_alocacao")
	private int idPeriodoAlocacao;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Column(name = "tipo_periodo", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPeriodoEnum tipo_periodo;

	@Column(name = "periodo_inicio", length = 4, nullable = false)
	private Date periodoInicio;

	@Column(name = "periodo_fim", length = 4, nullable = false)
	private Date periodoFim;

	@ManyToMany
	@JoinColumn(name = "id_escala")
	private List<Escalas> escala;

	public int getIdPeriodoAlocacao() {
		return idPeriodoAlocacao;
	}

	public void setIdPeriodoAlocacao(int idPeriodoAlocacao) {
		this.idPeriodoAlocacao = idPeriodoAlocacao;
	}

	public TipoPeriodoEnum getTipo_periodo() {
		return tipo_periodo;
	}

	public void setTipo_periodo(TipoPeriodoEnum tipo_periodo) {
		this.tipo_periodo = tipo_periodo;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	public List<Escalas> getEscala() {
		return escala;
	}

	public void setEscala(List<Escalas> escala) {
		this.escala = escala;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

}
