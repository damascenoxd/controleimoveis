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
import br.com.huetech.controleimoveis.daos.TipoImovelDao;
import br.com.huetech.controleimoveis.models.Endereco;
import br.com.huetech.controleimoveis.models.Imovel;
import br.com.huetech.controleimoveis.daos.EnderecoDao;
import br.com.huetech.controleimoveis.daos.ImovelDao;
import br.com.huetech.controleimoveis.models.TipoImovel;

@Controller
@RequestMapping("/imovel")
@Transactional
public class ImovelController
{

   @Autowired
   private ImovelDao imovelDao;
   @Autowired
   private EnderecoDao enderecoDao;
   @Autowired
   private TipoImovelDao tipoImovelDao;
   @Autowired
   private CaracteristicaImovelDao caracteristicaImovelDao;

   @RequestMapping("/form")
   public ModelAndView form(Imovel imovel)
   {
      ModelAndView modelAndView = new ModelAndView("imovel/form-add");
      return loadFormDependencies(modelAndView);

   }

   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("enderecoList", enderecoDao.all());
      modelAndView.addObject("tipoImovelList", tipoImovelDao.all());
      modelAndView.addObject("caracteristicaImovelList", caracteristicaImovelDao.all());
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Imovel imovel, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(imovel);
      }
      imovelDao.save(imovel);
      return new ModelAndView("redirect:/imovel");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("imovel/form-update");
      modelAndView.addObject("imovel", imovelDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("imovel/list");
      modelAndView.addObject("paginatedList", imovelDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Imovel imovel = imovelDao.findById(id);
      imovelDao.remove(imovel);
      return "redirect:/imovel";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Imovel imovel, BindingResult bindingResult)
   {
      imovel.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("imovel/form-update"));
      }
      imovelDao.update(imovel);
      return new ModelAndView("redirect:/imovel");
   }
}
