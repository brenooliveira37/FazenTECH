package br.com.fazentech.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vacaLeiteira")
public class VacaLeiteira extends Animal {

	private static final long serialVersionUID = -4633654543690380710L;

	private String origem;
	private double producaoTotal;
	private String raca;
	private String dataUltimaOrdenha;
	private String temperaturaDoLeite;
	private boolean estaInseminada;
	private String estimativaDeParto;
	private String secagemEsperada;
	private String tempoDeRuminacaoDia;
	private int numeroDePartos;
	private String descricaoDeSaudeAnimal;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ordenha_vacaLeiteira", joinColumns = {
			@JoinColumn(name = "vacaLeiteira_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ordenha_id", referencedColumnName = "id") })
	private List<Ordenha> ordenhasList;

	public VacaLeiteira() {
		super();
	}

	public VacaLeiteira(String origem, double producaoTotal, String raca, String dataUltimaOrdenha,
			String temperaturaDoLeite, boolean estaInseminada, String estimativaDeParto, String secagemEsperada,
			String tempoDeRuminacaoDia, int numeroDePartos, String descricaoDeSaudeAnimal, List<Ordenha> ordenhasList) {
		super();
		this.origem = origem;
		this.producaoTotal = producaoTotal;
		this.raca = raca;
		this.dataUltimaOrdenha = dataUltimaOrdenha;
		this.temperaturaDoLeite = temperaturaDoLeite;
		this.estaInseminada = estaInseminada;
		this.estimativaDeParto = estimativaDeParto;
		this.secagemEsperada = secagemEsperada;
		this.tempoDeRuminacaoDia = tempoDeRuminacaoDia;
		this.numeroDePartos = numeroDePartos;
		this.descricaoDeSaudeAnimal = descricaoDeSaudeAnimal;
		this.ordenhasList = ordenhasList;
	}

	public List<Ordenha> getOrdenhasList() {
		return ordenhasList;
	}

	public void setOrdenhasList(List<Ordenha> ordenhasList) {
		this.ordenhasList = ordenhasList;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public double getProducaoTotal() {
		return producaoTotal;
	}

	public void setProducaoTotal(double producaoTotal) {
		this.producaoTotal = producaoTotal;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getDataUltimaOrdenha() {
		return dataUltimaOrdenha;
	}

	public void setDataUltimaOrdenha(String dataUltimaOrdenha) {
		this.dataUltimaOrdenha = dataUltimaOrdenha;
	}

	public String getTemperaturaDoLeite() {
		return temperaturaDoLeite;
	}

	public void setTemperaturaDoLeite(String temperaturaDoLeite) {
		this.temperaturaDoLeite = temperaturaDoLeite;
	}

	public boolean isEstaInseminada() {
		return estaInseminada;
	}

	public void setEstaInseminada(boolean estaInseminada) {
		this.estaInseminada = estaInseminada;
	}

	public String getEstimativaDeParto() {
		return estimativaDeParto;
	}

	public void setEstimativaDeParto(String estimativaDeParto) {
		this.estimativaDeParto = estimativaDeParto;
	}

	public String getSecagemEsperada() {
		return secagemEsperada;
	}

	public void setSecagemEsperada(String secagemEsperada) {
		this.secagemEsperada = secagemEsperada;
	}

	public String getTempoDeRuminacaoDia() {
		return tempoDeRuminacaoDia;
	}

	public void setTempoDeRuminacaoDia(String tempoDeRuminacaoDia) {
		this.tempoDeRuminacaoDia = tempoDeRuminacaoDia;
	}

	public int getNumeroDePartos() {
		return numeroDePartos;
	}

	public void setNumeroDePartos(int numeroDePartos) {
		this.numeroDePartos = numeroDePartos;
	}

	public String getDescricaoDeSaudeAnimal() {
		return descricaoDeSaudeAnimal;
	}

	public void setDescricaoDeSaudeAnimal(String descricaoDeSaudeAnimal) {
		this.descricaoDeSaudeAnimal = descricaoDeSaudeAnimal;
	}

	@Override
	public String toString() {
		return super.toString() + "VacaLeiteira [origem=" + origem + ", producaoTotal=" + producaoTotal + ", raca="
				+ raca + ", dataUltimaOrdenha=" + dataUltimaOrdenha + ", temperaturaDoLeite=" + temperaturaDoLeite
				+ ", estaInseminada=" + estaInseminada + ", estimativaDeParto=" + estimativaDeParto
				+ ", secagemEsperada=" + secagemEsperada + ", tempoDeRuminacaoDia=" + tempoDeRuminacaoDia
				+ ", numeroDePartos=" + numeroDePartos + ", descricaoDeSaudeAnimal=" + descricaoDeSaudeAnimal
				+ ", ordenhasList=" + ordenhasList + "]";
	}

}
