package centinyx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.stella.bean.validation.CPF;
import centinyx.logic.CPFDuplicated;

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario {

	public Funcionario() {
	}

	public Funcionario(int idFuncionario, Motoboy motoboy, List<PagamentoFuncionario> idPagamentoFuncionario,
			String criacao, long codigoFuncional, String nomeCompleto, String documentoIdentidade, String orgaoEmissor,
			String ufNascimento, String dataNascimento, String nacionalidade, String departamento, String cpf,
			String bairro, String logradouro, int numero, String complemento, String cep, String cidade,
			String ufEndereco, String telefone, String celular, String email, String sexo, String funcao, String banco,
			String contaBancaria, String agencia, String tipoConta, String cpfFavorecido, String nomeFavorecido,
			String dataAdmissao, int reservista, int tituloEleitor, int zonaEleitoral, int secaoEleitoral,
			int carteiraTrabalho, String serieCarteira, int pis, String escolaridade, String nomeMae, String nomePai,
			Usuario usuario) {
		super();
		this.idFuncionario = idFuncionario;
		this.motoboy = motoboy;
		this.idPagamentoFuncionario = idPagamentoFuncionario;
		this.criacao = criacao;
		this.codigoFuncional = codigoFuncional;
		this.nomeCompleto = nomeCompleto;
		this.documentoIdentidade = documentoIdentidade;
		this.orgaoEmissor = orgaoEmissor;
		this.ufNascimento = ufNascimento;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.departamento = departamento;
		this.cpf = cpf;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.ufEndereco = ufEndereco;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.sexo = sexo;
		this.funcao = funcao;
		this.banco = banco;
		this.contaBancaria = contaBancaria;
		this.agencia = agencia;
		this.tipoConta = tipoConta;
		this.cpfFavorecido = cpfFavorecido;
		this.nomeFavorecido = nomeFavorecido;
		this.dataAdmissao = dataAdmissao;
		this.reservista = reservista;
		this.tituloEleitor = tituloEleitor;
		this.zonaEleitoral = zonaEleitoral;
		this.secaoEleitoral = secaoEleitoral;
		this.carteiraTrabalho = carteiraTrabalho;
		this.serieCarteira = serieCarteira;
		this.pis = pis;
		this.escolaridade = escolaridade;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.usuario = usuario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@OneToOne(optional = false, mappedBy = "funcionario")
	private Motoboy motoboy;

	@OneToMany(mappedBy = "funcionario")
	private List<PagamentoFuncionario> idPagamentoFuncionario;

	@Column(name = "data_criacao", length = 20)
	private String criacao;

	@Min(value = 100, message = "O código funcional precisa ser maior ou igual a 100!")
	@NotNull(message = "O campo código funcional precisa ser preenchido!")
	@Column(name = "codigoFuncional", length = 4)
	private long codigoFuncional;

	@NotBlank(message = "O campo nome precisa ser preenchido!")
	@Column(name = "nome", length = 100)
	private String nomeCompleto;

	@NotBlank(message = "O campo documento de identidade precisa ser preenchido!")
	@Column(name = "documento_identidade", length = 20)
	private String documentoIdentidade;

	@NotBlank(message = "O campo orgão emissor precisa ser preenchido!")
	@Column(name = "orgao_emissor", length = 10)
	private String orgaoEmissor;

	@NotBlank(message = "O campo UF precisa ser preenchido!")
	@Column(name = "uf_nascimento", length = 15)
	private String ufNascimento;

	@NotBlank(message = "O campo data de nascimento precisa ser preenchido!")
	@Column(name = "data_nascimento", length = 12)
	private String dataNascimento;

	@NotBlank(message = "O campo nacionalidade precisa ser preenchido!")
	@Column(name = "nacionalidade", length = 50)
	private String nacionalidade;

	@NotBlank(message = "O campo departamento precisa ser preenchido!")
	@Column(name = "departamento", length = 100)
	private String departamento;

	@NotBlank(message = "O campo CPF precisa ser preenchido!")
	@CPF(message = "O CPF digitado é inválido!")
	@Column(name = "cpf", length = 14, unique = true)
	@CPFDuplicated(message = "Este CPF já existe e portanto não pode ser duplicado!")
	private String cpf;

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
	@Column(name = "cep", length = 20)
	private String cep;

	@NotBlank(message = "O campo cidade precisa ser preenchido!")
	@Column(name = "cidade", length = 50)
	private String cidade;

	@NotBlank(message = "O campo UF precisa ser preenchido!")
	@Column(name = "uf_endereco", length = 15)
	private String ufEndereco;

	@NotBlank(message = "O campo telefone precisa ser preenchido!")
	@Column(name = "telefone", length = 50)
	private String telefone;

	@Column(name = "celular", length = 50)
	private String celular;

	@NotBlank(message = "O campo email precisa ser preenchido!")
	@Email(message = "Por favor, entre com um endereço de e-mail válido!")
	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "sexo", length = 10)
	private String sexo;

	@NotBlank(message = "O campo função precisa ser preenchido!")
	@Column(name = "funcao", length = 60)
	private String funcao;

	@Column(name = "banco", length = 20)
	private String banco;

	@NotBlank(message = "O campo conta bancaria precisa ser preenchido!")
	@Column(name = "conta_bancaria", length = 8)
	private String contaBancaria;

	@NotBlank(message = "O campo agencia precisa ser preenchido!")
	@Column(name = "agencia_bancaria", length = 6)
	private String agencia;

	@Column(name = "tipo_conta", length = 20)
	private String tipoConta;

	@CPF(message = "O CPF do favorecido digitado é inválido!")
	@Column(name = "cpf_favorecido", length = 14, unique = true)
	private String cpfFavorecido;

	@Column(name = "nome_favorecido", length = 100)
	private String nomeFavorecido;

	@NotBlank(message = "O campo data de admissão precisa ser preenchido!")
	@Column(name = "data_admissao", length = 12)
	private String dataAdmissao;

	@Column(name = "reservista", length = 12)
	private int reservista;

	@Column(name = "titulo_eleitor", length = 12)
	private int tituloEleitor;

	@Column(name = "zona_eleitoral", length = 3)
	private int zonaEleitoral;

	@Column(name = "secao_eleitoral", length = 4)
	private int secaoEleitoral;

	@Column(name = "carteira_trabalho", length = 5)
	private int carteiraTrabalho;

	@Column(name = "serie_ct", length = 8)
	private String serieCarteira;

	@Column(name = "pis", length = 20)
	private int pis;

	@Column(name = "escolaridade", length = 35)
	private String escolaridade;

	@Column(name = "nome_mae", length = 100)
	private String nomeMae;

	@Column(name = "nome_pai", length = 100)
	private String nomePai;

	@OneToOne(optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public List<PagamentoFuncionario> getIdPagamentoFuncionario() {
		return idPagamentoFuncionario;
	}

	public void setIdPagamentoFuncionario(List<PagamentoFuncionario> idPagamentoFuncionario) {
		this.idPagamentoFuncionario = idPagamentoFuncionario;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getDocumentoIdentidade() {
		return documentoIdentidade;
	}

	public void setDocumentoIdentidade(String documentoIdentidade) {
		this.documentoIdentidade = documentoIdentidade;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getUfNascimento() {
		return ufNascimento;
	}

	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	public String getUfEndereco() {
		return ufEndereco;
	}

	public void setUfEndereco(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Motoboy getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Motoboy motoboy) {
		this.motoboy = motoboy;
	}

	public long getCodigoFuncional() {
		return codigoFuncional;
	}

	public void setCodigoFuncional(long codigoFuncional) {
		this.codigoFuncional = codigoFuncional;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario id_usuario) {
		this.usuario = id_usuario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(String contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getCpfFavorecido() {
		return cpfFavorecido;
	}

	public void setCpfFavorecido(String cpfFavorecido) {
		this.cpfFavorecido = cpfFavorecido;
	}

	public String getNomeFavorecido() {
		return nomeFavorecido;
	}

	public void setNomeFavorecido(String nomeFavorecido) {
		this.nomeFavorecido = nomeFavorecido;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getReservista() {
		return reservista;
	}

	public void setReservista(int reservista) {
		this.reservista = reservista;
	}

	public int getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(int tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public int getZonaEleitoral() {
		return zonaEleitoral;
	}

	public void setZonaEleitoral(int zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}

	public int getSecaoEleitoral() {
		return secaoEleitoral;
	}

	public void setSecaoEleitoral(int secaoEleitoral) {
		this.secaoEleitoral = secaoEleitoral;
	}

	public int getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(int carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public String getSerieCarteira() {
		return serieCarteira;
	}

	public void setSerieCarteira(String serieCarteira) {
		this.serieCarteira = serieCarteira;
	}

	public int getPis() {
		return pis;
	}

	public void setPis(int pis) {
		this.pis = pis;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

}
