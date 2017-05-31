package br.com.huetech.controleimoveis.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.huetech.controleimoveis.models.Telefone;
import br.com.huetech.controleimoveis.repositories.ClienteRepository;
import br.com.huetech.controleimoveis.models.Endereco;
import br.com.huetech.controleimoveis.daos.EnderecoDao;
import br.com.huetech.controleimoveis.daos.TelefoneDao;
import br.com.huetech.controleimoveis.models.Cliente;

@Controller
@RequestMapping("/cliente")
@Transactional
public class ClienteController {

	@Autowired
	private EnderecoDao enderecoDao;
	@Autowired
	private TelefoneDao telefoneDao;

	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping("/form")
	public ModelAndView form(Cliente cliente) {
		ModelAndView modelAndView = new ModelAndView("cliente/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("enderecoList", enderecoDao.all());
		modelAndView.addObject("telefoneList", telefoneDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Cliente cliente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(cliente);
		}
		// clienteDao.save(cliente);
		clienteRepository.save(cliente);
		return new ModelAndView("redirect:/cliente");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("cliente/form-update");
		modelAndView.addObject("cliente", clienteRepository.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}

	// TO DO PAGINAÇÃO
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("cliente/list");
		// modelAndView.addObject("paginatedList", clienteDao.paginated(page,
		// 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Cliente cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente);
		return "redirect:/cliente";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Cliente cliente, BindingResult bindingResult) {
		cliente.setId(id);
		if (bindingResult.hasErrors()) {
			return loadFormDependencies(new ModelAndView("cliente/form-update"));
		}
		clienteRepository.save(cliente);
		return new ModelAndView("redirect:/cliente");
	}
}
