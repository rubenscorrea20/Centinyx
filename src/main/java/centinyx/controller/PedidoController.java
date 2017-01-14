package centinyx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import centinyx.model.Pedido;
import centinyx.repository.AlocacaoRepository;
import centinyx.repository.MotoboyRepository;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	private MotoboyRepository motoboys;
	
	@Autowired
	private AlocacaoRepository alocacoes;

	private static final String FORM = "formPedido";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Pedido pedido, Alocacao alocacao) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		return mv;
	}

	/*@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("nomeContato") String nomeContato, @Valid Pedido pedido,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(pedido);
		}
		pedido.setCriacao(DataCriacao.geraDataHorario());
		//pedidos.save(pedido);
		return new ModelAndView("redirect:/pedido/lista");
	}*/
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView cadastraPedido(Pedido pedido, Alocacao alocacao) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("pedido", pedido);
		mv.addObject("alocacao", alocacao);
		return mv;
	}

	@RequestMapping(value = "/alocacao/salva", method = RequestMethod.POST)
	public ModelAndView salvaAlocacao(@RequestParam("motoboy") List<String> motoboy, @Valid Alocacao alocacao, Pedido pedido,
			BindingResult resultado) {
		alocacao.setCriacao(DataCriacao.geraDataHorario());
		try{
			for (String string : motoboy) {
				alocacao.setMotoboys(motoboys.encontraMotoboysAlocados(string));
				alocacoes.save(alocacao);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		  }
		return new ModelAndView("redirect:/pedido/cadastra");
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(Pageable pageable) {
		//Page<pedido> listapedido = pedidos.findAll(pageable);
		ModelAndView mv = new ModelAndView("listapedido");
		//mv.addObject("pedidos", listapedido);
		//int numeroPaginas = listapedido.getTotalPages();
		//mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}

	// Metodo para editar os dados do cliente
	@RequestMapping("{idpedido}")
	public ModelAndView editar(@PathVariable int idpedido) {
		ModelAndView mv = new ModelAndView(FORM);
		//pedido pedido = pedidos.findOne(idpedido);
		//mv.addObject(pedido);
		return mv;
	}

	// Metodo para deletar os dados do cliente
	@RequestMapping("pedido/deleta/{idPedido}")
	public ModelAndView deletar(@PathVariable int idpedido) {
		//pedidos.deleteByIdpedido(idpedido);
		return new ModelAndView("redirect:/pedido/lista");
	}

}
