package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.huetech.controleimoveis.models.Estado;

@Entity
public class Cidade
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   @ManyToOne
   private Estado estado;

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

   public Estado getEstado()
   {
      return this.estado;
   }

   public void setEstado(Estado estado)
   {
      this.estado = estado;
   }
}
