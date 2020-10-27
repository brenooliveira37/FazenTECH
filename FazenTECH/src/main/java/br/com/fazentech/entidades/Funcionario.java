package br.com.fazentech.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 5560911496681546013L;

	private String dataAdmissao;
	private String ultimaFerias;
	private String usuario;
	private String senha;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_animalDoente", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "animalDoente_id", referencedColumnName = "id") })
	private List<AnimalDoente> animaisDoentesList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_maquina", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "maquina_id", referencedColumnName = "id") })
	private List<Maquina> maquinasList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_ferramenta", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ferramenta_id", referencedColumnName = "id") })
	private List<Ferramenta> ferramentaList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_equipamentoProtecao", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "equipamentoProtecao_id", referencedColumnName = "id") })
	private List<EquipamentoProtecao> equipamentoProtecaoList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ordenha_funcionario", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ordenha_id", referencedColumnName = "id") })
	private List<Ordenha> ordenhasList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "muda_funcionario", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "muda_id", referencedColumnName = "id") })
	private List<Muda> mudasList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "plantio_funcionario", joinColumns = {
			@JoinColumn(name = "funcionario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "plantio_id", referencedColumnName = "id") })
	private List<Plantio> plantioList;

	public Funcionario() {
		super();
	}

	public Funcionario(String dataAdmissao, String ultimaFerias, String usuario, String senha,
			List<AnimalDoente> animaisDoentesList, List<Maquina> maquinasList, List<Ferramenta> ferramentaList,
			List<EquipamentoProtecao> equipamentoProtecaoList, List<Ordenha> ordenhasList, List<Muda> mudasList,
			List<Plantio> plantioList) {
		super();
		this.dataAdmissao = dataAdmissao;
		this.ultimaFerias = ultimaFerias;
		this.usuario = usuario;
		this.senha = senha;
		this.animaisDoentesList = animaisDoentesList;
		this.maquinasList = maquinasList;
		this.ferramentaList = ferramentaList;
		this.equipamentoProtecaoList = equipamentoProtecaoList;
		this.ordenhasList = ordenhasList;
		this.mudasList = mudasList;
		this.plantioList = plantioList;
	}

	public List<Plantio> getPlantioList() {
		return plantioList;
	}

	public void setCulturaList(List<Plantio> plantioList) {
		this.plantioList = plantioList;
	}

	public List<Muda> getMudasList() {
		return mudasList;
	}

	public void setMudasList(List<Muda> mudasList) {
		this.mudasList = mudasList;
	}

	public List<Ordenha> getOrdenhasList() {
		return ordenhasList;
	}

	public void setOrdenhasList(List<Ordenha> ordenhasList) {
		this.ordenhasList = ordenhasList;
	}

	public List<Ferramenta> getFerramentaList() {
		return ferramentaList;
	}

	public void setFerramentaList(List<Ferramenta> ferramentaList) {
		this.ferramentaList = ferramentaList;
	}

	public List<EquipamentoProtecao> getEquipamentoProtecaoList() {
		return equipamentoProtecaoList;
	}

	public void setEquipamentoProtecaoList(List<EquipamentoProtecao> equipamentoProtecaoList) {
		this.equipamentoProtecaoList = equipamentoProtecaoList;
	}

	public List<Maquina> getMaquinasList() {
		return maquinasList;
	}

	public void setMaquinasList(List<Maquina> maquinasList) {
		this.maquinasList = maquinasList;
	}

	public List<AnimalDoente> getAnimaisDoentesList() {
		return animaisDoentesList;
	}

	public void setAnimaisDoentesList(List<AnimalDoente> animaisDoentesList) {
		this.animaisDoentesList = animaisDoentesList;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getUltimaFerias() {
		return ultimaFerias;
	}

	public void setUltimaFerias(String ultimaFerias) {
		this.ultimaFerias = ultimaFerias;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return super.toString() + "Funcionario [dataAdmissao=" + dataAdmissao + ", ultimaFerias=" + ultimaFerias
				+ ", usuario=" + usuario + ", senha=" + senha + ", animaisDoentesList=" + animaisDoentesList
				+ ", maquinasList=" + maquinasList + ", ferramentaList=" + ferramentaList + ", equipamentoProtecaoList="
				+ equipamentoProtecaoList + ", ordenhasList=" + ordenhasList + ", mudasList=" + mudasList
				+ ", plantioList=" + plantioList + "]";
	}

}
