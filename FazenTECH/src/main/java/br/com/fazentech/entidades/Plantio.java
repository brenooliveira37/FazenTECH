package br.com.fazentech.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plantio")
public class Plantio implements Serializable {

	private static final long serialVersionUID = -2351452770860672028L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String caracteristicasPolinizacao;
	private String dataPlantio;
	private String dataColheita;
	private String estadoDaRotacao;
	private String dataUltimoControlesDePragasUsado;
	private String controlesDePragasUsado;
	private String dataAdubacao;
	private String detalhesAdubacao;
	private double quantidadeProduzida;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "plantio_muda", joinColumns = {
			@JoinColumn(name = "plantio_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "muda_id", referencedColumnName = "id") })
	private Muda muda;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "plantio_funcionario", joinColumns = {
			@JoinColumn(name = "plantio_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "funcionario_id", referencedColumnName = "id") })
	private Funcionario funcionario;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "plantio_solo", joinColumns = {
			@JoinColumn(name = "plantio_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "solo_id", referencedColumnName = "id") })
	private List<Solo> soloList;

	public Plantio() {
		super();
	}

	public Plantio(long id, String caracteristicasPolinizacao, String dataPlantio, String dataColheita,
			String estadoDaRotacao, String dataUltimoControlesDePragasUsado, String controlesDePragasUsado,
			String dataAdubacao, String detalhesAdubacao, double quantidadeProduzida, Muda muda,
			Funcionario funcionario, List<Solo> soloList) {
		super();
		this.id = id;
		this.caracteristicasPolinizacao = caracteristicasPolinizacao;
		this.dataPlantio = dataPlantio;
		this.dataColheita = dataColheita;
		this.estadoDaRotacao = estadoDaRotacao;
		this.dataUltimoControlesDePragasUsado = dataUltimoControlesDePragasUsado;
		this.controlesDePragasUsado = controlesDePragasUsado;
		this.dataAdubacao = dataAdubacao;
		this.detalhesAdubacao = detalhesAdubacao;
		this.quantidadeProduzida = quantidadeProduzida;
		this.muda = muda;
		this.funcionario = funcionario;
		this.soloList = soloList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaracteristicasPolinizacao() {
		return caracteristicasPolinizacao;
	}

	public void setCaracteristicasPolinizacao(String caracteristicasPolinizacao) {
		this.caracteristicasPolinizacao = caracteristicasPolinizacao;
	}

	public String getDataPlantio() {
		return dataPlantio;
	}

	public void setDataPlantio(String dataPlantio) {
		this.dataPlantio = dataPlantio;
	}

	public String getDataColheita() {
		return dataColheita;
	}

	public void setDataColheita(String dataColheita) {
		this.dataColheita = dataColheita;
	}

	public String getEstadoDaRotacao() {
		return estadoDaRotacao;
	}

	public void setEstadoDaRotacao(String estadoDaRotacao) {
		this.estadoDaRotacao = estadoDaRotacao;
	}

	public String getDataUltimoControlesDePragasUsado() {
		return dataUltimoControlesDePragasUsado;
	}

	public void setDataUltimoControlesDePragasUsado(String dataUltimoControlesDePragasUsado) {
		this.dataUltimoControlesDePragasUsado = dataUltimoControlesDePragasUsado;
	}

	public String getControlesDePragasUsado() {
		return controlesDePragasUsado;
	}

	public void setControlesDePragasUsado(String controlesDePragasUsado) {
		this.controlesDePragasUsado = controlesDePragasUsado;
	}

	public String getDataAdubacao() {
		return dataAdubacao;
	}

	public void setDataAdubacao(String dataAdubacao) {
		this.dataAdubacao = dataAdubacao;
	}

	public String getDetalhesAdubacao() {
		return detalhesAdubacao;
	}

	public void setDetalhesAdubacao(String detalhesAdubacao) {
		this.detalhesAdubacao = detalhesAdubacao;
	}

	public double getQuantidadeProduzida() {
		return quantidadeProduzida;
	}

	public void setQuantidadeProduzida(double quantidadeProduzida) {
		this.quantidadeProduzida = quantidadeProduzida;
	}

	public Muda getMuda() {
		return muda;
	}

	public void setMuda(Muda muda) {
		this.muda = muda;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Solo> getSoloList() {
		return soloList;
	}

	public void setSoloList(List<Solo> soloList) {
		this.soloList = soloList;
	}

	@Override
	public String toString() {
		return "Plantio [id=" + id + ", caracteristicasPolinizacao=" + caracteristicasPolinizacao + ", dataPlantio="
				+ dataPlantio + ", dataColheita=" + dataColheita + ", estadoDaRotacao=" + estadoDaRotacao
				+ ", dataUltimoControlesDePragasUsado=" + dataUltimoControlesDePragasUsado + ", controlesDePragasUsado="
				+ controlesDePragasUsado + ", dataAdubacao=" + dataAdubacao + ", detalhesAdubacao=" + detalhesAdubacao
				+ ", quantidadeProduzida=" + quantidadeProduzida + ", muda=" + muda + ", funcionario=" + funcionario
				+ ", soloList=" + soloList + "]";
	}

}
