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

import br.com.huetech.controleimoveis.models.Usuario;
import br.com.huetech.controleimoveis.models.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
@Transactional
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(usuario);
		}
		usuarioRepository.save(usuario);
		return new ModelAndView("redirect:/usuario");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("usuario/form-update");
		modelAndView.addObject("usuario", usuarioRepository.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("usuario/list");
		// modelAndView.addObject("paginatedList", usuarioDao.paginated(page,
		// 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Usuario usuario = usuarioRepository.findById(id);
		usuarioRepository.delete(usuario);
		return "redirect:/usuario";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult bindingResult) {
		usuario.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("usuario/form-update");
		}
		usuarioRepository.save(usuario);
		return new ModelAndView("redirect:/usuario");
	}
}
