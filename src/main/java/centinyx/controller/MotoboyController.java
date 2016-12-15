package centinyx.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import centinyx.logic.DataCriacao;
import centinyx.model.Motoboy;
import centinyx.repository.FuncionarioRepository;
import centinyx.repository.MotoboyRepository;

@Controller
@RequestMapping(value = "/funcionario/motoboy")
public class MotoboyController {

	@Autowired
	private FuncionarioRepository funcionarios;

	@Autowired
	private MotoboyRepository motoboys;

	private static final String FORM = "formMotoboy";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Motoboy motoboy) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("motoboys", motoboy);
		return mv;
	}

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("nomeFuncionario") String nomeFuncionario, @Valid Motoboy motoboy,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(motoboy);
		}
		motoboy.setCriacao(DataCriacao.geraDataHorario());
		motoboy.setFuncionario(funcionarios.encontraNomeFuncionario(nomeFuncionario));
		motoboys.save(motoboy);
		return new ModelAndView("redirect:/funcionario/motoboy/lista");
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar() {
		List<Motoboy> listaMotoboy = motoboys.findAll();
		ModelAndView mv = new ModelAndView("listaMotoboy");
		mv.addObject("funcionarios", listaMotoboy);
		return mv;
	}

	// Lista os detalhes do Motoboy clicado
	@RequestMapping("/lista/{idMotoboy}")
	public ModelAndView visualizar(@PathVariable int idMotoboy) {
		ModelAndView mv = new ModelAndView("detalhesMotoboy");
		Motoboy motoboy = motoboys.findOne(idMotoboy);
		mv.addObject("motoboys", motoboy);
		return mv;
	}

	/*
	 * @RequestMapping(value = "/busca") public ModelAndView
	 * buscaPorNome(@RequestParam("nomeCompleto") String nomeCompleto, Model
	 * model) { if (nomeCompleto.isEmpty()) { return listar(); } else {
	 * ModelAndView m = new ModelAndView("listaFuncionario");
	 * model.addAttribute("funcionarios",
	 * funcionarios.findByNomeCompleto(nomeCompleto));
	 * model.addAttribute("nomeCompleto", nomeCompleto); return m; } }
	 */
}
