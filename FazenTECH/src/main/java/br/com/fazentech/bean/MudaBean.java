package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Muda;

@ViewScoped
@ManagedBean(name = "mudaBean")
public class MudaBean {

	private Muda muda = new Muda();
	private DaoGeneric<Muda> dao = new DaoGeneric<Muda>();
	private List<Muda> mudas = new ArrayList<Muda>();

	public MudaBean() {
		super();
	}

	public MudaBean(Muda muda, DaoGeneric<Muda> dao, List<Muda> mudas) {
		super();
		this.muda = muda;
		this.dao = dao;
		this.mudas = mudas;
	}

	public Muda getMuda() {
		return muda;
	}

	public void setMuda(Muda muda) {
		this.muda = muda;
	}

	public DaoGeneric<Muda> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Muda> dao) {
		this.dao = dao;
	}

	public List<Muda> getMudas() {
		return mudas;
	}

	public void setMudas(List<Muda> mudas) {
		this.mudas = mudas;
	}

	public String salvar() {
		muda = dao.merge(muda);
		carregarmudas();
		return "";
	}

	public String novo() {
		muda = new Muda();
		return "";
	}

	public String delete() {
		dao.deletePorId(muda);
		carregarmudas();
		return "";
	}

	public String remover(Muda m) {
		dao.deletePorId(m);
		carregarmudas();
		return "";
	}

	@PostConstruct
	private void carregarmudas() {
		mudas = dao.getListEntenty(Muda.class);
	}

}
