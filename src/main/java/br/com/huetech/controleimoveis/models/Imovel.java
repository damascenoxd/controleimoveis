package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.huetech.controleimoveis.models.CaracteristicaImovel;
import br.com.huetech.controleimoveis.models.Endereco;
import br.com.huetech.controleimoveis.models.TipoImovel;

@Entity
public class Imovel
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String modalidade;
   private String finalidade;
   private String nome;
   private String valor;
   @ManyToOne
   private Endereco endereco;
   @ManyToOne
   private TipoImovel tipoImovel;
   @ManyToOne
   private CaracteristicaImovel caracteristicaImovel;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getModalidade()
   {
      return this.modalidade;
   }

   public void setModalidade(String modalidade)
   {
      this.modalidade = modalidade;
   }

   public String getFinalidade()
   {
      return this.finalidade;
   }

   public void setFinalidade(String finalidade)
   {
      this.finalidade = finalidade;
   }

   public String getNome()
   {
      return this.nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getValor()
   {
      return this.valor;
   }

   public void setValor(String valor)
   {
      this.valor = valor;
   }

   public Endereco getEndereco()
   {
      return this.endereco;
   }

   public void setEndereco(Endereco endereco)
   {
      this.endereco = endereco;
   }

   public TipoImovel getTipoImovel()
   {
      return this.tipoImovel;
   }

   public void setTipoImovel(TipoImovel tipoImovel)
   {
      this.tipoImovel = tipoImovel;
   }

   public CaracteristicaImovel getCaracteristicaImovel()
   {
      return this.caracteristicaImovel;
   }

   public void setCaracteristicaImovel(CaracteristicaImovel caracteristicaImovel)
   {
      this.caracteristicaImovel = caracteristicaImovel;
   }
}
