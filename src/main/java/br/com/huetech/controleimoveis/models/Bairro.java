package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.huetech.controleimoveis.models.Cidade;

@Entity
public class Bairro
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   private String zona;
   private String populacao;
   @ManyToOne
   private Cidade cidade;

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

   public String getZona()
   {
      return this.zona;
   }

   public void setZona(String zona)
   {
      this.zona = zona;
   }

   public String getPopulacao()
   {
      return this.populacao;
   }

   public void setPopulacao(String populacao)
   {
      this.populacao = populacao;
   }

   public Cidade getCidade()
   {
      return this.cidade;
   }

   public void setCidade(Cidade cidade)
   {
      this.cidade = cidade;
   }
}
