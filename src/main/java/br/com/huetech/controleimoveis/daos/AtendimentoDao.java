package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.Atendimento;

@Repository
public class AtendimentoDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Atendimento> all()
   {
      return manager.createQuery("select a from Atendimento a", Atendimento.class).getResultList();
   }

   public void save(Atendimento atendimento)
   {
      manager.persist(atendimento);
   }

   public Atendimento findById(Integer id)
   {
      return manager.find(Atendimento.class, id);
   }

   public void remove(Atendimento atendimento)
   {
      manager.remove(atendimento);
   }

   public void update(Atendimento atendimento)
   {
      manager.merge(atendimento);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Atendimento.class, page, max);
   }

}
