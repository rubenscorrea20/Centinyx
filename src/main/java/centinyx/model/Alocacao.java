package centinyx.model;

import java.util.Date;
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
@Table(name = "alocacao")
public class Alocacao {
	
	public Alocacao(){}

	public Alocacao(String criacao, List<Motoboy> motoboy, Date alocacao, TipoPeriodoEnum tipoPeriodo,
			List<Pedido> pedido, int idAlocacao) {
		super();
		this.criacao = criacao;
		this.motoboy = motoboy;
		this.alocacao = alocacao;
		TipoPeriodo = tipoPeriodo;
		this.pedido = pedido;
		this.idAlocacao = idAlocacao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alocacao")
	private int idAlocacao;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@ManyToMany
	@JoinColumn(name = "id_motoboy", nullable = false)
	private List<Motoboy> motoboy;

	@Column(name = "data_alocacao", length = 8, nullable = false)
	private Date alocacao;

	@Column(name = "tipo_periodo", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPeriodoEnum TipoPeriodo;

	@ManyToMany
	@JoinColumn(name = "id_pedido")
	private List<Pedido> pedido;
	
	public int getIdAlocacao() {
		return idAlocacao;
	}

	public void setIdAlocacao(int idAlocacao) {
		this.idAlocacao = idAlocacao;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public Date getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(Date alocacao) {
		this.alocacao = alocacao;
	}

	public TipoPeriodoEnum getTipoPeriodo() {
		return TipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodoEnum tipoPeriodo) {
		TipoPeriodo = tipoPeriodo;
	}

	public List<Motoboy> getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(List<Motoboy> motoboy) {
		this.motoboy = motoboy;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> id_pedido) {
		this.pedido = id_pedido;
	}

	public String getData_criacao() {
		return criacao;
	}

	public void setData_criacao(String criacao) {
		this.criacao = criacao;
	}

}
