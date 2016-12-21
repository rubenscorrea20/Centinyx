package centinyx.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "perfil")
public class Perfil {

	public Perfil() {
	}

	public Perfil(int idPerfil, String criacao, String descricao, List<Usuario> usuario, String tipoAcesso) {
		super();
		this.idPerfil = idPerfil;
		this.criacao = criacao;
		this.descricao = descricao;
		this.usuario = usuario;
		this.tipoAcesso = tipoAcesso;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	private int idPerfil;

	@Column(name = "data_criacao", length = 20)
	private String criacao;

	@Column(name = "descricao", length = 150)
	private String descricao;

	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuario;

	@NotBlank(message = "O campo Perfil/Tipo acesso precisa ser preenchido!")
	@Column(name = "tipo_acesso", length = 50)
	private String tipoAcesso;

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}
