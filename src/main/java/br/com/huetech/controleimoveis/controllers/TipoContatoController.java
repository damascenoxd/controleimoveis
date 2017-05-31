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

import br.com.huetech.controleimoveis.models.TipoContato;
import br.com.huetech.controleimoveis.repositories.TipoContatoRepository;

@Controller
@RequestMapping("/tipoContato")
@Transactional
public class TipoContatoController {

	@Autowired
	private TipoContatoRepository tipoContatoRepository;

	@RequestMapping("/form")
	public ModelAndView form(TipoContato tipoContato) {
		ModelAndView modelAndView = new ModelAndView("tipoContato/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid TipoContato tipoContato, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(tipoContato);
		}
		tipoContatoRepository.save(tipoContato);
		return new ModelAndView("redirect:/tipoContato");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("tipoContato/form-update");
		modelAndView.addObject("tipoContato", tipoContatoRepository.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("tipoContato/list");
		// modelAndView.addObject("paginatedList",
		// tipoContatoDao.paginated(page, 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		TipoContato tipoContato = tipoContatoRepository.findById(id);
		tipoContatoRepository.delete(tipoContato);
		return "redirect:/tipoContato";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid TipoContato tipoContato,
			BindingResult bindingResult) {
		tipoContato.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("tipoContato/form-update");
		}
		tipoContatoRepository.save(tipoContato);
		return new ModelAndView("redirect:/tipoContato");
	}
}
