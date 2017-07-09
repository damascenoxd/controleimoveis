package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.huetech.controleimoveis.models.Bairro;

@Entity
public class Endereco
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String cep;
   private String logradouro;
   private String pontoReferencia;
   private String numero;
   private String complemento;
   @ManyToOne
   private Bairro bairro;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getCep()
   {
      return this.cep;
   }

   public void setCep(String cep)
   {
      this.cep = cep;
   }

   public String getLogradouro()
   {
      return this.logradouro;
   }

   public void setLogradouro(String logradouro)
   {
      this.logradouro = logradouro;
   }

   public String getPontoReferencia()
   {
      return this.pontoReferencia;
   }

   public void setPontoReferencia(String pontoReferencia)
   {
      this.pontoReferencia = pontoReferencia;
   }

   public String getNumero()
   {
      return this.numero;
   }

   public void setNumero(String numero)
   {
      this.numero = numero;
   }

   public String getComplemento()
   {
      return this.complemento;
   }

   public void setComplemento(String complemento)
   {
      this.complemento = complemento;
   }

   public Bairro getBairro()
   {
      return this.bairro;
   }

   public void setBairro(Bairro bairro)
   {
      this.bairro = bairro;
   }
}
