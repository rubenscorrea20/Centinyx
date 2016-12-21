package centinyx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import centinyx.enums.TipoTelefoneEnum;

@Entity
@Table(name = "contato_cliente")
public class ContatoCliente {
	
	public ContatoCliente(){}

	public ContatoCliente(int idContatoCliente, String criacao, String email, String nomeContato, String telefone,
			TipoTelefoneEnum tipoTelefone, Cliente cliente) {
		super();
		this.idContatoCliente = idContatoCliente;
		this.criacao = criacao;
		this.email = email;
		this.nomeContato = nomeContato;
		this.telefone = telefone;
		this.tipoTelefone = tipoTelefone;
		this.cliente = cliente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato_cliente")
	private int idContatoCliente;

	@Column(name = "data_criacao", length = 20, nullable = false)
	private String criacao;

	@Email
	@Column(name = "email", length = 60, nullable = false)
	private String email;

	@Column(name = "nome_contato", length = 50, nullable = false)
	private String nomeContato;

	@Column(name = "telefone", length = 14, nullable = false)
	private String telefone;

	@Column(nullable = false, name = "tipo_telefone")
	@Enumerated(EnumType.STRING)
	private TipoTelefoneEnum tipoTelefone;

	@OneToOne(mappedBy = "contatoCliente")
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public int getIdContatoCliente() {
		return idContatoCliente;
	}

	public void setIdContatoCliente(int idContatoCliente) {
		this.idContatoCliente = idContatoCliente;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public TipoTelefoneEnum getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
