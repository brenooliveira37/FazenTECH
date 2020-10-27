package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Produto;

@ViewScoped
@ManagedBean(name = "produtoBean")
public class ProdutoBean {

	private Produto produto = new Produto();
	private DaoGeneric<Produto> dao = new DaoGeneric<Produto>();
	private List<Produto> produtos = new ArrayList<Produto>();

	public ProdutoBean() {
		super();
	}

	public ProdutoBean(Produto produto, DaoGeneric<Produto> dao, List<Produto> produtos) {
		super();
		this.produto = produto;
		this.dao = dao;
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DaoGeneric<Produto> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Produto> dao) {
		this.dao = dao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String salvar() {
		produto = new Produto();
		carregarProdutos();
		return "";
	}

	public String novo() {
		produto = new Produto();
		return "";
	}

	public String delete() {
		dao.deletePorId(produto);
		carregarProdutos();
		return "";
	}

	public String remover(Produto p) {
		dao.deletePorId(p);
		carregarProdutos();
		return "";
	}

	@PostConstruct
	private void carregarProdutos() {
		produtos = dao.getListEntenty(Produto.class);
	}

}
