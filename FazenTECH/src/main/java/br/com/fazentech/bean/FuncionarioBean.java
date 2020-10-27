package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Funcionario;

@ViewScoped
@ManagedBean(name = "funcionarioBean")
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private DaoGeneric<Funcionario> dao = new DaoGeneric<Funcionario>();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public FuncionarioBean() {
		super();
	}

	public FuncionarioBean(Funcionario funcionario, DaoGeneric<Funcionario> dao, List<Funcionario> funcionarios) {
		super();
		this.funcionario = funcionario;
		this.dao = dao;
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public DaoGeneric<Funcionario> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Funcionario> dao) {
		this.dao = dao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String salvar() {
		funcionario = dao.merge(funcionario);
		carregarFuncionarios();
		return "";
	}

	public String novo() {
		funcionario = new Funcionario();
		return "";
	}

	public String delete() {
		dao.deletePorId(funcionario);
		carregarFuncionarios();
		return "";
	}

	public String remover(Funcionario f) {
		dao.deletePorId(f);
		carregarFuncionarios();
		return "";
	}

	@PostConstruct
	private void carregarFuncionarios() {
		funcionarios = dao.getListEntenty(Funcionario.class);
	}

}
