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

import br.com.huetech.controleimoveis.models.TipoPretensao;
import br.com.huetech.controleimoveis.repositories.TipoPretensaoRepository;

@Controller
@RequestMapping("/tipoPretensao")
@Transactional
public class TipoPretensaoController {

	@Autowired
	private TipoPretensaoRepository tipoPretensaoRepository;

	@RequestMapping("/form")
	public ModelAndView form(TipoPretensao tipoPretensao) {
		ModelAndView modelAndView = new ModelAndView("tipoPretensao/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid TipoPretensao tipoPretensao, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(tipoPretensao);
		}
		tipoPretensaoRepository.save(tipoPretensao);
		return new ModelAndView("redirect:/tipoPretensao");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("tipoPretensao/form-update");
		modelAndView.addObject("tipoPretensao", tipoPretensaoRepository.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("tipoPretensao/list");
		modelAndView.addObject("findAll", tipoPretensaoRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		TipoPretensao tipoPretensao = tipoPretensaoRepository.findById(id);
		tipoPretensaoRepository.delete(tipoPretensao);
		return "redirect:/tipoPretensao";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid TipoPretensao tipoPretensao,
			BindingResult bindingResult) {
		tipoPretensao.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("tipoPretensao/form-update");
		}
		tipoPretensaoRepository.save(tipoPretensao);
		return new ModelAndView("redirect:/tipoPretensao");
	}
}
