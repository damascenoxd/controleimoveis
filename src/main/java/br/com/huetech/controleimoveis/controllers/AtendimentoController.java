package br.com.huetech.controleimoveis.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.huetech.controleimoveis.models.Atendimento;
import br.com.huetech.controleimoveis.repositories.AtendimentoRepository;
import br.com.huetech.controleimoveis.repositories.CaracteristicaImovelRepository;
import br.com.huetech.controleimoveis.repositories.ClienteRepository;
import br.com.huetech.controleimoveis.repositories.EnderecoRepository;
import br.com.huetech.controleimoveis.repositories.TipoContatoRepository;
import br.com.huetech.controleimoveis.repositories.TipoImovelRepository;
import br.com.huetech.controleimoveis.repositories.TipoPretensaoRepository;

@Controller
@RequestMapping("/atendimento")
@Transactional
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TipoImovelRepository tipoImovelRepository;
	@Autowired
	private CaracteristicaImovelRepository caracteristicaImovelRepository;
	@Autowired
	private TipoContatoRepository tipoContatoRepository;
	@Autowired
	private TipoPretensaoRepository tipoPretensaoRepository;

	@RequestMapping("/form")
	public ModelAndView form(Atendimento atendimento) {
		ModelAndView modelAndView = new ModelAndView("atendimento/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("clienteList", clienteRepository.findAll());
		modelAndView.addObject("enderecoList", enderecoRepository.findAll());
		modelAndView.addObject("tipoImovelList", tipoImovelRepository.findAll());
		modelAndView.addObject("caracteristicaImovelList", caracteristicaImovelRepository.findAll());
		modelAndView.addObject("tipoContatoList", tipoContatoRepository.findAll());
		modelAndView.addObject("tipoPretensaoList", tipoPretensaoRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Atendimento atendimento, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(atendimento);
		}
		atendimentoRepository.save(atendimento);
		return new ModelAndView("redirect:/atendimento");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("atendimento/form-update");
		modelAndView.addObject("atendimento", atendimentoRepository.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}

	// TO DO PAGINAÇÃO
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("atendimento/list");
		modelAndView.addObject("findAll", atendimentoRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Atendimento atendimento = atendimentoRepository.findById(id);
		atendimentoRepository.delete(atendimento);
		return "redirect:/atendimento";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Atendimento atendimento,
			BindingResult bindingResult) {
		atendimento.setId(id);
		if (bindingResult.hasErrors()) {
			return loadFormDependencies(new ModelAndView("atendimento/form-update"));
		}
		atendimentoRepository.save(atendimento);
		return new ModelAndView("redirect:/atendimento");
	}
}
