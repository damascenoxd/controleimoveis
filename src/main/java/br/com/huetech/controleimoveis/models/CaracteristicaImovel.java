package br.com.huetech.controleimoveis.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CaracteristicaImovel
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private Integer qtdeQuartos;
   private Integer qtdeSuites;
   private Integer qtdeVagasGaragem;
   private boolean dce;
   private String especificacao;
   private String tamanho;
   private String condicoesPagamento;
   private Date previsaoEntrega;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public Integer getQtdeQuartos()
   {
      return this.qtdeQuartos;
   }

   public void setQtdeQuartos(Integer qtdeQuartos)
   {
      this.qtdeQuartos = qtdeQuartos;
   }

   public Integer getQtdeSuites()
   {
      return this.qtdeSuites;
   }

   public void setQtdeSuites(Integer qtdeSuites)
   {
      this.qtdeSuites = qtdeSuites;
   }

   public Integer getQtdeVagasGaragem()
   {
      return this.qtdeVagasGaragem;
   }

   public void setQtdeVagasGaragem(Integer qtdeVagasGaragem)
   {
      this.qtdeVagasGaragem = qtdeVagasGaragem;
   }

   public boolean getDce()
   {
      return this.dce;
   }

   public void setDce(boolean dce)
   {
      this.dce = dce;
   }

   public String getEspecificacao()
   {
      return this.especificacao;
   }

   public void setEspecificacao(String especificacao)
   {
      this.especificacao = especificacao;
   }

   public String getTamanho()
   {
      return this.tamanho;
   }

   public void setTamanho(String tamanho)
   {
      this.tamanho = tamanho;
   }

   public String getCondicoesPagamento()
   {
      return this.condicoesPagamento;
   }

   public void setCondicoesPagamento(String condicoesPagamento)
   {
      this.condicoesPagamento = condicoesPagamento;
   }

   public Date getPrevisaoEntrega()
   {
      return this.previsaoEntrega;
   }

   public void setPrevisaoEntrega(Date previsaoEntrega)
   {
      this.previsaoEntrega = previsaoEntrega;
   }
}
