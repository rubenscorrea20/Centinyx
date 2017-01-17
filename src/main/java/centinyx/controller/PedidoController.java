package centinyx.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import centinyx.model.Alocacao;
import centinyx.model.AlocacaoMotoboy;
import centinyx.model.Pedido;
import centinyx.repository.AlocacaoMotoboyRepository;
import centinyx.repository.AlocacaoRepository;
import centinyx.repository.MotoboyRepository;
import centinyx.repository.PedidoRepository;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private MotoboyRepository motoboys;

	@Autowired
	private AlocacaoRepository alocacoes;

	@Autowired
	private AlocacaoMotoboyRepository alocacoesMotoboys;

	@Autowired
	private PedidoRepository pedidos;

	//@Autowired
	//private PeriodoAlocacaoRepository periodos;

	private static final String FORM = "formPedido";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Pedido pedido, Alocacao alocacao) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		//mv.addObject("escala", escala);
		return mv;
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("nomeCliente") String nomeCliente, @Valid Pedido pedido,
			BindingResult resultado, List<Alocacao> alocacao) {

		List<Integer> idAlocacao = alocacao.stream().map(Alocacao::getIdAlocacao).collect(Collectors.toList());
		if (resultado.hasErrors()) {
			return cadastra(pedido, new Alocacao());
		}

		pedido.setCriacao(DataCriacao.geraDataHorario());
		pedido.setAlocacao(alocacao);
		alocacoes.atualizaAlocacaoPedido(pedido.getIdPedido(), idAlocacao);

		try {
			pedido.setCliente(pedidos.encontraCliente(nomeCliente));
			pedidos.save(pedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView("redirect:/pedido/lista");
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView cadastraPedido(Pedido pedido, Alocacao alocacao) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		return mv;
	}

	@RequestMapping(value = "/salva/alocacao", method = RequestMethod.POST)
	public ModelAndView salvaAlocacao(@RequestParam("motoboy") List<String> motoboy, 
			@RequestParam("tipoperiodo") String periodoAlocacao, @RequestParam("nomefantasia") String cliente,
			@RequestParam("dataAlocacao") String dataAlocacao, @RequestParam("qtdeMotoboy") int qtdeMotoboy, 
			@Valid Alocacao alocacao, Pedido pedido, BindingResult resultado) {
		
		alocacao.setCriacao(DataCriacao.geraDataHorario());
		alocacao.setDataAlocacao(dataAlocacao);
		alocacao.setQuantidadeMotoboy(qtdeMotoboy);
		
		try {
			alocacao.setMotoboys(motoboys.encontraMotoboysAlocados(motoboy));
			//alocacao.setPeriodoAlocacao(periodos.encontraPeriodoAlocacao(periodoAlocacao, cliente));
			alocacoes.save(alocacao);
			if(motoboy.size() > 1){
				alocacoesMotoboys.gravaTodosMotoboysAlocados(alocacao.getIdAlocacao(), alocacao.getMotoboys());
				List<AlocacaoMotoboy> lista = alocacoesMotoboys.gravaTodosMotoboysAlocados(alocacao.getIdAlocacao(), alocacao.getMotoboys());
				System.out.println(lista);
			}
			System.out.println(alocacao.getMotoboys());
			System.out.println(motoboy.get(0));
			System.out.println(motoboy.get(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		return mv;
	}
	
	@RequestMapping(value = "/lista")
	public ModelAndView listar(Pageable pageable) {
		Page<Pedido> listaPedido = pedidos.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaPedido");
		mv.addObject("pedidos", listaPedido);
		int numeroPaginas = listaPedido.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}

	// Metodo para editar os dados do pedido
	@RequestMapping("{idpedido}")
	public ModelAndView editar(@PathVariable int idpedido) {
		ModelAndView mv = new ModelAndView(FORM);
		Pedido pedido = pedidos.findOne(idpedido);
		mv.addObject(pedido);
		return mv;
	}

	// Metodo para deletar os dados do pedido
	@RequestMapping("pedido/deleta/{idPedido}")
	public ModelAndView deletar(@PathVariable int idpedido) {
		pedidos.deleteByIdPedido(idpedido);
		return new ModelAndView("redirect:/pedido/lista");
	}

}