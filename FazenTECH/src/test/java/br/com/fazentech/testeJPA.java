package br.com.fazentech;

import javax.persistence.Persistence;

public class testeJPA {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persistence.createEntityManagerFactory("fazendabd");

	}

}
