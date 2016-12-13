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
import centinyx.model.Perfil;
import centinyx.repository.PerfilRepository;

@Controller
@RequestMapping(value = "/perfil")
public class PerfilController {

	@Autowired
	private PerfilRepository perfis;

	private static final String FORM = "formPerfil";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Perfil perfil) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("perfil", perfil);
		return mv;
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@Valid Perfil perfil, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(perfil);
		}
		perfil.setCriacao(DataCriacao.geraDataHorario());
		perfis.save(perfil);
		return new ModelAndView("redirect:/perfil/lista");
	}
	
	@RequestMapping(value = "/lista")
	public ModelAndView listar() {
		List<Perfil> listaperfis = perfis.findAll();
		ModelAndView mv = new ModelAndView("listaPerfil");
		mv.addObject("perfis", listaperfis);
		return mv;
	}
	
	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorTipoAcesso(@RequestParam("tipoAcesso") String tipoAcesso, Model model) {
		if (tipoAcesso.isEmpty()) {
			return listar();
		} else {
			ModelAndView m = new ModelAndView("listaPerfil");
			model.addAttribute("usuarios", perfis.findByTipoAcesso(tipoAcesso));
			model.addAttribute("tipoAcesso", tipoAcesso);
			return m;
		}
	}
}