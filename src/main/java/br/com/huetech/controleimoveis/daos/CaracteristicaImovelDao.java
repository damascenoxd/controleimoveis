package br.com.huetech.controleimoveis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.huetech.controleimoveis.models.PaginatedList;
import br.com.huetech.controleimoveis.models.CaracteristicaImovel;

@Repository
public class CaracteristicaImovelDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<CaracteristicaImovel> all()
   {
      return manager.createQuery("select c from CaracteristicaImovel c", CaracteristicaImovel.class).getResultList();
   }

   public void save(CaracteristicaImovel caracteristicaImovel)
   {
      manager.persist(caracteristicaImovel);
   }

   public CaracteristicaImovel findById(Integer id)
   {
      return manager.find(CaracteristicaImovel.class, id);
   }

   public void remove(CaracteristicaImovel caracteristicaImovel)
   {
      manager.remove(caracteristicaImovel);
   }

   public void update(CaracteristicaImovel caracteristicaImovel)
   {
      manager.merge(caracteristicaImovel);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, CaracteristicaImovel.class, page, max);
   }

}
