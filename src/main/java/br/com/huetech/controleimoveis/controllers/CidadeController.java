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
import br.com.huetech.controleimoveis.daos.CidadeDao;
import br.com.huetech.controleimoveis.models.Cidade;
import br.com.huetech.controleimoveis.models.Estado;

@Controller
@RequestMapping("/cidade")
@Transactional
public class CidadeController
{

   @Autowired
   private CidadeDao cidadeDao;
   @Autowired
   private EstadoDao estadoDao;

   @RequestMapping("/form")
   public ModelAndView form(Cidade cidade)
   {
      ModelAndView modelAndView = new ModelAndView("cidade/form-add");
      return loadFormDependencies(modelAndView);

   }

   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("estadoList", estadoDao.all());
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Cidade cidade, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(cidade);
      }
      cidadeDao.save(cidade);
      return new ModelAndView("redirect:/cidade");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("cidade/form-update");
      modelAndView.addObject("cidade", cidadeDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("cidade/list");
      modelAndView.addObject("paginatedList", cidadeDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Cidade cidade = cidadeDao.findById(id);
      cidadeDao.remove(cidade);
      return "redirect:/cidade";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Cidade cidade, BindingResult bindingResult)
   {
      cidade.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("cidade/form-update"));
      }
      cidadeDao.update(cidade);
      return new ModelAndView("redirect:/cidade");
   }
}
