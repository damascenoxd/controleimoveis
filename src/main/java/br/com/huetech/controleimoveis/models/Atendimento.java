package br.com.huetech.controleimoveis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.huetech.controleimoveis.models.CaracteristicaImovel;
import java.util.Date;
import br.com.huetech.controleimoveis.models.TipoContato;
import br.com.huetech.controleimoveis.models.Endereco;
import br.com.huetech.controleimoveis.models.Cliente;
import br.com.huetech.controleimoveis.models.TipoPretensao;
import br.com.huetech.controleimoveis.models.TipoImovel;

@Entity
public class Atendimento
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @ManyToOne
   private Cliente cliente;
   @ManyToOne
   private TipoContato tipoContato;
   @ManyToOne
   private TipoPretensao tipoPretensao;
   @ManyToOne
   private TipoImovel tipoImovel;
   @ManyToOne
   private Endereco endereco;
   private Date dataAtendimento;
   private Double valorPretensao;
   private Double valorProposta;
   private String observacao;
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

   public Cliente getCliente()
   {
      return this.cliente;
   }

   public void setCliente(Cliente cliente)
   {
      this.cliente = cliente;
   }

   public TipoContato getTipoContato()
   {
      return this.tipoContato;
   }

   public void setTipoContato(TipoContato tipoContato)
   {
      this.tipoContato = tipoContato;
   }

   public TipoPretensao getTipoPretensao()
   {
      return this.tipoPretensao;
   }

   public void setTipoPretensao(TipoPretensao tipoPretensao)
   {
      this.tipoPretensao = tipoPretensao;
   }

   public TipoImovel getTipoImovel()
   {
      return this.tipoImovel;
   }

   public void setTipoImovel(TipoImovel tipoImovel)
   {
      this.tipoImovel = tipoImovel;
   }

   public Endereco getEndereco()
   {
      return this.endereco;
   }

   public void setEndereco(Endereco endereco)
   {
      this.endereco = endereco;
   }

   public Date getDataAtendimento()
   {
      return this.dataAtendimento;
   }

   public void setDataAtendimento(Date dataAtendimento)
   {
      this.dataAtendimento = dataAtendimento;
   }

   public Double getValorPretensao()
   {
      return this.valorPretensao;
   }

   public void setValorPretensao(Double valorPretensao)
   {
      this.valorPretensao = valorPretensao;
   }

   public Double getValorProposta()
   {
      return this.valorProposta;
   }

   public void setValorProposta(Double valorProposta)
   {
      this.valorProposta = valorProposta;
   }

   public String getObservacao()
   {
      return this.observacao;
   }

   public void setObservacao(String observacao)
   {
      this.observacao = observacao;
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
