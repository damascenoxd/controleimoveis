package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.TipoContato;

@Repository
public class TipoContatoDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<TipoContato> all()
   {
      return manager.createQuery("select t from TipoContato t", TipoContato.class).getResultList();
   }

   public void save(TipoContato tipoContato)
   {
      manager.persist(tipoContato);
   }

   public TipoContato findById(Integer id)
   {
      return manager.find(TipoContato.class, id);
   }

   public void remove(TipoContato tipoContato)
   {
      manager.remove(tipoContato);
   }

   public void update(TipoContato tipoContato)
   {
      manager.merge(tipoContato);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, TipoContato.class, page, max);
   }

}
