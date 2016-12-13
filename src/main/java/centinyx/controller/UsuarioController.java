package centinyx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import centinyx.logic.DataCriacao;
import centinyx.model.Usuario;
import centinyx.repository.PerfilRepository;
import centinyx.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarios;
	
	@Autowired
	private PerfilRepository perfis;

	private static final String FORM = "formUsuario";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Usuario usuario) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("tipoAcesso") String tipoAcesso, @Valid Usuario usuario, BindingResult resultado) {
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
