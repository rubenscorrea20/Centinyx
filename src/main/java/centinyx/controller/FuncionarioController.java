package centinyx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import centinyx.logic.DataCriacao;
import centinyx.model.Funcionario;
import centinyx.repository.FuncionarioRepository;
import centinyx.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarios;

	@Autowired
	private UsuarioRepository usuarios;

	private static final String FORM = "formFuncionario";

	boolean cpfDuplicado = false;

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("login") String login, @RequestParam("contaBancaria") String contaBancaria,
			@RequestParam("digitoConta") String digitoConta, @Valid Funcionario funcionario,
			BindingResult resultado) {
		
		StringBuilder sb = new StringBuilder();
		String contaFuncionario = sb.append(contaBancaria).append("-").append(digitoConta).toString();
		funcionario.setContaBancaria(contaFuncionario);
		funcionario.setUsuario(usuarios.encontraLoginUsuario(login));
		funcionario.setCriacao(DataCriacao.geraDataHorario());
		try {
			funcionarios.save(funcionario);
		} catch (Exception e) {
			if (funcionarios.encontraCPFexistente(funcionario.getCpf()) != null) {
				String m = "Já há um cadastro com este CPF!";
				System.out.println(m);
				cpfDuplicado = true;
				ModelAndView mv = new ModelAndView("formFuncionario", "mensagem", m);
				return mv;
			}
		}
		if (resultado.hasErrors()) {
			return cadastra(funcionario);
		}
		if (funcionario.getFuncao().equalsIgnoreCase("MOTOBOY")) {
			funcionario.setUsuario(usuarios.encontraLoginUsuario(login));
			funcionario.setCriacao(DataCriacao.geraDataHorario());
			funcionarios.save(funcionario);
			return new ModelAndView("redirect:/funcionario/motoboy/cadastra");
		}
		return new ModelAndView("redirect:/funcionario/lista");
	}

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView cadastraUsuario(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	// Pageable objeto para paginação, e @pageableDefault para delimitar
	// quantidade de registros por pagina
	@RequestMapping(value = "/lista")
	public ModelAndView listar(@PageableDefault(size = 1) Pageable pageable) {
		Page<Funcionario> listaFuncionario = funcionarios.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaFuncionario");
		mv.addObject("funcionarios", listaFuncionario);
		int numeroPaginas = listaFuncionario.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}

	// Lista os detalhes do Funcionario clicado
	@RequestMapping("/lista/{idFuncionario}")
	public ModelAndView visualizar(@PathVariable int idFuncionario) {
		ModelAndView mv = new ModelAndView("detalhesFuncionario");
		Funcionario funcionario = funcionarios.findOne(idFuncionario);
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	// Metodo para editar os dados do Funcionário
	@RequestMapping("{idFuncionario}")
	public ModelAndView editar(@PathVariable int idFuncionario) {
		ModelAndView mv = new ModelAndView(FORM);
		Funcionario funcionario = funcionarios.findOne(idFuncionario);
		mv.addObject(funcionario);
		return mv;
	}

	// Metodo para deletar os dados do Funcionário
	@RequestMapping("funcionario/deleta/{idFuncionario}")
	public ModelAndView deletar(@PathVariable int idFuncionario) {
		funcionarios.deleteByIdFuncionario(idFuncionario);
		return new ModelAndView("redirect:/funcionario/lista");
	}

	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorNome(@RequestParam("nomeCompleto") String nome, Model model, Pageable pageable) {
		if (nome.isEmpty()) {
			return new ModelAndView("redirect:/funcionario/lista");
		} else {
			Page<Funcionario> funcionarioPorNome = funcionarios.findByNomeContaining(nome, pageable);
			ModelAndView m = new ModelAndView("listaFuncionario");
			model.addAttribute("funcionarios", funcionarioPorNome);
			model.addAttribute("nomeCompleto", nome);
			int numeroPaginas = funcionarioPorNome.getTotalPages();
			m.addObject("totalPaginas", numeroPaginas);
			return m;
		}
	}
}
