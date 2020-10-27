package br.com.fazentech.entidades;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Equipamento implements Serializable {

	private static final long serialVersionUID = -2478921552574090747L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String ultimoSetorUsar;
	private String dataAquisicao;
	private double valorCompra;
	private String durabilidadeEstimada;
	private String observacoes;

	public Equipamento() {
		super();
	}

	public Equipamento(Long id, String nome, String ultimoSetorUsar, String dataAquisicao, double valorCompra,
			String durabilidadeEstimada, String observacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.ultimoSetorUsar = ultimoSetorUsar;
		this.dataAquisicao = dataAquisicao;
		this.valorCompra = valorCompra;
		this.durabilidadeEstimada = durabilidadeEstimada;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoSetorUsar() {
		return ultimoSetorUsar;
	}

	public void setUltimoSetorUsar(String ultimoSetorUsar) {
		this.ultimoSetorUsar = ultimoSetorUsar;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getDurabilidadeEstimada() {
		return durabilidadeEstimada;
	}

	public void setDurabilidadeEstimada(String durabilidadeEstimada) {
		this.durabilidadeEstimada = durabilidadeEstimada;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", nome=" + nome + ", ultimoSetorUsar=" + ultimoSetorUsar + ", dataAquisicao="
				+ dataAquisicao + ", valorCompra=" + valorCompra + ", durabilidadeEstimada=" + durabilidadeEstimada
				+ ", observacoes=" + observacoes + "]";
	}

}
