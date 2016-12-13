package centinyx.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import centinyx.enums.TipoEscala;

@Entity
@Table(name = "escalas")
public class Escalas {

	public Escalas() {}

	public Escalas(int idEscala, String criacao, List<Cliente> cliente, List<Pedido> pedido,
			List<PeriodoAlocacao> periodoAlocacao, List<Motoboy> motoboy, int quantidadeMotoboy, TipoEscala tipoEscala,
			long codigoEscala) {
		super();
		this.idEscala = idEscala;
		this.criacao = criacao;
		this.cliente = cliente;
		this.pedido = pedido;
		this.periodoAlocacao = periodoAlocacao;
		this.motoboy = motoboy;
		this.quantidadeMotoboy = quantidadeMotoboy;
		this.tipoEscala = tipoEscala;
		this.codigoEscala = codigoEscala;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_escala")
	private int idEscala;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@ManyToMany
	@JoinColumn(name = "id_cliente")
	private List<Cliente> cliente;

	@OneToMany(mappedBy = "escala")
	//@JoinColumn(name = "id_pedido")
	private List<Pedido> pedido;
	
	@ManyToMany(mappedBy = "escala")
	//@JoinColumn(name = "id_periodo_alocacao")
	private List<PeriodoAlocacao> periodoAlocacao;

	@ManyToMany(mappedBy = "escala")
	//@JoinColumn(name = "id_motoboy")
	private List<Motoboy> motoboy;

	@Column(name = "quantidade_motoboy", length = 2)
	private int quantidadeMotoboy;

	@Column(nullable = false, name = "tipo_escala")
	@Enumerated(EnumType.STRING)
	private TipoEscala tipoEscala;

	@Column(nullable = false, name = "codigo_escala", length = 8)
	private long codigoEscala;

	public List<Motoboy> getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(List<Motoboy> motoboy) {
		this.motoboy = motoboy;
	}

	public int getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(int idEscala) {
		this.idEscala = idEscala;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public long getCodigoEscala() {
		return codigoEscala;
	}

	public void setCodigoEscala(long codigoEscala) {
		this.codigoEscala = codigoEscala;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> id_cliente) {
		this.cliente = id_cliente;
	}

	public int getQuantidadeMotoboy() {
		return quantidadeMotoboy;
	}

	public void setQuantidadeMotoboy(int quantidade_motoboy) {
		this.quantidadeMotoboy = quantidade_motoboy;
	}

	public void setTipoEscala(TipoEscala tipoEscala) {
		this.tipoEscala = tipoEscala;
	}

	public TipoEscala getTipoEscala() {
		return tipoEscala;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

}
