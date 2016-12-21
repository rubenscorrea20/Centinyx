package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "escala")
public class Escala {

	public Escala() {
	}

	public Escala(int idEscala, String criacao, List<Alocacao> alocacao) {
		super();
		this.idEscala = idEscala;
		this.criacao = criacao;
		this.alocacao = alocacao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_escala")
	private int idEscala;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;
	
	@OneToMany(mappedBy = "escala")
	//@JoinColumn(name = "idAlocacao")
	private List<Alocacao> alocacao;

	public int getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(int idEscala) {
		this.idEscala = idEscala;
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

}
