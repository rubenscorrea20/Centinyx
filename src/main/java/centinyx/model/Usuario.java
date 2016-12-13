package centinyx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario {

	public Usuario() {
	}

	public Usuario(int idUsuario, String criacao, Funcionario funcionario, String login, String senha,
			String emailLogin, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.criacao = criacao;
		this.funcionario = funcionario;
		this.login = login;
		this.senha = senha;
		this.emailLogin = emailLogin;
		this.perfil = perfil;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "data_criacao", length = 20)
	private String criacao;

	@OneToOne(mappedBy = "usuario")
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	@NotBlank(message = "O campo login precisa ser preenchido!")
	@Column(name = "login", length = 50)
	private String login;

	@Size(min = 6, max = 10)
	@Column(name = "senha")
	private String senha;

	@NotBlank(message = "O campo email precisa ser preenchido!")
	@Email(message = "Por favor, digite um endereço de e-mail válido!")
	@Column(name = "email_login", length = 60)
	private String emailLogin;

	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = true, updatable = true, insertable = true)
	private Perfil perfil;

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
