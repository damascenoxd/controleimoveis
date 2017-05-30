package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estado
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   private String sigla;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getNome()
   {
      return this.nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getSigla()
   {
      return this.sigla;
   }

   public void setSigla(String sigla)
   {
      this.sigla = sigla;
   }
}
