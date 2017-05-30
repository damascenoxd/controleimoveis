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

import br.com.huetech.controleimoveis.models.CaracteristicaImovel;
import br.com.huetech.controleimoveis.daos.CaracteristicaImovelDao;

@Controller
@RequestMapping("/caracteristicaImovel")
@Transactional
public class CaracteristicaImovelController
{

   @Autowired
   private CaracteristicaImovelDao caracteristicaImovelDao;

   @RequestMapping("/form")
   public ModelAndView form(CaracteristicaImovel caracteristicaImovel)
   {
      ModelAndView modelAndView = new ModelAndView("caracteristicaImovel/form-add");
      return modelAndView;

   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid CaracteristicaImovel caracteristicaImovel, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(caracteristicaImovel);
      }
      caracteristicaImovelDao.save(caracteristicaImovel);
      return new ModelAndView("redirect:/caracteristicaImovel");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("caracteristicaImovel/form-update");
      modelAndView.addObject("caracteristicaImovel", caracteristicaImovelDao.findById(id));
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("caracteristicaImovel/list");
      modelAndView.addObject("paginatedList", caracteristicaImovelDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      CaracteristicaImovel caracteristicaImovel = caracteristicaImovelDao.findById(id);
      caracteristicaImovelDao.remove(caracteristicaImovel);
      return "redirect:/caracteristicaImovel";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid CaracteristicaImovel caracteristicaImovel, BindingResult bindingResult)
   {
      caracteristicaImovel.setId(id);
      if (bindingResult.hasErrors())
      {
         return new ModelAndView("caracteristicaImovel/form-update");
      }
      caracteristicaImovelDao.update(caracteristicaImovel);
      return new ModelAndView("redirect:/caracteristicaImovel");
   }
}
