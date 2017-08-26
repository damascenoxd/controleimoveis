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

import br.com.huetech.controleimoveis.models.CaracteristicaImovel;
import br.com.huetech.controleimoveis.repositories.CaracteristicaImovelRepository;

@Controller
@RequestMapping("/caracteristicaImovel")
@Transactional
public class CaracteristicaImovelController {

	@Autowired
	private CaracteristicaImovelRepository caracteristicaImovelRepository;

	@RequestMapping("/form")
	public ModelAndView form(CaracteristicaImovel caracteristicaImovel) {
		ModelAndView modelAndView = new ModelAndView("caracteristicaImovel/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid CaracteristicaImovel caracteristicaImovel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(caracteristicaImovel);
		}
		caracteristicaImovelRepository.save(caracteristicaImovel);
		return new ModelAndView("redirect:/caracteristicaImovel");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("caracteristicaImovel/form-update");
		modelAndView.addObject("caracteristicaImovel", caracteristicaImovelRepository.findById(id));
		return modelAndView;
	}

	// TO DO PAGINAÇÃO
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("caracteristicaImovel/list");
		modelAndView.addObject("findAll", caracteristicaImovelRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		CaracteristicaImovel caracteristicaImovel = caracteristicaImovelRepository.findById(id);
		caracteristicaImovelRepository.delete(caracteristicaImovel);
		return "redirect:/caracteristicaImovel";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid CaracteristicaImovel caracteristicaImovel,
			BindingResult bindingResult) {
		caracteristicaImovel.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("caracteristicaImovel/form-update");
		}
		caracteristicaImovelRepository.save(caracteristicaImovel);
		return new ModelAndView("redirect:/caracteristicaImovel");
	}
}
