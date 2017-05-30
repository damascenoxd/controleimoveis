package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.TipoPretensao;

@Repository
public class TipoPretensaoDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<TipoPretensao> all()
   {
      return manager.createQuery("select t from TipoPretensao t", TipoPretensao.class).getResultList();
   }

   public void save(TipoPretensao tipoPretensao)
   {
      manager.persist(tipoPretensao);
   }

   public TipoPretensao findById(Integer id)
   {
      return manager.find(TipoPretensao.class, id);
   }

   public void remove(TipoPretensao tipoPretensao)
   {
      manager.remove(tipoPretensao);
   }

   public void update(TipoPretensao tipoPretensao)
   {
      manager.merge(tipoPretensao);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, TipoPretensao.class, page, max);
   }

}
