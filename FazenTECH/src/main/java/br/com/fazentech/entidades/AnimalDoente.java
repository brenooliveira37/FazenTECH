package br.com.fazentech.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animalDoente")
public class AnimalDoente extends Animal {

	private static final long serialVersionUID = 1L;

	private String especie;
	private String tratamentoUsado;
	private String diaInicioTratamento;
	private String diaFinalDoTratamento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_animalDoente", joinColumns = {
			@JoinColumn(name = "animalDoente_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "funcionario_id", referencedColumnName = "id") })
	private Funcionario funcionario;

	public AnimalDoente() {
		super();
	}

	public AnimalDoente(Long id, String identificacaoNominal, String dataNascimento) {
		super(id, identificacaoNominal, dataNascimento);
	}

	public AnimalDoente(String especie, String tratamentoUsado, String diaInicioTratamento, String diaFinalDoTratamento,
			Funcionario funcionario) {
		super();
		this.especie = especie;
		this.tratamentoUsado = tratamentoUsado;
		this.diaInicioTratamento = diaInicioTratamento;
		this.diaFinalDoTratamento = diaFinalDoTratamento;
		this.funcionario = funcionario;
	}

	public AnimalDoente(Long id, String identificacaoNominal, String dataNascimento, String especie,
			String tratamentoUsado, String diaInicioTratamento, String diaFinalDoTratamento, Funcionario funcionario) {
		super(id, identificacaoNominal, dataNascimento);
		this.especie = especie;
		this.tratamentoUsado = tratamentoUsado;
		this.diaInicioTratamento = diaInicioTratamento;
		this.diaFinalDoTratamento = diaFinalDoTratamento;
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getTratamentoUsado() {
		return tratamentoUsado;
	}

	public void setTratamentoUsado(String tratamentoUsado) {
		this.tratamentoUsado = tratamentoUsado;
	}

	public String getDiaInicioTratamento() {
		return diaInicioTratamento;
	}

	public void setDiaInicioTratamento(String diaInicioTratamento) {
		this.diaInicioTratamento = diaInicioTratamento;
	}

	public String getDiaFinalDoTratamento() {
		return diaFinalDoTratamento;
	}

	public void setDiaFinalDoTratamento(String diaFinalDoTratamento) {
		this.diaFinalDoTratamento = diaFinalDoTratamento;
	}

	@Override
	public String toString() {
		return super.toString() + "AnimalDoente [especie=" + especie + ", tratamentoUsado=" + tratamentoUsado
				+ ", diaInicioTratamento=" + diaInicioTratamento + ", diaFinalDoTratamento=" + diaFinalDoTratamento
				+ ", funcionario=" + funcionario + "]";
	}

}
