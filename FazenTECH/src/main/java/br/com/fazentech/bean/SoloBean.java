package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
//import br.com.fazentech.entidades.Plantio;
import br.com.fazentech.entidades.Solo;

@ViewScoped
@ManagedBean(name = "soloBean")
public class SoloBean {

	private Solo solo = new Solo();
	private DaoGeneric<Solo> dao = new DaoGeneric<Solo>();
	private List<Solo> solos = new ArrayList<Solo>();

	public SoloBean() {
		super();
	}

	public SoloBean(Solo solo, DaoGeneric<Solo> dao, List<Solo> solos) {
		super();
		this.solo = solo;
		this.dao = dao;
		this.solos = solos;
	}

	public Solo getSolo() {
		return solo;
	}

	public void setSolo(Solo solo) {
		this.solo = solo;
	}

	public DaoGeneric<Solo> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Solo> dao) {
		this.dao = dao;
	}

	public List<Solo> getSolos() {
		return solos;
	}

	public String salvar() {
		solo = dao.merge(solo);
		carregarSolos();
		return "";
	}

	public String novo() {
		solo = new Solo();
		return "";
	}

	public String delete() {
		dao.deletePorId(solo);
		carregarSolos();
		return "";
	}

	public String remover(Solo s) {
		dao.deletePorId(s);
		carregarSolos();
		return "";
	}

	@PostConstruct
	public void carregarSolos() {
		solos = dao.getListEntenty(Solo.class);
	}

}