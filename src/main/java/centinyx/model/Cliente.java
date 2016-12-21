package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.stella.bean.validation.CNPJ;

@Entity
@Table(name = "cliente")
public class Cliente {

	public Cliente() {
	}

	public Cliente(int idCliente, ContatoCliente contatoCliente, String criacao, String nomeFantasia,
			String razaoSocial, String cnpj, String bairro, String logradouro, int numero, String complemento,
			String cep, String cidade, String ufEndereco, String telefone, String email, String pdd,
			List<Pedido> pedido) {
		super();
		this.idCliente = idCliente;
		this.contatoCliente = contatoCliente;
		this.criacao = criacao;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.ufEndereco = ufEndereco;
		this.telefone = telefone;
		this.email = email;
		this.pdd = pdd;
		this.pedido = pedido;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int idCliente;

	@OneToOne(optional = true)
	@JoinColumn(name = "id_contato_cliente")
	private ContatoCliente contatoCliente;

	@Column(name = "data_criacao", length = 20)
	private String criacao;

	@NotBlank(message = "O campo nome fantasia precisa ser preenchido!")
	@Column(name = "nome_fantasia", length = 100)
	private String nomeFantasia;

	@NotBlank(message = "O campo razão social precisa ser preenchido!")
	@Column(name = "razao_social", length = 150)
	private String razaoSocial;

	@NotBlank(message = "O campo CNPJ precisa ser preenchido!")
	@CNPJ(message = "CNPJ inválido!")
	@Column(name = "cnpj", length = 18, unique = true)
	private String cnpj;

	@NotBlank(message = "O campo bairro precisa ser preenchido!")
	@Column(name = "bairro", length = 50)
	private String bairro;

	@NotBlank(message = "O campo logradouro precisa ser preenchido!")
	@Column(name = "logradouro", length = 100)
	private String logradouro;

	@Column(name = "numero", length = 4)
	private int numero;

	@Column(name = "complemento", length = 50)
	private String complemento;

	@NotBlank(message = "O campo CEP precisa ser preenchido!")
	@Column(name = "cep", length = 9)
	private String cep;

	@NotBlank(message = "O campo cidade precisa ser preenchido!")
	@Column(name = "cidade", length = 50)
	private String cidade;

	@NotBlank(message = "O campo UF precisa ser preenchido!")
	@Column(name = "uf_endereco", length = 15)
	private String ufEndereco;

	@NotBlank(message = "O campo telefone precisa ser preenchido!")
	@Column(name = "telefone", length = 14)
	private String telefone;

	@NotBlank(message = "O campo email precisa ser preenchido!")
	@Email(message = "Por favor, entre com um endereço de e-mail válido!")
	@Column(name = "email", length = 60)
	private String email;

	@Column(name = "pdd", length = 3)
	private String pdd;

	@OneToMany(mappedBy = "cliente")
	// @JoinColumn(name = "id_escala")
	private List<Pedido> pedido;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public ContatoCliente getContatoCliente() {
		return contatoCliente;
	}

	public void setContatoCliente(ContatoCliente contatoCliente) {
		this.contatoCliente = contatoCliente;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUfEndereco() {
		return ufEndereco;
	}

	public void setUfEndereco(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPdd() {
		return pdd;
	}

	public void setPdd(String pdd) {
		this.pdd = pdd;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}