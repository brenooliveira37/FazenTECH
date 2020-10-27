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
@Table(name = "muda")
public class Muda implements Serializable {

	private static final long serialVersionUID = 5969461802771322574L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String identificacaoNominal;
	private String especie;
	private int quantidadeMudas;
	private String dataSemeadura;
	private String portaEnxerto; // raiz usada na enxertia
	private String gema; // broto de outra planta
	private String dataUltimaDesbrota;
	private String formasDeIrrigacao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "plantio_muda", joinColumns = {
			@JoinColumn(name = "muda_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "plantio_id", referencedColumnName = "id") })
	private Plantio plantio;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "muda_funcionario", joinColumns = {
			@JoinColumn(name = "muda_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "funcionario_id", referencedColumnName = "id") })
	private Funcionario funcionario;

	public Muda() {
		super();
	}

	public Muda(long id, String identificacaoNominal, String especie, int quantidadeMudas, String dataSemeadura,
			String portaEnxerto, String gema, String dataUltimaDesbrota, String formasDeIrrigacao, Plantio plantio,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.identificacaoNominal = identificacaoNominal;
		this.especie = especie;
		this.quantidadeMudas = quantidadeMudas;
		this.dataSemeadura = dataSemeadura;
		this.portaEnxerto = portaEnxerto;
		this.gema = gema;
		this.dataUltimaDesbrota = dataUltimaDesbrota;
		this.formasDeIrrigacao = formasDeIrrigacao;
		this.plantio = plantio;
		this.funcionario = funcionario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificacaoNominal() {
		return identificacaoNominal;
	}

	public void setIdentificacaoNominal(String identificacaoNominal) {
		this.identificacaoNominal = identificacaoNominal;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getQuantidadeMudas() {
		return quantidadeMudas;
	}

	public void setQuantidadeMudas(int quantidadeMudas) {
		this.quantidadeMudas = quantidadeMudas;
	}

	public String getDataSemeadura() {
		return dataSemeadura;
	}

	public void setDataSemeadura(String dataSemeadura) {
		this.dataSemeadura = dataSemeadura;
	}

	public String getPortaEnxerto() {
		return portaEnxerto;
	}

	public void setPortaEnxerto(String portaEnxerto) {
		this.portaEnxerto = portaEnxerto;
	}

	public String getGema() {
		return gema;
	}

	public void setGema(String gema) {
		this.gema = gema;
	}

	public String getDataUltimaDesbrota() {
		return dataUltimaDesbrota;
	}

	public void setDataUltimaDesbrota(String dataUltimaDesbrota) {
		this.dataUltimaDesbrota = dataUltimaDesbrota;
	}

	public String getFormasDeIrrigacao() {
		return formasDeIrrigacao;
	}

	public void setFormasDeIrrigacao(String formasDeIrrigacao) {
		this.formasDeIrrigacao = formasDeIrrigacao;
	}

	public Plantio getPlantio() {
		return plantio;
	}

	public void setPlantio(Plantio plantio) {
		this.plantio = plantio;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Muda [id=" + id + ", identificacaoNominal=" + identificacaoNominal + ", especie=" + especie
				+ ", quantidadeMudas=" + quantidadeMudas + ", dataSemeadura=" + dataSemeadura + ", portaEnxerto="
				+ portaEnxerto + ", gema=" + gema + ", dataUltimaDesbrota=" + dataUltimaDesbrota
				+ ", formasDeIrrigacao=" + formasDeIrrigacao + ", plantio=" + plantio + ", funcionario=" + funcionario
				+ "]";
	}

}
