package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.AnimalDoente;
import br.com.fazentech.entidades.Funcionario;

@ViewScoped
@ManagedBean(name = "animalDoenteBean")
public class AnimalDoenteBean {

	private AnimalDoente animalDoente = new AnimalDoente();
	private DaoGeneric<AnimalDoente> dao = new DaoGeneric<AnimalDoente>();
	private List<AnimalDoente> animalDoentes = new ArrayList<AnimalDoente>();

	private Funcionario funselecionado = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private DaoGeneric<Funcionario> daofun = new DaoGeneric<Funcionario>();

	private Long num;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public DaoGeneric<Funcionario> getDaofun() {
		return daofun;
	}

	public void setDaofun(DaoGeneric<Funcionario> daofun) {
		this.daofun = daofun;
	}

	public void adicionarFuncionario(Funcionario fun) {
		animalDoente.setFuncionario(fun);
	}

	public Funcionario getFunselecionado() {
		return funselecionado;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setFunselecionado(Funcionario funselecionado) {
		this.funselecionado = funselecionado;
	}

	public AnimalDoenteBean(AnimalDoente animalDoente, DaoGeneric<AnimalDoente> dao, List<AnimalDoente> animalDoentes,
			Funcionario funselecionado, List<Funcionario> funcionarios, DaoGeneric<Funcionario> daofun) {
		super();
		this.animalDoente = animalDoente;
		this.dao = dao;
		this.animalDoentes = animalDoentes;
		this.funselecionado = funselecionado;
		this.funcionarios = funcionarios;
		this.daofun = daofun;
	}

	public AnimalDoenteBean() {
		super();
	}

	public AnimalDoente getAnimalDoente() {
		return animalDoente;
	}

	public void setAnimalDoente(AnimalDoente animalDoente) {
		this.animalDoente = animalDoente;
	}

	public DaoGeneric<AnimalDoente> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<AnimalDoente> dao) {
		this.dao = dao;
	}

	public List<AnimalDoente> getAnimalDoentes() {
		return animalDoentes;
	}

	public void setAnimalDoentes(List<AnimalDoente> animalDoentes) {
		this.animalDoentes = animalDoentes;
	}

	public String salvar() {
		animalDoente = dao.merge(animalDoente);
		carregarAnimalDoentes();
		return "";
	}

	public String novo() {
		animalDoente = new AnimalDoente();
		return "";
	}

	public String delete() {
		dao.deletePorId(animalDoente);
		carregarAnimalDoentes();
		return "";
	}

	public String remover(AnimalDoente a) {
		dao.deletePorId(a);
		carregarAnimalDoentes();
		return "";
	}

	@PostConstruct
	private void carregarAnimalDoentes() {
		animalDoentes = dao.getListEntenty(AnimalDoente.class);
		funcionarios = daofun.getListEntenty(Funcionario.class);
	}

}
