package br.com.fazentech.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "maquina")
public class Maquina extends Equipamento {

	private static final long serialVersionUID = -8931524588076077904L;

	private boolean teveManutencao;
	private String ultimaRevisao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_maquina", joinColumns = {
			@JoinColumn(name = "maquina_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "funcionario_id", referencedColumnName = "id") })
	private Funcionario funcionarioResponsavel;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ordenha_maquina", joinColumns = {
			@JoinColumn(name = "maquina_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ordenha_id", referencedColumnName = "id") })
	private List<Ordenha> ordenhasList;

	public Maquina() {
		super();
	}

	public Maquina(Long id, String nome, String ultimoSetorUsar, String dataAquisicao, double valorCompra,
			String durabilidadeEstimada, String observacoes) {
		super(id, nome, ultimoSetorUsar, dataAquisicao, valorCompra, durabilidadeEstimada, observacoes);
	}

	public Maquina(boolean teveManutencao, String ultimaRevisao, Funcionario funcionarioResponsavel,
			List<Ordenha> ordenhasList) {
		super();
		this.teveManutencao = teveManutencao;
		this.ultimaRevisao = ultimaRevisao;
		this.funcionarioResponsavel = funcionarioResponsavel;
		this.ordenhasList = ordenhasList;
	}

	public Maquina(Long id, String nome, String ultimoSetorUsar, String dataAquisicao, double valorCompra,
			String durabilidadeEstimada, String observacoes, boolean teveManutencao, String ultimaRevisao,
			Funcionario funcionarioResponsavel, List<Ordenha> ordenhasList) {
		super(id, nome, ultimoSetorUsar, dataAquisicao, valorCompra, durabilidadeEstimada, observacoes);
		this.teveManutencao = teveManutencao;
		this.ultimaRevisao = ultimaRevisao;
		this.funcionarioResponsavel = funcionarioResponsavel;
		this.ordenhasList = ordenhasList;
	}

	public List<Ordenha> getOrdenhasList() {
		return ordenhasList;
	}

	public void setOrdenhasList(List<Ordenha> ordenhasList) {
		this.ordenhasList = ordenhasList;
	}

	public boolean isTeveManutencao() {
		return teveManutencao;
	}

	public void setTeveManutencao(boolean teveManutencao) {
		this.teveManutencao = teveManutencao;
	}

	public String getUltimaRevisao() {
		return ultimaRevisao;
	}

	public void setUltimaRevisao(String ultimaRevisao) {
		this.ultimaRevisao = ultimaRevisao;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	@Override
	public String toString() {
		return super.toString() + "Maquina [teveManutencao=" + teveManutencao + ", ultimaRevisao=" + ultimaRevisao
				+ ", funcionarioResponsavel=" + funcionarioResponsavel + ", ordenhasList=" + ordenhasList + "]";
	}

}
