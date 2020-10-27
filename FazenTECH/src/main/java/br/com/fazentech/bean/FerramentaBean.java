package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Ferramenta;

@ViewScoped
@ManagedBean(name = "ferramentaBean")
public class FerramentaBean {

	private Ferramenta ferramenta = new Ferramenta();
	private DaoGeneric<Ferramenta> dao = new DaoGeneric<Ferramenta>();
	private List<Ferramenta> ferramentas = new ArrayList<Ferramenta>();

	public FerramentaBean() {
		super();
	}

	public FerramentaBean(Ferramenta ferramenta, DaoGeneric<Ferramenta> dao, List<Ferramenta> ferramentas) {
		super();
		this.ferramenta = ferramenta;
		this.dao = dao;
		this.ferramentas = ferramentas;
	}

	public Ferramenta getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public DaoGeneric<Ferramenta> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Ferramenta> dao) {
		this.dao = dao;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public String salvar() {
		ferramenta = dao.merge(ferramenta);
		carregarFerramentas();
		return "";
	}

	public String novo() {
		ferramenta = new Ferramenta();
		return "";
	}

	public String delete() {
		dao.deletePorId(ferramenta);
		carregarFerramentas();
		return "";
	}

	public String remover(Ferramenta f) {
		dao.deletePorId(f);
		carregarFerramentas();
		return "";
	}

	@PostConstruct
	private void carregarFerramentas() {
		ferramentas = dao.getListEntenty(Ferramenta.class);
	}

}
