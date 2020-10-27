package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Muda;
import br.com.fazentech.entidades.Plantio;

@ViewScoped
@ManagedBean(name = "plantioBean")
public class PlantioBean {

	private Plantio plantio = new Plantio();
	private DaoGeneric<Plantio> dao = new DaoGeneric<Plantio>();
	private List<Plantio> plantios = new ArrayList<Plantio>();

	private Muda mudaselecionada = new Muda();
	private DaoGeneric<Muda> daoMuda = new DaoGeneric<Muda>();
	private List<Muda> mudas = new ArrayList<Muda>();

	public PlantioBean(Plantio plantio, DaoGeneric<Plantio> dao, List<Plantio> plantios) {
		super();
		this.plantio = plantio;
		this.dao = dao;
		this.plantios = plantios;
	}

	public PlantioBean() {
		super();
	}

	public Muda getMudaselecionada() {
		return mudaselecionada;
	}

	public void setMudaselecionada(Muda mudaselecionada) {
		this.mudaselecionada = mudaselecionada;
	}

	public DaoGeneric<Muda> getDaoMuda() {
		return daoMuda;
	}

	public void setDaoMuda(DaoGeneric<Muda> daoMuda) {
		this.daoMuda = daoMuda;
	}

	public List<Muda> getMudas() {
		return mudas;
	}

	public void setMudas(List<Muda> mudas) {
		this.mudas = mudas;
	}

	public Plantio getPlantio() {
		return plantio;
	}

	public void setPlantio(Plantio plantio) {
		this.plantio = plantio;
	}

	public DaoGeneric<Plantio> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Plantio> dao) {
		this.dao = dao;
	}

	public List<Plantio> getPlantios() {
		return plantios;
	}

	public void setPlantios(List<Plantio> plantios) {
		this.plantios = plantios;
	}

	public String salvar() {
		plantio = dao.merge(plantio);
		carregarPlantios();
		return "";
	}

	public String novo() {
		plantio = new Plantio();
		return "";
	}

	public String delete() {
		dao.deletePorId(plantio);
		carregarPlantios();
		return "";
	}

	public String remover(Plantio p) {
		dao.deletePorId(p);
		carregarPlantios();
		return "";
	}

	@PostConstruct
	public void carregarPlantios() {
		plantios = dao.getListEntenty(Plantio.class);
		mudas = daoMuda.getListEntenty(Muda.class);
	}
}
