package centinyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import centinyx.model.Alocacao;
import centinyx.repository.AlocacaoRepository;

@Controller
@RequestMapping(value = "/pedido/alocacao")
public class AlocacaoController {

	@Autowired
	private AlocacaoRepository alocacoes;
	
	@RequestMapping(value = "/lista")
	public ModelAndView listaAlocacao(@PageableDefault(size = 1) Pageable pageable) {
		Page<Alocacao> listaAlocacao = alocacoes.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaAlocacao");
		mv.addObject("alocacoes", listaAlocacao);
		int numeroPaginas = listaAlocacao.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}
}
