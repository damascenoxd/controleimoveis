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

import br.com.huetech.controleimoveis.daos.BairroDao;
import br.com.huetech.controleimoveis.daos.CidadeDao;
import br.com.huetech.controleimoveis.models.Bairro;

@Controller
@RequestMapping("/bairro")
@Transactional
public class BairroController
{

   @Autowired
   private BairroDao bairroDao;
   @Autowired
   private CidadeDao cidadeDao;

   @RequestMapping("/form")
   public ModelAndView form(Bairro bairro)
   {
      ModelAndView modelAndView = new ModelAndView("bairro/form-add");
      return loadFormDependencies(modelAndView);

   }

   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("cidadeList", cidadeDao.all());
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Bairro bairro, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(bairro);
      }
      bairroDao.save(bairro);
      return new ModelAndView("redirect:/bairro");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("bairro/form-update");
      modelAndView.addObject("bairro", bairroDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("bairro/list");
      modelAndView.addObject("paginatedList", bairroDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Bairro bairro = bairroDao.findById(id);
      bairroDao.remove(bairro);
      return "redirect:/bairro";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Bairro bairro, BindingResult bindingResult)
   {
      bairro.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("bairro/form-update"));
      }
      bairroDao.update(bairro);
      return new ModelAndView("redirect:/bairro");
   }
}
