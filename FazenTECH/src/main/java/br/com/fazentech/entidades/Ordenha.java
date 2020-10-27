package br.com.fazentech.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordenha")
public class Ordenha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String horarioIniciado;
	private double quantidadeLitros;
	private String horarioFinal;
	private String dataOrdenha;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "ordenha_vacaLeiteira", joinColumns = {
			@JoinColumn(name = "ordenha_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "vacaLeiteira_id", referencedColumnName = "id") })
	private VacaLeiteira vaca;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "ordenha_funcionario", joinColumns = {
			@JoinColumn(name = "ordenha_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "funcionario_id", referencedColumnName = "id") })
	private Funcionario funcionario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "ordenha_maquina", joinColumns = {
			@JoinColumn(name = "ordenha_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "maquina_id", referencedColumnName = "id") })
	private Maquina maquina;

	public Ordenha() {
		super();
	}

	public Ordenha(long id, String horarioIniciado, double quantidadeLitros, String horarioFinal, String dataOrdenha,
			VacaLeiteira vaca, Funcionario funcionario, Maquina maquina) {
		super();
		this.id = id;
		this.horarioIniciado = horarioIniciado;
		this.quantidadeLitros = quantidadeLitros;
		this.horarioFinal = horarioFinal;
		this.dataOrdenha = dataOrdenha;
		this.vaca = vaca;
		this.funcionario = funcionario;
		this.maquina = maquina;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHorarioIniciado() {
		return horarioIniciado;
	}

	public void setHorarioIniciado(String horarioIniciado) {
		this.horarioIniciado = horarioIniciado;
	}

	public double getQuantidadeLitros() {
		return quantidadeLitros;
	}

	public void setQuantidadeLitros(double quantidadeLitros) {
		this.quantidadeLitros = quantidadeLitros;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getDataOrdenha() {
		return dataOrdenha;
	}

	public void setDataOrdenha(String dataOrdenha) {
		this.dataOrdenha = dataOrdenha;
	}

	public VacaLeiteira getVaca() {
		return vaca;
	}

	public void setVaca(VacaLeiteira vaca) {
		this.vaca = vaca;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	@Override
	public String toString() {
		return "Ordenha [id=" + id + ", horarioIniciado=" + horarioIniciado + ", quantidadeLitros=" + quantidadeLitros
				+ ", horarioFinal=" + horarioFinal + ", dataOrdenha=" + dataOrdenha + ", vaca=" + vaca
				+ ", funcionario=" + funcionario + ", maquina=" + maquina + "]";
	}

}
