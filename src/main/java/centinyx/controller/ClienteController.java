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
		mv.addObject("cliente",cliente);
		return mv;
	}
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@Valid Cliente cliente, BindingResult resultado) {
		if (resultado.hasErrors()) {
			//System.out.println("Deu merda! " + resultado.getAllErrors());
			return cadastra(cliente);
		}
		cliente.setCriacao(DataCriacao.geraDataHorario());
		clientes.save(cliente);
		return new ModelAndView("redirect:/cliente/lista");
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

}
