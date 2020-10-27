package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Ordenha;

@ViewScoped
@ManagedBean(name = "ordenhaBean")
public class OrdenhaBean {

	private Ordenha ordenha = new Ordenha();
	private DaoGeneric<Ordenha> dao = new DaoGeneric<Ordenha>();
	private List<Ordenha> ordenhas = new ArrayList<Ordenha>();

	public OrdenhaBean() {
		super();
	}

	public OrdenhaBean(Ordenha ordenha, DaoGeneric<Ordenha> dao, List<Ordenha> ordenhas) {
		super();
		this.ordenha = ordenha;
		this.dao = dao;
		this.ordenhas = ordenhas;
	}

	public Ordenha getOrdenha() {
		return ordenha;
	}

	public void setOrdenha(Ordenha ordenha) {
		this.ordenha = ordenha;
	}

	public DaoGeneric<Ordenha> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Ordenha> dao) {
		this.dao = dao;
	}

	public List<Ordenha> getOrdenhas() {
		return ordenhas;
	}

	public void setOrdenhas(List<Ordenha> ordenhas) {
		this.ordenhas = ordenhas;
	}

	public String salvar() {
		ordenha = dao.merge(ordenha);
		carregarOrdenhas();
		return "";
	}

	public String novo() {
		ordenha = new Ordenha();
		return "";
	}

	public String delete() {
		dao.deletePorId(ordenha);
		carregarOrdenhas();
		return "";
	}

	public String remover(Ordenha o) {
		dao.deletePorId(o);
		carregarOrdenhas();
		return "";
	}

	@PostConstruct
	private void carregarOrdenhas() {
		ordenhas = dao.getListEntenty(Ordenha.class);
	}

}
