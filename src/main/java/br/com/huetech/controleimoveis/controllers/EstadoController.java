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

import br.com.huetech.controleimoveis.daos.EstadoDao;
import br.com.huetech.controleimoveis.models.Estado;

@Controller
@RequestMapping("/estado")
@Transactional
public class EstadoController
{

   @Autowired
   private EstadoDao estadoDao;

   @RequestMapping("/form")
   public ModelAndView form(Estado estado)
   {
      ModelAndView modelAndView = new ModelAndView("estado/form-add");
      return modelAndView;

   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Estado estado, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(estado);
      }
      estadoDao.save(estado);
      return new ModelAndView("redirect:/estado");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("estado/form-update");
      modelAndView.addObject("estado", estadoDao.findById(id));
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("estado/list");
      modelAndView.addObject("paginatedList", estadoDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Estado estado = estadoDao.findById(id);
      estadoDao.remove(estado);
      return "redirect:/estado";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Estado estado, BindingResult bindingResult)
   {
      estado.setId(id);
      if (bindingResult.hasErrors())
      {
         return new ModelAndView("estado/form-update");
      }
      estadoDao.update(estado);
      return new ModelAndView("redirect:/estado");
   }
}
