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
@Table(name = "solo")
public class Solo implements Serializable {

	private static final long serialVersionUID = -4633654543690380710L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String identificacaoNominal;
	private String analiseDoSolo;
	private String niveisDeCarbono;
	private String niveisDeNitrogenio;
	private String tipoDeSolo;
	private double areaManejada;// area em hectares
	private String riscoErosoes;
	private String correcoesUsadas;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "plantio_solo", joinColumns = {
			@JoinColumn(name = "solo_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "plantio_id", referencedColumnName = "id") })
	private List<Plantio> plantioList;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "fazenda_solo", joinColumns = {
			@JoinColumn(name = "solo_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "fazenda_id", referencedColumnName = "id") })
	private Fazenda fazenda;

	public Solo() {
		super();
	}

	public Solo(long id, String identificacaoNominal, String analiseDoSolo, String niveisDeCarbono,
			String niveisDeNitrogenio, String tipoDeSolo, double areaManejada, String riscoErosoes,
			String correcoesUsadas, List<Plantio> plantioList, Fazenda fazenda) {
		super();
		this.id = id;
		this.identificacaoNominal = identificacaoNominal;
		this.analiseDoSolo = analiseDoSolo;
		this.niveisDeCarbono = niveisDeCarbono;
		this.niveisDeNitrogenio = niveisDeNitrogenio;
		this.tipoDeSolo = tipoDeSolo;
		this.areaManejada = areaManejada;
		this.riscoErosoes = riscoErosoes;
		this.correcoesUsadas = correcoesUsadas;
		this.plantioList = plantioList;
		this.fazenda = fazenda;
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

	public String getAnaliseDoSolo() {
		return analiseDoSolo;
	}

	public void setAnaliseDoSolo(String analiseDoSolo) {
		this.analiseDoSolo = analiseDoSolo;
	}

	public String getNiveisDeCarbono() {
		return niveisDeCarbono;
	}

	public void setNiveisDeCarbono(String niveisDeCarbono) {
		this.niveisDeCarbono = niveisDeCarbono;
	}

	public String getNiveisDeNitrogenio() {
		return niveisDeNitrogenio;
	}

	public void setNiveisDeNitrogenio(String niveisDeNitrogenio) {
		this.niveisDeNitrogenio = niveisDeNitrogenio;
	}

	public String getTipoDeSolo() {
		return tipoDeSolo;
	}

	public void setTipoDeSolo(String tipoDeSolo) {
		this.tipoDeSolo = tipoDeSolo;
	}

	public double getAreaManejada() {
		return areaManejada;
	}

	public void setAreaManejada(double areaManejada) {
		this.areaManejada = areaManejada;
	}

	public String getRiscoErosoes() {
		return riscoErosoes;
	}

	public void setRiscoErosoes(String riscoErosoes) {
		this.riscoErosoes = riscoErosoes;
	}

	public String getCorrecoesUsadas() {
		return correcoesUsadas;
	}

	public void setCorrecoesUsadas(String correcoesUsadas) {
		this.correcoesUsadas = correcoesUsadas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Plantio> getPlantioList() {
		return plantioList;
	}

	public void setPlantioList(List<Plantio> plantioList) {
		this.plantioList = plantioList;
	}

	public Fazenda getFazenda() {
		return fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

	@Override
	public String toString() {
		return "Solo [id=" + id + ", identificacaoNominal=" + identificacaoNominal + ", analiseDoSolo=" + analiseDoSolo
				+ ", niveisDeCarbono=" + niveisDeCarbono + ", niveisDeNitrogenio=" + niveisDeNitrogenio
				+ ", tipoDeSolo=" + tipoDeSolo + ", areaManejada=" + areaManejada + ", riscoErosoes=" + riscoErosoes
				+ ", correcoesUsadas=" + correcoesUsadas + ", plantioList=" + plantioList + ", fazenda=" + fazenda
				+ "]";
	}

}