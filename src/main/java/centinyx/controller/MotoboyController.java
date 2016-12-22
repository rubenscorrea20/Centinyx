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
	public ModelAndView salva(@RequestParam("nome") String nome, @Valid Motoboy motoboy,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			System.out.println(resultado.getAllErrors());
			return cadastra(motoboy);
		}
		motoboy.setCriacao(DataCriacao.geraDataHorario());
		motoboy.setFuncionario(funcionarios.encontraNomeFuncionario(nome));
		motoboys.save(motoboy);
		return new ModelAndView("redirect:/funcionario/motoboy/lista");
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar() {
		List<Motoboy> listaMotoboy = motoboys.findAll();
		ModelAndView mv = new ModelAndView("listaMotoboy");
		mv.addObject("motoboys", listaMotoboy);
		return mv;
	}
	
	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorNome(@RequestParam("nomeCompleto") String nome, Model model) {
		if (nome.isEmpty()) {
			return listar();
		} else {
			ModelAndView m = new ModelAndView("listaFuncionario");
			model.addAttribute("motoboys", funcionarios.findByNome(nome));
			model.addAttribute("nomeCompleto", nome);
			return m;
		}
	}

	// Lista os detalhes do Motoboy clicado
	@RequestMapping("/lista/{idMotoboy}")
	public ModelAndView visualizar(@PathVariable int idMotoboy) {
		ModelAndView mv = new ModelAndView("detalhesMotoboy");
		Motoboy motoboy = motoboys.findOne(idMotoboy);
		mv.addObject("motoboy", motoboy);
		return mv;
	}

	// Metodo para editar os dados do Funcionário
	@RequestMapping("{idMotoboy}")
	public ModelAndView editar(@PathVariable int idMotoboy) {
		ModelAndView mv = new ModelAndView(FORM);
		Motoboy motoboy = motoboys.findOne(idMotoboy);
		mv.addObject(motoboy);
		return mv;
	}
}
