package centinyx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import centinyx.logic.DataCriacao;
import centinyx.model.Escala;
import centinyx.repository.EscalaRepository;

@Controller
@RequestMapping(value = "/escala")
public class EscalaController {

	@Autowired
	private EscalaRepository escalas;

	private static final String FORM = "formEscala";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Escala escala) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("escala", escala);
		return mv;
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("nomeContato") String nomeContato, @Valid Escala escala,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(escala);
		}
		escala.setCriacao(DataCriacao.geraDataHorario());
		escalas.save(escala);
		return new ModelAndView("redirect:/escala/lista");
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView cadastraContato(Escala escala) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("escala", escala);
		return mv;
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(Pageable pageable) {
		Page<Escala> listaEscala = escalas.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaEscala");
		mv.addObject("escalas", listaEscala);
		int numeroPaginas = listaEscala.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}

	/*@RequestMapping(value = "/buscacnpj")
	public ModelAndView buscaPorCNPJ(@RequestParam("cnpj") String cnpj, Model model) {
		if (cnpj.isEmpty()) {
			return listar(null);
		} else {
			ModelAndView m = new ModelAndView("listaCliente");
			model.addAttribute("clientes", clientes.findByCnpj(cnpj));
			model.addAttribute("cnpj", cnpj);
			return m;
		}
	}*/

	// Metodo para editar os dados do cliente
	@RequestMapping("{idEscala}")
	public ModelAndView editar(@PathVariable int idEscala) {
		ModelAndView mv = new ModelAndView(FORM);
		Escala escala = escalas.findOne(idEscala);
		mv.addObject(escala);
		return mv;
	}

	// Metodo para deletar os dados do cliente
	@RequestMapping("cliente/deleta/{idCliente}")
	public ModelAndView deletar(@PathVariable int idEscala) {
		escalas.deleteByIdEscala(idEscala);
		return new ModelAndView("redirect:/escala/lista");
	}

}
