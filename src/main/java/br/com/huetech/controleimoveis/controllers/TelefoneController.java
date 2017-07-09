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

import br.com.huetech.controleimoveis.models.Telefone;
import br.com.huetech.controleimoveis.daos.TelefoneDao;

@Controller
@RequestMapping("/telefone")
@Transactional
public class TelefoneController
{

   @Autowired
   private TelefoneDao telefoneDao;

   @RequestMapping("/form")
   public ModelAndView form(Telefone telefone)
   {
      ModelAndView modelAndView = new ModelAndView("telefone/form-add");
      return modelAndView;

   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Telefone telefone, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(telefone);
      }
      telefoneDao.save(telefone);
      return new ModelAndView("redirect:/telefone");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("telefone/form-update");
      modelAndView.addObject("telefone", telefoneDao.findById(id));
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("telefone/list");
      modelAndView.addObject("paginatedList", telefoneDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Telefone telefone = telefoneDao.findById(id);
      telefoneDao.remove(telefone);
      return "redirect:/telefone";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Telefone telefone, BindingResult bindingResult)
   {
      telefone.setId(id);
      if (bindingResult.hasErrors())
      {
         return new ModelAndView("telefone/form-update");
      }
      telefoneDao.update(telefone);
      return new ModelAndView("redirect:/telefone");
   }
}
