package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.Bairro;

@Repository
public class BairroDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Bairro> all()
   {
      return manager.createQuery("select b from Bairro b", Bairro.class).getResultList();
   }

   public void save(Bairro bairro)
   {
      manager.persist(bairro);
   }

   public Bairro findById(Integer id)
   {
      return manager.find(Bairro.class, id);
   }

   public void remove(Bairro bairro)
   {
      manager.remove(bairro);
   }

   public void update(Bairro bairro)
   {
      manager.merge(bairro);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Bairro.class, page, max);
   }

}
