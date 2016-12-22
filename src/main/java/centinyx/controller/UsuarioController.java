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
import centinyx.model.Usuario;
import centinyx.repository.FuncionarioRepository;
import centinyx.repository.PerfilRepository;
import centinyx.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarios;

	@Autowired
	private PerfilRepository perfis;

	@Autowired
	private FuncionarioRepository funcionarios;

	private static final String FORM = "formUsuario";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Usuario usuario) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("usuario", usuario);
		return mv;
	}

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("tipoAcesso") String tipoAcesso, @Valid Usuario usuario,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(usuario);
		}
		usuario.setPerfil(perfis.encontraId(tipoAcesso));
		usuario.setCriacao(DataCriacao.geraDataHorario());
		usuarios.save(usuario);
		return new ModelAndView("redirect:/usuario/lista");
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar() {
		List<Usuario> listaUsuario = usuarios.findAll();
		ModelAndView mv = new ModelAndView("listaUsuario");
		mv.addObject("usuarios", listaUsuario);
		return mv;
	}

	// Metodo para editar os dados do usuario
	@RequestMapping("{idUsuario}")
	public ModelAndView editar(@PathVariable int idUsuario) {
		ModelAndView mv = new ModelAndView(FORM);
		Usuario usuario = usuarios.findOne(idUsuario);
		mv.addObject(usuario);
		return mv;
	}

	// Metodo para deletar os dados do usuario e o usuario do funcionario.
	@RequestMapping("usuario/deleta/{idUsuario}")
	public ModelAndView deletar(@PathVariable int idUsuario) {
		Usuario usuario = usuarios.findOne(idUsuario);
		if (usuario.getFuncionario() == null) {
			usuarios.deleteByIdUsuario(idUsuario);
			return new ModelAndView("redirect:/usuario/lista");
		} else {
			Funcionario funcionario = usuario.getFuncionario();
			funcionarios.atualizaUsuarioFuncionario(funcionario.getNome());
			usuario.setFuncionario(null);
			usuarios.deleteByIdUsuario(idUsuario);
			return new ModelAndView("redirect:/usuario/lista");
		}
	}

	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorLogin(@RequestParam("login") String login, Model model) {
		if (login.isEmpty()) {
			return listar();
		} else {
			ModelAndView m = new ModelAndView("listaUsuario");
			model.addAttribute("usuarios", usuarios.findByLogin(login));
			model.addAttribute("login", login);
			return m;
		}
	}
}
