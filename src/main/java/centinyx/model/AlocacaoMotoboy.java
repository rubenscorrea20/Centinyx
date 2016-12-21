package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alocacao_motoboy")
public class AlocacaoMotoboy {

	public AlocacaoMotoboy() {
	}

	public AlocacaoMotoboy(int idAlocacaoMotoboy, List<Alocacao> alocacao, List<Motoboy> motoboy) {
		super();
		this.idAlocacaoMotoboy = idAlocacaoMotoboy;
		this.alocacao = alocacao;
		this.motoboy = motoboy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alocacao_motoboy")
	private int idAlocacaoMotoboy;

	@ManyToMany
	@JoinColumn(name = "id_alocacao")
	private List<Alocacao> alocacao;

	@ManyToMany
	@JoinColumn(name = "id_motoboy")
	private List<Motoboy> motoboy;

	public int getIdAlocacaoMotoboy() {
		return idAlocacaoMotoboy;
	}

	public void setIdAlocacaoMotoboy(int idAlocacaoMotoboy) {
		this.idAlocacaoMotoboy = idAlocacaoMotoboy;
	}

	public List<Alocacao> getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(List<Alocacao> alocacao) {
		this.alocacao = alocacao;
	}

	public List<Motoboy> getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(List<Motoboy> motoboy) {
		this.motoboy = motoboy;
	}

}
