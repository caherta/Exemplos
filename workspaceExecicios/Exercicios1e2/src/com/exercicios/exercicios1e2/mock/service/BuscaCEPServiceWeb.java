package com.exercicios.exercicios1e2.mock.service;

/**
 * @author Carlos Herráez
 * @version 08.11.2015
 * 
 */

import com.exercicios.exercicios1e2.mock.ListasCepMock;
import com.exercicios.exercicios1e2.model.Endereco;
import com.exercicios.exercicios1e2.model.MensagemJSON;

public class BuscaCEPServiceWeb {
	
	
	/**
	 * Método que representa a funcionalidade que obtem o endereco.
	 * @param cep Cep que procuramos
	 * @return Endereco 
	 * 
	 */
	public Endereco obterEndereco(String cep) {
		ListasCepMock listas = new ListasCepMock();
		Endereco cepValido = null;
		for (int i = 0; i < listas.getListaCep().size(); i++) {
			if(cep.equals(listas.getListaCep().get(i).getCepNumber())){					
				cepValido = listas.getListaCep().get(i);
				
			}
		}
		return cepValido;
	}	
}
