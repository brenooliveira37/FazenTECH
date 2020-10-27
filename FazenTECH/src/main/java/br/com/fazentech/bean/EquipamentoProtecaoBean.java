package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.EquipamentoProtecao;

@ViewScoped
@ManagedBean(name = "equipamentoProtecaoBean")
public class EquipamentoProtecaoBean {

	private EquipamentoProtecao equipamentoProtecao = new EquipamentoProtecao();
	private DaoGeneric<EquipamentoProtecao> dao = new DaoGeneric<EquipamentoProtecao>();
	private List<EquipamentoProtecao> equipamentoProtecaoLista = new ArrayList<EquipamentoProtecao>();

	public EquipamentoProtecaoBean() {
		super();
	}

	public EquipamentoProtecaoBean(EquipamentoProtecao equipamentoProtecao, DaoGeneric<EquipamentoProtecao> dao,
			List<EquipamentoProtecao> equipamentoProtecaoLista) {
		super();
		this.equipamentoProtecao = equipamentoProtecao;
		this.dao = dao;
		this.equipamentoProtecaoLista = equipamentoProtecaoLista;
	}

	public EquipamentoProtecao getEquipamentoProtecao() {
		return equipamentoProtecao;
	}

	public void setEquipamentoProtecao(EquipamentoProtecao equipamentoProtecao) {
		this.equipamentoProtecao = equipamentoProtecao;
	}

	public DaoGeneric<EquipamentoProtecao> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<EquipamentoProtecao> dao) {
		this.dao = dao;
	}

	public List<EquipamentoProtecao> getEquipamentoProtecaoLista() {
		return equipamentoProtecaoLista;
	}

	public void setEquipamentoProtecaoLista(List<EquipamentoProtecao> equipamentoProtecaoLista) {
		this.equipamentoProtecaoLista = equipamentoProtecaoLista;
	}

	public String salvar() {
		equipamentoProtecao = dao.merge(equipamentoProtecao);
		carregarEquipamentoProtecaoLista();
		return "";
	}

	public String novo() {
		equipamentoProtecao = new EquipamentoProtecao();
		return "";
	}

	public String delete() {
		dao.deletePorId(equipamentoProtecao);
		carregarEquipamentoProtecaoLista();
		return "";
	}

	public String remover(EquipamentoProtecao e) {
		dao.deletePorId(e);
		carregarEquipamentoProtecaoLista();
		return "";
	}

	@PostConstruct
	public void carregarEquipamentoProtecaoLista() {
		equipamentoProtecaoLista = dao.getListEntenty(EquipamentoProtecao.class);
	}
}
