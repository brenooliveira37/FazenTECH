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
import javax.persistence.Table;

@Entity
@Table(name = "fazenda")
public class Fazenda implements Serializable {

	private static final long serialVersionUID = -4633654543690380710L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private double areaTotal;// area em hectares
	private double areaReserva;// area em hectares
	private String localizacao;
	private String observacoes;
	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "fazenda_solo", joinColumns = {
			@JoinColumn(name = "fazenda_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "solo_id", referencedColumnName = "id") })
	private List<Solo> soloList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "varejista_fazenda", joinColumns = {
			@JoinColumn(name = "fazenda_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "varejista_id", referencedColumnName = "id") })
	private List<Varejista> varejistaList;

	public Fazenda() {
	}

	public Fazenda(long id, double areaTotal, double areaReserva, String localizacao, String observacoes, String nome,
			List<Solo> soloList, List<Varejista> varejistaList) {
		super();
		this.id = id;
		this.areaTotal = areaTotal;
		this.areaReserva = areaReserva;
		this.localizacao = localizacao;
		this.observacoes = observacoes;
		this.nome = nome;
		this.soloList = soloList;
		this.varejistaList = varejistaList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(double areaTotal) {
		this.areaTotal = areaTotal;
	}

	public double getAreaReserva() {
		return areaReserva;
	}

	public void setAreaReserva(double areaReserva) {
		this.areaReserva = areaReserva;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Solo> getSoloList() {
		return soloList;
	}

	public void setSoloList(List<Solo> soloList) {
		this.soloList = soloList;
	}

	public List<Varejista> getVarejistaList() {
		return varejistaList;
	}

	public void setVarejistaList(List<Varejista> varejistaList) {
		this.varejistaList = varejistaList;
	}

	@Override
	public String toString() {
		return "Fazenda [id=" + id + ", areaTotal=" + areaTotal + ", areaReserva=" + areaReserva + ", localizacao="
				+ localizacao + ", observacoes=" + observacoes + ", nome=" + nome + ", soloList=" + soloList
				+ ", varejistaList=" + varejistaList + "]";
	}

}
