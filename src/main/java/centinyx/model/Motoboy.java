package centinyx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "motoboy")
@PrimaryKeyJoinColumn(name = "id_funcionario")
public class Motoboy {

	public Motoboy() {
	}

	public Motoboy(int idMotoboy, String cnh, String categoriaCNH, String validadeCNH, String criacao,
			String status_motoboy, String cpfProprietarioMoto, String marcaMoto, String anoMoto, String modeloMoto,
			String placaMoto, String renavam, String cor, String regiaoAlocacao, Funcionario funcionario) {
		super();
		this.idMotoboy = idMotoboy;
		this.cnh = cnh;
		this.categoriaCNH = categoriaCNH;
		this.validadeCNH = validadeCNH;
		this.criacao = criacao;
		this.status_motoboy = status_motoboy;
		this.cpfProprietarioMoto = cpfProprietarioMoto;
		this.marcaMoto = marcaMoto;
		this.anoMoto = anoMoto;
		this.modeloMoto = modeloMoto;
		this.placaMoto = placaMoto;
		this.renavam = renavam;
		this.cor = cor;
		this.regiaoAlocacao = regiaoAlocacao;
		this.funcionario = funcionario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_motoboy")
	private int idMotoboy;

	@NotBlank(message = "O campo CNH do motoboy precisa ser preenchido!")
	@Column(name = "cnh_motoboy", length = 11)
	private String cnh;

	@NotBlank(message = "O campo categoria da CNH precisa ser preenchido!")
	@Column(name = "categoria_cnh", length = 3)
	private String categoriaCNH;

	@NotBlank(message = "O campo validade da CNH precisa ser preenchido!")
	@Column(name = "validade_cnh", length = 12)
	private String validadeCNH;

	@Column(name = "data_criacao", length = 20)
	private String criacao;

	@Column(name = "status_motoboy", length = 30)
	private String status_motoboy;

	@NotBlank(message = "O campo CPF do proprietário precisa ser preenchido!")
	@Column(name = "cpf_proprietario", length = 14)
	private String cpfProprietarioMoto;

	@NotBlank(message = "O campo marca da moto precisa ser preenchido!")
	@Column(name = "marca_moto", length = 50)
	private String marcaMoto;

	@NotBlank(message = "O campo ano de fabricação precisa ser preenchido!")
	@Column(name = "ano_fabricacao_moto", length = 4)
	private String anoMoto;

	@NotBlank(message = "O campo modelo da moto precisa ser preenchido!")
	@Column(name = "modelo_moto", length = 50)
	private String modeloMoto;

	@NotBlank(message = "O campo placa da moto precisa ser preenchido!")
	@Column(name = "placa_moto", length = 10)
	private String placaMoto;

	@NotBlank(message = "O campo renavam precisa ser preenchido!")
	@Column(name = "renavam", length = 11)
	private String renavam;

	@NotBlank(message = "O campo cor da moto precisa ser preenchido!")
	@Column(name = "cor_moto", length = 15)
	private String cor;

	@Column(name = "regiao_alocacao", length = 100)
	private String regiaoAlocacao;

	@OneToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public int getIdMotoboy() {
		return idMotoboy;
	}

	public void setIdMotoboy(int idMotoboy) {
		this.idMotoboy = idMotoboy;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(String categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public String getValidadeCNH() {
		return validadeCNH;
	}

	public void setValidadeCNH(String validadeCNH) {
		this.validadeCNH = validadeCNH;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getStatus_motoboy() {
		return status_motoboy;
	}

	public void setStatus_motoboy(String status_motoboy) {
		this.status_motoboy = status_motoboy;
	}

	public String getCpfProprietarioMoto() {
		return cpfProprietarioMoto;
	}

	public void setCpfProprietarioMoto(String cpfProprietarioMoto) {
		this.cpfProprietarioMoto = cpfProprietarioMoto;
	}

	public String getMarcaMoto() {
		return marcaMoto;
	}

	public void setMarcaMoto(String marcaMoto) {
		this.marcaMoto = marcaMoto;
	}

	public String getAnoMoto() {
		return anoMoto;
	}

	public void setAnoMoto(String anoMoto) {
		this.anoMoto = anoMoto;
	}

	public String getModeloMoto() {
		return modeloMoto;
	}

	public void setModeloMoto(String modeloMoto) {
		this.modeloMoto = modeloMoto;
	}

	public String getPlacaMoto() {
		return placaMoto;
	}

	public void setPlacaMoto(String placaMoto) {
		this.placaMoto = placaMoto;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRegiaoAlocacao() {
		return regiaoAlocacao;
	}

	public void setRegiaoAlocacao(String regiaoAlocacao) {
		this.regiaoAlocacao = regiaoAlocacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
