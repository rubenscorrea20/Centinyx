package centinyx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping(value = "/contatocliente")
public class ContatoClienteController {

	@Autowired
	private ContatoClienteRepository contatos;

	@Autowired
	private ClienteRepository clientes;

	private static final String FORM = "formContatoCliente";

	@RequestMapping(value = "/cadastra")
	public ModelAndView cadastra(ContatoCliente contatoCliente) {
		ModelAndView mv = new ModelAndView(FORM);
		mv.addObject("contatocliente", contatoCliente);
		return mv;
	}

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ModelAndView salva(@Valid ContatoCliente contatoCliente, BindingResult resultado) {
		if (resultado.hasErrors()) {
			System.out.println(resultado.getAllErrors());
			return cadastra(contatoCliente);
		}
		contatoCliente.setCriacao(DataCriacao.geraDataHorario());
		contatos.save(contatoCliente);
		return new ModelAndView("redirect:/contatocliente/lista");
	}

	@RequestMapping(value = "/lista")
	public ModelAndView listar(@PageableDefault(size = 1) Pageable pageable) {
		Page<ContatoCliente> listaContato = contatos.findAll(pageable);
		ModelAndView mv = new ModelAndView("listaContatoCliente");
		mv.addObject("contatoClientes", listaContato);
		int numeroPaginas = listaContato.getTotalPages();
		mv.addObject("totalPaginas", numeroPaginas);
		return mv;
	}
	
	// Metodo para editar os dados do contato
		@RequestMapping("{idContatoCliente}")
		public ModelAndView editar(@PathVariable int idContatoCliente) {
			ModelAndView mv = new ModelAndView(FORM);
			ContatoCliente contato = contatos.findOne(idContatoCliente);
			mv.addObject(contato);
			return mv;
		}
	
	// Metodo para deletar os dados do contato e o cliente associado ao contato
	@RequestMapping("contatocliente/deleta/{idContatoCliente}")
	public ModelAndView deletar(@PathVariable int idContatoCliente) {
		ContatoCliente contato = contatos.findOne(idContatoCliente);
		if (contato.getCliente() == null) {
			contatos.deleteByIdContatoCliente(idContatoCliente);
			return new ModelAndView("redirect:/perfil/lista");
		} else {
			List<Cliente> cliente = contato.getCliente();
			for (Cliente c : cliente) {
				clientes.atualizaContatoCliente(c.getNomeFantasia());
			}
			contato.setCliente(null);
			contatos.deleteByIdContatoCliente(idContatoCliente);
			return new ModelAndView("redirect:/contatocliente/lista");
		}

	}
	
	@RequestMapping(value = "/busca")
	public ModelAndView buscaPorNome(@RequestParam("nomeContato") String nomeContato, Model model, Pageable pageable) {
		if (nomeContato.isEmpty()) {
			return new ModelAndView("redirect:/contatocliente/lista");
		} else {
			Page<ContatoCliente> contatoCliente = contatos.findByNomeContatoContaining(nomeContato, pageable);
			ModelAndView m = new ModelAndView("listaFuncionario");
			model.addAttribute("contato", contatoCliente);
			model.addAttribute("nomeContato", nomeContato);
			int numeroPaginas = contatoCliente.getTotalPages();
			m.addObject("totalPaginas", numeroPaginas);
			return m;
		}
	}

}
