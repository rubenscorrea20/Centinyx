package centinyx.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import centinyx.repository.AlocacaoRepository;
import centinyx.repository.PedidoRepository;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private AlocacaoRepository alocacoes;

	@Autowired
	private PedidoRepository pedidos;

	private static final String FORM = "formPedido";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Pedido pedido, Alocacao alocacao) {
		
		Random random = new Random();
		int numeroPedido = random.nextInt(1000) * 1000;
		System.out.println(numeroPedido);
		
		ModelAndView mv = new ModelAndView(FORM, "numeroPedido", numeroPedido);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		//mv.addObject("numeroPedido", numeroPedido);
		return mv;
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("nomeClientePedido") String nomeCliente, @RequestParam("numeroPedido") int numeroPedido,
			@Valid Pedido pedido, BindingResult resultado) {
		
		if (resultado.hasErrors()) {
			return cadastra(pedido, new Alocacao());
		}
		
		pedido.setCriacao(DataCriacao.geraDataHorario());
		try {
			pedido.setCliente(pedidos.encontraCliente(nomeCliente));
			pedidos.save(pedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			ArrayList<Integer> idAlocacao = alocacoes.buscaAlocacoes(numeroPedido);
			int idPedido = pedido.getIdPedido();
			alocacoes.atualizaAlocacaoPedido(idPedido, idAlocacao);
			System.out.println(idAlocacao.size());
		
		return new ModelAndView("redirect:/pedido/lista");
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView cadastraPedido(Pedido pedido, Alocacao alocacao) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		return mv;
	}
	
	@RequestMapping(value = "/lista")
	public ModelAndView listaPedido(@PageableDefault(size = 3) Pageable pageable) {
		Page<Pedido> listaPedido = pedidos.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaPedido");
		mv.addObject("pedidos", listaPedido);
		int numeroPaginas = listaPedido.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}
		
	//FALTA CRIAR DETALHES PEDIDO

	// Metodo para editar os dados do pedido
	@RequestMapping("{idPedido}/{numeroPedido}")
	public ModelAndView editar(@PathVariable int idPedido, @PathVariable int numeroPedido) {
		ModelAndView mv = new ModelAndView(FORM);
		Pedido pedido = pedidos.findOne(idPedido);
		List<Alocacao> alocacao = alocacoes.findByNumeroPedido(numeroPedido);
		mv.addObject(pedido);
		mv.addObject(alocacao);
		return mv;
	}

	// Metodo para deletar os dados do pedido
	@RequestMapping("pedido/deleta/{idPedido}")
	public ModelAndView deletar(@PathVariable int idPedido) {
		pedidos.deleteByIdPedido(idPedido);
		return new ModelAndView("redirect:/pedido/lista");
	}

}