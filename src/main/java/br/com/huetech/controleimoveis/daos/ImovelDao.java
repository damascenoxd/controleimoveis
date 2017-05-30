package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.Imovel;

@Repository
public class ImovelDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Imovel> all()
   {
      return manager.createQuery("select i from Imovel i", Imovel.class).getResultList();
   }

   public void save(Imovel imovel)
   {
      manager.persist(imovel);
   }

   public Imovel findById(Integer id)
   {
      return manager.find(Imovel.class, id);
   }

   public void remove(Imovel imovel)
   {
      manager.remove(imovel);
   }

   public void update(Imovel imovel)
   {
      manager.merge(imovel);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Imovel.class, page, max);
   }

}
