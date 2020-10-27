package br.com.fazentech.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ferramenta")
public class Ferramenta extends Equipamento {

	private static final long serialVersionUID = -8691753481000255179L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionario_ferramenta", joinColumns = {
			@JoinColumn(name = "ferramenta_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "funcionario_id", referencedColumnName = "id") })
	private Funcionario funcionarioResponsavel;

	public Ferramenta() {
		super();
	}

	public Ferramenta(Long id, String nome, String ultimoSetorUsar, String dataAquisicao, double valorCompra,
			String durabilidadeEstimada, String observacoes) {
		super(id, nome, ultimoSetorUsar, dataAquisicao, valorCompra, durabilidadeEstimada, observacoes);
	}

	public Ferramenta(Long id, String nome, String ultimoSetorUsar, String dataAquisicao, double valorCompra,
			String durabilidadeEstimada, String observacoes, Funcionario funcionarioResponsavel) {
		super(id, nome, ultimoSetorUsar, dataAquisicao, valorCompra, durabilidadeEstimada, observacoes);
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

	@Override
	public String toString() {
		return super.toString() + "Ferramenta [funcionarioResponsavel=" + funcionarioResponsavel + "]";
	}

}
