package br.com.huetech.controleimoveis.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date dataAniversario;
	private String estadoCivil;
	private String profissao;
	private String cpf;
	private String rg;
	private Double renda;
	private Date dataCadastro;

	// "cascade = CascadeType.ALL", reponsável por criar/atualizar/remover o
	// endereço junto ao cliente
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	// TODO telefone multivalorado @OneToMany(cascade=CascadeType.ALL,
	// mappedBy="telefone")
	// http://blog.triadworks.com.br/jpa-por-que-voce-deveria-evitar-relacionamento-bidirecional
	@OneToOne(cascade = CascadeType.ALL)
	private Telefone telefone;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAniversario() {
		return this.dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Double getRenda() {
		return this.renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}
