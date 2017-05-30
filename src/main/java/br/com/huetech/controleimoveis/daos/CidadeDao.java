package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.Cidade;

@Repository
public class CidadeDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Cidade> all()
   {
      return manager.createQuery("select c from Cidade c", Cidade.class).getResultList();
   }

   public void save(Cidade cidade)
   {
      manager.persist(cidade);
   }

   public Cidade findById(Integer id)
   {
      return manager.find(Cidade.class, id);
   }

   public void remove(Cidade cidade)
   {
      manager.remove(cidade);
   }

   public void update(Cidade cidade)
   {
      manager.merge(cidade);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Cidade.class, page, max);
   }

}
