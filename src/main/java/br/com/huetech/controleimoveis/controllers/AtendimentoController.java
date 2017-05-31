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

import br.com.huetech.controleimoveis.daos.AtendimentoDao;
import br.com.huetech.controleimoveis.daos.CaracteristicaImovelDao;
import br.com.huetech.controleimoveis.daos.EnderecoDao;
import br.com.huetech.controleimoveis.daos.TipoContatoDao;
import br.com.huetech.controleimoveis.daos.TipoImovelDao;
import br.com.huetech.controleimoveis.daos.TipoPretensaoDao;
import br.com.huetech.controleimoveis.models.Atendimento;
import br.com.huetech.controleimoveis.repositories.ClienteRepository;

@Controller
@RequestMapping("/atendimento")
@Transactional
public class AtendimentoController
{

   @Autowired
   private AtendimentoDao atendimentoDao;
   @Autowired
   private ClienteRepository clienteRepository;
   @Autowired
   private EnderecoDao enderecoDao;
   @Autowired
   private TipoImovelDao tipoImovelDao;
   @Autowired
   private CaracteristicaImovelDao caracteristicaImovelDao;
   @Autowired
   private TipoContatoDao tipoContatoDao;
   @Autowired
   private TipoPretensaoDao tipoPretensaoDao;

   @RequestMapping("/form")
   public ModelAndView form(Atendimento atendimento)
   {
      ModelAndView modelAndView = new ModelAndView("atendimento/form-add");
      return loadFormDependencies(modelAndView);

   }

   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("clienteList", clienteRepository.findAll());
      modelAndView.addObject("enderecoList", enderecoDao.all());
      modelAndView.addObject("tipoImovelList", tipoImovelDao.all());
      modelAndView.addObject("caracteristicaImovelList", caracteristicaImovelDao.all());
      modelAndView.addObject("tipoContatoList", tipoContatoDao.all());
      modelAndView.addObject("tipoPretensaoList", tipoPretensaoDao.all());
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Atendimento atendimento, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(atendimento);
      }
      atendimentoDao.save(atendimento);
      return new ModelAndView("redirect:/atendimento");
   }

   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("atendimento/form-update");
      modelAndView.addObject("atendimento", atendimentoDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("atendimento/list");
      modelAndView.addObject("paginatedList", atendimentoDao.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Atendimento atendimento = atendimentoDao.findById(id);
      atendimentoDao.remove(atendimento);
      return "redirect:/atendimento";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Atendimento atendimento, BindingResult bindingResult)
   {
      atendimento.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("atendimento/form-update"));
      }
      atendimentoDao.update(atendimento);
      return new ModelAndView("redirect:/atendimento");
   }
}
