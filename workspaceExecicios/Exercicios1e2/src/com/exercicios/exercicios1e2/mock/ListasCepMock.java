package com.exercicios.exercicios1e2.mock;

/**
 * Mock com os dados dos endereços.
 * @author Carlos Herráez
 * @version 08.11.2015
 * 
 */

import java.util.ArrayList;

import com.exercicios.exercicios1e2.model.Endereco;

public class ListasCepMock {
	
		
		private ArrayList<Endereco> listaCep = new ArrayList<Endereco>();
		
		
		public ListasCepMock(){
			
			Endereco endereco = new Endereco("20521110", "Rua Francisco Graça", "Tijuca", "Rio de Janeiro", "RJ", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("04853184", "Rua dos Taxistas", "Jardim Noronha", "Sao Paulo", "SP", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("99054500", "Rua Onofrio Lemos", "Santa Maria", "Passo Fundo", "RS", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("29134673", "Rua Bom Jesus", "Universal", "Viana", "ES", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("77585970", "Rua Conego Trindade 2", "Setor Central", "Monte do Carmo", "TO", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("58108539", "Rua das Acacias", "Parque Esperança", "Cabedelo", "PB", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("38411110", "Rua Presidente Costa e Silva", "Morada da Colina", "Uberlandia", "MG", "", "" );
			this.listaCep.add(endereco);
			endereco = new Endereco("88372558", "Rua Alvin Marcelino Bernardo", "Gravata", "Navegantes", "SC", "", "" );
			this.listaCep.add(endereco);
			
			
		}

		public ArrayList<Endereco> getListaCep() {
			return listaCep;
		}

		public void setListaCep(ArrayList<Endereco> listaCep) {
			this.listaCep = listaCep;
		}

}
