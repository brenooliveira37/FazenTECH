package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Fazenda;

@ViewScoped
@ManagedBean(name = "fazendaBean")
public class FazendaBean {

	private Fazenda fazenda = new Fazenda();
	private DaoGeneric<Fazenda> dao = new DaoGeneric<Fazenda>();
	private List<Fazenda> fazendas = new ArrayList<Fazenda>();

	public FazendaBean() {
		super();
	}

	public FazendaBean(Fazenda fazenda, DaoGeneric<Fazenda> dao) {
		super();
		this.fazenda = fazenda;
		this.dao = dao;
	}

	public String salvar() {
		fazenda = dao.merge(fazenda);
		carregarFazendas();
		return "";
	}

	@PostConstruct
	public void carregarFazendas() {
		fazendas = dao.getListEntenty(Fazenda.class);
	}

	public String novo() {
		fazenda = new Fazenda();
		return "";
	}

	public String delete() {
		dao.deletePorId(fazenda);
		carregarFazendas();
		return "";
	}

	public String remover(Fazenda farm) {
		dao.deletePorId(farm);
		carregarFazendas();
		return "";
	}

	public Fazenda getFazenda() {
		return fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

	public DaoGeneric<Fazenda> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Fazenda> dao) {
		this.dao = dao;
	}

	public List<Fazenda> getFazendas() {
		return fazendas;
	}

	public void setFazendas(List<Fazenda> fazendas) {
		this.fazendas = fazendas;
	}
}