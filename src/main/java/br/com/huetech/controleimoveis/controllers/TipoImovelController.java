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

import br.com.huetech.controleimoveis.models.TipoImovel;
import br.com.huetech.controleimoveis.repositories.TipoImovelRepository;

@Controller
@RequestMapping("/tipoImovel")
@Transactional
public class TipoImovelController {

	@Autowired
	private TipoImovelRepository tipoImovelRepository;

	@RequestMapping("/form")
	public ModelAndView form(TipoImovel tipoImovel) {
		ModelAndView modelAndView = new ModelAndView("tipoImovel/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid TipoImovel tipoImovel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(tipoImovel);
		}
		tipoImovelRepository.save(tipoImovel);
		return new ModelAndView("redirect:/tipoImovel");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("tipoImovel/form-update");
		modelAndView.addObject("tipoImovel", tipoImovelRepository.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("tipoImovel/list");
		modelAndView.addObject("findAll", tipoImovelRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		TipoImovel tipoImovel = tipoImovelRepository.findById(id);
		tipoImovelRepository.delete(tipoImovel);
		return "redirect:/tipoImovel";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid TipoImovel tipoImovel,
			BindingResult bindingResult) {
		tipoImovel.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("tipoImovel/form-update");
		}
		tipoImovelRepository.save(tipoImovel);
		return new ModelAndView("redirect:/tipoImovel");
	}
}
