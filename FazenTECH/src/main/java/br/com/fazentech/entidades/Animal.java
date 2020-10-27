package br.com.fazentech.entidades;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Animal implements Serializable {

	private static final long serialVersionUID = 2011857243482108633L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String identificacaoNominal;
	private String dataNascimento;

	public Animal() {
		super();
	}

	public Animal(Long id, String identificacaoNominal, String dataNascimento) {
		super();
		this.id = id;
		this.identificacaoNominal = identificacaoNominal;
		this.dataNascimento = dataNascimento;
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

	public String getIdentificacaoNominal() {
		return identificacaoNominal;
	}

	public void setIdentificacaoNominal(String identificacaoNominal) {
		this.identificacaoNominal = identificacaoNominal;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", identificacaoNominal=" + identificacaoNominal + ", dataNascimento="
				+ dataNascimento + "]";
	}

}