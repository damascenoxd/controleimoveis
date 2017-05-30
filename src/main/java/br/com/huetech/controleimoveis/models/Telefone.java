package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String telefone;
   private String operadora;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getTelefone()
   {
      return this.telefone;
   }

   public void setTelefone(String telefone)
   {
      this.telefone = telefone;
   }

   public String getOperadora()
   {
      return this.operadora;
   }

   public void setOperadora(String operadora)
   {
      this.operadora = operadora;
   }
}
