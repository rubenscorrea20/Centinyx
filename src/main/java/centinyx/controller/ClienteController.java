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
import centinyx.model.Cliente;
import centinyx.model.ContatoCliente;
import centinyx.repository.ClienteRepository;
import centinyx.repository.ContatoClienteRepository;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clientes;

	@Autowired
	private ContatoClienteRepository contatos;

	private static final String FORM = "formCliente";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(Cliente cliente) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salva(@RequestParam("nomeContato") String nomeContato, @Valid Cliente cliente,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return cadastra(cliente);
		}
		cliente.setCriacao(DataCriacao.geraDataHorario());
		cliente.setContatoCliente(contatos.encontraContatoCliente(nomeContato));
		clientes.save(cliente);
		return new ModelAndView("redirect:/cliente/lista");
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView cadastraContato(Cliente cliente) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping(value = "/buscacontato")
	public ModelAndView buscaContato() {
		List<ContatoCliente> listaContato = contatos.findAll();
		ModelAndView mv = new ModelAndView("listaContato");
		mv.addObject("contato", listaContato);
		return mv;
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar() {
		List<Cliente> listaCliente = clientes.findAll();
		ModelAndView mv = new ModelAndView("listaCliente");
		mv.addObject("clientes", listaCliente);
		return mv;
	}

	// Lista os detalhes do cliente clicado
	@RequestMapping("/lista/{idCliente}")
	public ModelAndView visualizar(@PathVariable int idCliente) {
		ModelAndView mv = new ModelAndView("detalhesCliente");
		Cliente cliente = clientes.findOne(idCliente);
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorNomeFantasia(@RequestParam("nomeFantasia") String nomeFantasia, Model model) {
		if (nomeFantasia.isEmpty()) {
			return listar();
		} else {
			ModelAndView m = new ModelAndView("listaCliente");
			model.addAttribute("clientes", clientes.findByNomeFantasia(nomeFantasia));
			model.addAttribute("nomeFantasia", nomeFantasia);
			return m;
		}
	}

	@RequestMapping(value = "/buscacnpj")
	public ModelAndView buscaPorCNPJ(@RequestParam("cnpj") String cnpj, Model model) {
		if (cnpj.isEmpty()) {
			return listar();
		} else {
			ModelAndView m = new ModelAndView("listaCliente");
			model.addAttribute("clientes", clientes.findByCnpj(cnpj));
			model.addAttribute("cnpj", cnpj);
			return m;
		}
	}

	// Metodo para editar os dados do cliente
	@RequestMapping("{idCliente}")
	public ModelAndView editar(@PathVariable int idCliente) {
		ModelAndView mv = new ModelAndView(FORM);
		Cliente cliente = clientes.findOne(idCliente);
		mv.addObject(cliente);
		return mv;
	}

	// Metodo para deletar os dados do cliente
	@RequestMapping("funcionario/deleta/{idCliente}")
	public ModelAndView deletar(@PathVariable int idCliente) {
		clientes.deleteByIdCliente(idCliente);
		return new ModelAndView("redirect:/cliente/lista");
	}

}
