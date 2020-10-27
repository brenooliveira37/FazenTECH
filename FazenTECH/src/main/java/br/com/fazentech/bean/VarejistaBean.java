package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Varejista;

@ViewScoped
@ManagedBean(name = "varejistaBean")
public class VarejistaBean {

	private Varejista varejista = new Varejista();
	private DaoGeneric<Varejista> dao = new DaoGeneric<Varejista>();
	private List<Varejista> varejistas = new ArrayList<Varejista>();

	public VarejistaBean() {
		super();
	}

	public VarejistaBean(Varejista varejista, DaoGeneric<Varejista> dao, List<Varejista> varejistas) {
		super();
		this.varejista = varejista;
		this.dao = dao;
		this.varejistas = varejistas;
	}

	public Varejista getVarejista() {
		return varejista;
	}

	public void setVarejista(Varejista varejista) {
		this.varejista = varejista;
	}

	public DaoGeneric<Varejista> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Varejista> dao) {
		this.dao = dao;
	}

	public List<Varejista> getVarejistas() {
		return varejistas;
	}

	public void setVarejistas(List<Varejista> varejistas) {
		this.varejistas = varejistas;
	}

	public String salvar() {
		varejista = dao.merge(varejista);
		carregarVarejistas();
		return "";
	}

	public String novo() {
		varejista = new Varejista();
		return "";
	}

	public String delete() {
		dao.deletePorId(varejista);
		carregarVarejistas();
		return "";
	}

	public String remover(Varejista v) {
		dao.deletePorId(v);
		carregarVarejistas();
		return "";
	}

	@PostConstruct
	private void carregarVarejistas() {
		varejistas = dao.getListEntenty(Varejista.class);
	}

}
