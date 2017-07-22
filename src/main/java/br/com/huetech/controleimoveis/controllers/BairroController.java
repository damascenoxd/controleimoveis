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

import br.com.huetech.controleimoveis.models.Bairro;
import br.com.huetech.controleimoveis.repositories.BairroRepository;
import br.com.huetech.controleimoveis.repositories.CidadeRepository;

@Controller
@RequestMapping("/bairro")
@Transactional
public class BairroController {

	@Autowired
	private BairroRepository bairroRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	@RequestMapping("/form")
	public ModelAndView form(Bairro bairro) {
		ModelAndView modelAndView = new ModelAndView("bairro/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("cidadeList", cidadeRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Bairro bairro, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(bairro);
		}
		bairroRepository.save(bairro);
		return new ModelAndView("redirect:/bairro");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("bairro/form-update");
		modelAndView.addObject("bairro", bairroRepository.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}

	// TO DO PAGINAÇÃO
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("bairro/list");
		modelAndView.addObject("findAll", bairroRepository.findAll());
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Bairro bairro = bairroRepository.findById(id);
		bairroRepository.delete(bairro);
		return "redirect:/bairro";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Bairro bairro, BindingResult bindingResult) {
		bairro.setId(id);
		if (bindingResult.hasErrors()) {
			return loadFormDependencies(new ModelAndView("bairro/form-update"));
		}
		bairroRepository.save(bairro);
		return new ModelAndView("redirect:/bairro");
	}
}
