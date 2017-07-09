package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.Estado;

@Repository
public class EstadoDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Estado> all()
   {
      return manager.createQuery("select e from Estado e", Estado.class).getResultList();
   }

   public void save(Estado estado)
   {
      manager.persist(estado);
   }

   public Estado findById(Integer id)
   {
      return manager.find(Estado.class, id);
   }

   public void remove(Estado estado)
   {
      manager.remove(estado);
   }

   public void update(Estado estado)
   {
      manager.merge(estado);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Estado.class, page, max);
   }

}
