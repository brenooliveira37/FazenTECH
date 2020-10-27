package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.VacaLeiteira;

@ViewScoped
@ManagedBean(name = "vacaLeiteiraBean")
public class VacaLeiteiraBean {

	private VacaLeiteira vaca = new VacaLeiteira();
	private DaoGeneric<VacaLeiteira> dao = new DaoGeneric<VacaLeiteira>();
	private List<VacaLeiteira> vacas = new ArrayList<VacaLeiteira>();

	public VacaLeiteiraBean() {
		super();
	}

	public VacaLeiteiraBean(VacaLeiteira vaca, DaoGeneric<VacaLeiteira> dao, List<VacaLeiteira> vacas) {
		super();
		this.vaca = vaca;
		this.dao = dao;
		this.vacas = vacas;
	}

	public VacaLeiteira getVaca() {
		return vaca;
	}

	public void setVaca(VacaLeiteira vaca) {
		this.vaca = vaca;
	}

	public DaoGeneric<VacaLeiteira> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<VacaLeiteira> dao) {
		this.dao = dao;
	}

	public List<VacaLeiteira> getVacas() {
		return vacas;
	}

	public void setVacas(List<VacaLeiteira> vacas) {
		this.vacas = vacas;
	}

	public String salvar() {
		vaca = dao.merge(vaca);
		carregarVacas();
		return "";
	}

	public String novo() {
		vaca = new VacaLeiteira();
		return "";
	}

	public String delete() {
		dao.deletePorId(vaca);
		carregarVacas();
		return "";
	}

	public String remover(VacaLeiteira v) {
		dao.deletePorId(v);
		carregarVacas();
		return "";
	}

	@PostConstruct
	private void carregarVacas() {
		vacas = dao.getListEntenty(VacaLeiteira.class);
	}

}
