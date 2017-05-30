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

import br.com.huetech.controleimoveis.models.Endereco;
import br.com.huetech.controleimoveis.daos.EnderecoDao;
import br.com.huetech.controleimoveis.daos.BairroDao;
import br.com.huetech.controleimoveis.models.Bairro;

@Controller
@RequestMapping("/endereco")
@Transactional
public class EnderecoController
{

   @Autowired
   private EnderecoDao enderecoDao;
   @Autowired
   private BairroDao bairroDao;

   @RequestMapping("/form")
   public ModelAndView form(Endereco endereco)
   {
      ModelAndView modelAndView = new ModelAndView("endereco/form-add");
      return loadFormDependencies(modelAndView);

   }

   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("bairroList", bairroDao.all());
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Endereco endereco, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(endereco);
      }
      enderecoDao.save(endereco);
      return new ModelAndView("redirect:/endereco");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("endereco/form-update");
      modelAndView.addObject("endereco", enderecoDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("endereco/list");
      modelAndView.addObject("paginatedList", enderecoDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Endereco endereco = enderecoDao.findById(id);
      enderecoDao.remove(endereco);
      return "redirect:/endereco";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Endereco endereco, BindingResult bindingResult)
   {
      endereco.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("endereco/form-update"));
      }
      enderecoDao.update(endereco);
      return new ModelAndView("redirect:/endereco");
   }
}
