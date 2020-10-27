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
@Table(name = "varejista")
public class Varejista implements Serializable {

	private static final long serialVersionUID = 4382771933599549644L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String endereco;
	private String dataUtimaCompra;
	private String detalhesCompra;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "varejista_fazenda", joinColumns = {
			@JoinColumn(name = "varejista_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "fazenda_id", referencedColumnName = "id") })
	private List<Fazenda> fazendaList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "varejista_produto", joinColumns = {
			@JoinColumn(name = "varejista_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "produto_id", referencedColumnName = "id") })
	private List<Produto> produtoList;

	public Varejista() {
		super();
	}

	

	public Varejista(long id, String nome, String endereco, String dataUtimaCompra, String detalhesCompra,
			List<Fazenda> fazendaList, List<Produto> produtoList) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.dataUtimaCompra = dataUtimaCompra;
		this.detalhesCompra = detalhesCompra;
		this.fazendaList = fazendaList;
		this.produtoList = produtoList;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataUtimaCompra() {
		return dataUtimaCompra;
	}

	public void setDataUtimaCompra(String dataUtimaCompra) {
		this.dataUtimaCompra = dataUtimaCompra;
	}

	public String getDetalhesCompra() {
		return detalhesCompra;
	}

	public void setDetalhesCompra(String detalhesCompra) {
		this.detalhesCompra = detalhesCompra;
	}

	public List<Fazenda> getFazendaList() {
		return fazendaList;
	}

	public void setFazendaList(List<Fazenda> fazendaList) {
		this.fazendaList = fazendaList;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Varejista [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", dataUtimaCompra="
				+ dataUtimaCompra + ", detalhesCompra=" + detalhesCompra + ", fazendaList=" + fazendaList
				+ ", produtoList=" + produtoList + "]";
	}

}
