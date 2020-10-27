package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Maquina;

@ViewScoped
@ManagedBean(name = "maquinaBean")
public class MaquinaBean {

	private Maquina maquina = new Maquina();
	private DaoGeneric<Maquina> dao = new DaoGeneric<Maquina>();
	private List<Maquina> maquinas = new ArrayList<Maquina>();

	public MaquinaBean() {
		super();
	}

	public MaquinaBean(Maquina maquina, DaoGeneric<Maquina> dao, List<Maquina> maquinas) {
		super();
		this.maquina = maquina;
		this.dao = dao;
		this.maquinas = maquinas;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public DaoGeneric<Maquina> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Maquina> dao) {
		this.dao = dao;
	}

	public List<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public String salvar() {
		maquina = dao.merge(maquina);
		carregarMaquinas();
		return "";
	}

	public String novo() {
		maquina = new Maquina();
		return "";
	}

	public String delete() {
		dao.deletePorId(maquina);
		carregarMaquinas();
		return "";
	}

	public String remover(Maquina m) {
		dao.deletePorId(m);
		carregarMaquinas();
		return "";
	}

	@PostConstruct
	private void carregarMaquinas() {
		maquinas = dao.getListEntenty(Maquina.class);
	}
}
