package centinyx.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import centinyx.model.Motoboy;
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

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@RequestMapping(value = "/cadastra/motoboy")
	public ModelAndView cadastraMotoboy(Motoboy motoboy) {
		ModelAndView mv = new ModelAndView("formMotoboy");
		mv.addObject("motoboys", motoboy);
		return mv;
	}

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("login") String login, @Valid Funcionario funcionario,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(funcionario);
		}
		if (funcionario.getFuncao().equalsIgnoreCase("MOTOBOY")) {
			funcionario.setUsuario(usuarios.encontraLoginUsuario(login));
			funcionario.setCriacao(DataCriacao.geraDataHorario());
			funcionarios.save(funcionario);
			return new ModelAndView("redirect:/funcionario/cadastra/motoboy");
		}
		funcionario.setUsuario(usuarios.encontraLoginUsuario(login));
		funcionario.setCriacao(DataCriacao.geraDataHorario());
		funcionarios.save(funcionario);
		return new ModelAndView("redirect:/funcionario/lista");
	}

	/*
	 * @RequestMapping(value = "/buscausuario") public ModelAndView
	 * buscaUsuario() { List<Usuario> listaUsuario = usuarios.findAll();
	 * ModelAndView mv = new ModelAndView("listaUsuario");
	 * mv.addObject("usuarios", listaUsuario); return mv; }
	 */

	@RequestMapping(value = "/lista")
	public ModelAndView listar() {
		List<Funcionario> listaFuncionario = funcionarios.findAll();
		ModelAndView mv = new ModelAndView("listaFuncionario");
		mv.addObject("funcionarios", listaFuncionario);
		return mv;
	}

	// Lista os detalhes do Funcionario clicado
	@RequestMapping("/lista/{idFuncionario}")
	public ModelAndView visualizar(@PathVariable int idFuncionario) {
		ModelAndView mv = new ModelAndView("detalhesfuncionario");
		Funcionario funcionario = funcionarios.findOne(idFuncionario);
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	// Metódo para editar os dados do Funcionário
	@RequestMapping("{idFuncionario}")
	public ModelAndView editar(@PathVariable int idFuncionario) {
		ModelAndView mv = new ModelAndView(FORM);
		Funcionario funcionario = funcionarios.findOne(idFuncionario);
		mv.addObject(funcionario);
		return mv;
	}

	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorNome(@RequestParam("nomeCompleto") String nomeCompleto, Model model) {
		if (nomeCompleto.isEmpty()) {
			return listar();
		} else {
			ModelAndView m = new ModelAndView("listaFuncionario");
			model.addAttribute("funcionarios", funcionarios.findByNomeCompleto(nomeCompleto));
			model.addAttribute("nomeCompleto", nomeCompleto);
			return m;
		}
	}
}
