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

import br.com.huetech.controleimoveis.models.Imovel;
import br.com.huetech.controleimoveis.repositories.CaracteristicaImovelRepository;
import br.com.huetech.controleimoveis.repositories.EnderecoRepository;
import br.com.huetech.controleimoveis.repositories.ImovelRepository;
import br.com.huetech.controleimoveis.repositories.TipoImovelRepository;

@Controller
@RequestMapping("/imovel")
@Transactional
public class ImovelController {

	@Autowired
	private ImovelRepository imovelRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TipoImovelRepository tipoImovelRepository;
	@Autowired
	private CaracteristicaImovelRepository caracteristicaImovelRepository;

	@RequestMapping("/form")
	public ModelAndView form(Imovel imovel) {
		ModelAndView modelAndView = new ModelAndView("imovel/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("enderecoList", enderecoRepository.findAll());
		modelAndView.addObject("tipoImovelList", tipoImovelRepository.findAll());
		modelAndView.addObject("caracteristicaImovelList", caracteristicaImovelRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Imovel imovel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(imovel);
		}
		imovelRepository.save(imovel);
		return new ModelAndView("redirect:/imovel");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("imovel/form-update");
		modelAndView.addObject("imovel", imovelRepository.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}

	// TODO PAGINAÇÃO
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("imovel/list");
		modelAndView.addObject("findAll", imovelRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Imovel imovel = imovelRepository.findById(id);
		imovelRepository.delete(imovel);
		return "redirect:/imovel";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Imovel imovel, BindingResult bindingResult) {
		imovel.setId(id);
		if (bindingResult.hasErrors()) {
			return loadFormDependencies(new ModelAndView("imovel/form-update"));
		}
		imovelRepository.save(imovel);
		return new ModelAndView("redirect:/imovel");
	}
}
