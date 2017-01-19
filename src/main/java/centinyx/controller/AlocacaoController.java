package centinyx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import centinyx.logic.DataCriacao;
import centinyx.model.Alocacao;
import centinyx.model.Pedido;
import centinyx.repository.AlocacaoMotoboyRepository;
import centinyx.repository.AlocacaoRepository;
import centinyx.repository.MotoboyRepository;

@Controller
@RequestMapping(value = "/alocacao")
public class AlocacaoController {

	@Autowired
	private AlocacaoRepository alocacoes;
	
	@Autowired
	private AlocacaoMotoboyRepository alocacoesMotoboys;
	
	@Autowired
	private MotoboyRepository motoboys;
	
	private static final String FORM = "formPedido";
	
	@RequestMapping(value = "/lista")
	public ModelAndView listaAlocacao(@PageableDefault(size = 1) Pageable pageable) {
		Page<Alocacao> listaAlocacao = alocacoes.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaAlocacao");
		mv.addObject("alocacoes", listaAlocacao);
		int numeroPaginas = listaAlocacao.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}
	
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salvaAlocacao(@RequestParam("motoboy") List<String> motoboy, 
			@RequestParam("tipoperiodo") String periodoAlocacao, @RequestParam("numeroPedidoAlocacao") int numeroPedidoAlocacao,
			@RequestParam("dataAlocacao") String dataAlocacao, @RequestParam("qtdeMotoboy") int qtdeMotoboy, 
			@Valid Alocacao alocacao, Pedido pedido, BindingResult resultado) {
		
		alocacao.setCriacao(DataCriacao.geraDataHorario());
		alocacao.setDataAlocacao(dataAlocacao);
		alocacao.setQuantidadeMotoboy(qtdeMotoboy);
		alocacao.setNumeroPedido(numeroPedidoAlocacao);
		
		try {
			alocacao.setMotoboys(motoboys.encontraMotoboysAlocados(motoboy));
			//alocacao.setPeriodoAlocacao(periodos.encontraPeriodoAlocacao(periodoAlocacao, cliente));
			alocacoes.save(alocacao);
			
			if(motoboy.size() > 1){
				alocacoesMotoboys.gravaTodosMotoboysAlocados(alocacao.getIdAlocacao(), alocacao.getMotoboys());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		return mv;
	}
	
	// Lista os detalhes da Alocação clicada
	@RequestMapping("/lista/{idAlocacao}")
	public ModelAndView visualizarAlocacao(@PathVariable int idAlocacao) {
		ModelAndView mv = new ModelAndView("detalhesAlocacao");
		Alocacao alocacao = alocacoes.findOne(idAlocacao);
		mv.addObject("alocacao", alocacao);
		return mv;
	}
}
