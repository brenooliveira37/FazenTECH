package br.com.fazentech.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 4510113742531292293L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String tipoDoProduto;
	private String nome;
	private boolean origemAnimal;
	private double quantidadeEstoque;
	private String analiseQualidade;
	private double preco;
	private double custo;
	private String dataFabricacao;
	private String dataValidade;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "varejista_produto", joinColumns = {
			@JoinColumn(name = "produto_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "varejista_id", referencedColumnName = "id") })
	private List<Varejista> varejistaList;

	public Produto() {
		super();
	}

	public Produto(long id, String tipoDoProduto, String nome, boolean origemAnimal, double quantidadeEstoque,
			String analiseQualidade, double preco, double custo, String dataFabricacao, String dataValidade,
			List<Varejista> varejistaList) {
		super();
		this.id = id;
		this.tipoDoProduto = tipoDoProduto;
		this.nome = nome;
		this.origemAnimal = origemAnimal;
		this.quantidadeEstoque = quantidadeEstoque;
		this.analiseQualidade = analiseQualidade;
		this.preco = preco;
		this.custo = custo;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.varejistaList = varejistaList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoDoProduto() {
		return tipoDoProduto;
	}

	public void setTipoDoProduto(String tipoDoProduto) {
		this.tipoDoProduto = tipoDoProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isOrigemAnimal() {
		return origemAnimal;
	}

	public void setOrigemAnimal(boolean origemAnimal) {
		this.origemAnimal = origemAnimal;
	}

	public double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getAnaliseQualidade() {
		return analiseQualidade;
	}

	public void setAnaliseQualidade(String analiseQualidade) {
		this.analiseQualidade = analiseQualidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public List<Varejista> getVarejistaList() {
		return varejistaList;
	}

	public void setVarejistaList(List<Varejista> varejistaList) {
		this.varejistaList = varejistaList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", tipoDoProduto=" + tipoDoProduto + ", nome=" + nome + ", origemAnimal="
				+ origemAnimal + ", quantidadeEstoque=" + quantidadeEstoque + ", analiseQualidade=" + analiseQualidade
				+ ", preco=" + preco + ", custo=" + custo + ", dataFabricacao=" + dataFabricacao + ", dataValidade="
				+ dataValidade + ", varejistaList=" + varejistaList + "]";
	}

}
