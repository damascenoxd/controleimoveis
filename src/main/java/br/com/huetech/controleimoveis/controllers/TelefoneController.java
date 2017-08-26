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

import br.com.huetech.controleimoveis.models.Telefone;
import br.com.huetech.controleimoveis.repositories.TelefoneRepository;

@Controller
@RequestMapping("/telefone")
@Transactional
public class TelefoneController {

	@Autowired
	private TelefoneRepository telefoneRepository;

	@RequestMapping("/form")
	public ModelAndView form(Telefone telefone) {
		ModelAndView modelAndView = new ModelAndView("telefone/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Telefone telefone, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(telefone);
		}
		telefoneRepository.save(telefone);
		return new ModelAndView("redirect:/telefone");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("telefone/form-update");
		modelAndView.addObject("telefone", telefoneRepository.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("telefone/list");
		modelAndView.addObject("findAll", telefoneRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Telefone telefone = telefoneRepository.findById(id);
		telefoneRepository.delete(telefone);
		return "redirect:/telefone";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Telefone telefone, BindingResult bindingResult) {
		telefone.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("telefone/form-update");
		}
		telefoneRepository.save(telefone);
		return new ModelAndView("redirect:/telefone");
	}
}
