package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alocacao")
public class Alocacao {

	public Alocacao() {
	}

	public Alocacao(int idAlocacao, String criacao, String dataAlocacao, int quantidadeMotoboy, Pedido pedido,
			PeriodoAlocacao periodoAlocacao, List<Motoboy> motoboys, int numeroPedido) {
		super();
		this.idAlocacao = idAlocacao;
		this.criacao = criacao;
		this.dataAlocacao = dataAlocacao;
		this.quantidadeMotoboy = quantidadeMotoboy;
		this.pedido = pedido;
		this.periodoAlocacao = periodoAlocacao;
		this.motoboys = motoboys;
		this.numeroPedido = numeroPedido;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alocacao")
	private int idAlocacao;

	@Column(name = "data_criacao", length = 20)
	private String criacao;

	@Column(name = "data_alocacao", length = 20)
	private String dataAlocacao;

	@Column(name = "quantidade_motoboy", length = 2)
	private int quantidadeMotoboy;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@Column(name = "numero_pedido")
	private int numeroPedido;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "id_periodo_alocacao")
	private PeriodoAlocacao periodoAlocacao;
	
	@ManyToMany
	@JoinTable(name="alocacao_motoboy", joinColumns = @JoinColumn(name="id_alocacao"), 
	inverseJoinColumns = @JoinColumn(name="id_motoboy"))
	private List<Motoboy> motoboys;

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

	public String getDataAlocacao() {
		return dataAlocacao;
	}

	public void setDataAlocacao(String dataAlocacao) {
		this.dataAlocacao = dataAlocacao;
	}

	public int getQuantidadeMotoboy() {
		return quantidadeMotoboy;
	}

	public void setQuantidadeMotoboy(int quantidadeMotoboy) {
		this.quantidadeMotoboy = quantidadeMotoboy;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public PeriodoAlocacao getPeriodoAlocacao() {
		return periodoAlocacao;
	}

	public void setPeriodoAlocacao(PeriodoAlocacao periodoAlocacao) {
		this.periodoAlocacao = periodoAlocacao;
	}

	public List<Motoboy> getMotoboys() {
		return motoboys;
	}

	public void setMotoboys(List<Motoboy> motoboys) {
		this.motoboys = motoboys;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
}
