package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.TipoImovel;

@Repository
public class TipoImovelDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<TipoImovel> all()
   {
      return manager.createQuery("select t from TipoImovel t", TipoImovel.class).getResultList();
   }

   public void save(TipoImovel tipoImovel)
   {
      manager.persist(tipoImovel);
   }

   public TipoImovel findById(Integer id)
   {
      return manager.find(TipoImovel.class, id);
   }

   public void remove(TipoImovel tipoImovel)
   {
      manager.remove(tipoImovel);
   }

   public void update(TipoImovel tipoImovel)
   {
      manager.merge(tipoImovel);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, TipoImovel.class, page, max);
   }

}
