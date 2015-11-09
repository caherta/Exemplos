package com.exercicios.exercicios1e2.model.business;

import com.exercicios.exercicios1e2.mock.ListasCepMock;
import com.exercicios.exercicios1e2.mock.service.BuscaCEPServiceWeb;
import com.exercicios.exercicios1e2.model.Endereco;
import com.exercicios.exercicios1e2.model.MensagemJSON;

/**
 * 
 * @author Carlos Herr�ez
 * @version 08.11.2015
 */
public class ValidacoesCEP {

	/**
	 * 
	 * @param mensagem
	 * @return MensagemJSON Devolve a mensagem com o endereco se existir e com o errorCode 0, se o CEP 
	 * for inv�lido devolve uma mensagem sem o Endereco, com errorCode 1 e mensagem "CEP inv�lido" 
	 */
	public  MensagemJSON validarCEP(MensagemJSON mensagem){
		Endereco cepValido = null;
		String cep = mensagem.getCepNumber();
		MensagemJSON resposta = new MensagemJSON();
		
		ListasCepMock listas = new ListasCepMock();
		int contadorDigito = 8;
		
		// Verificamos se o cep � v�lido. 
		if(cep.length()!=8){
			resposta.setErrorCode(1);
			resposta.setMensagem("CEP inv�lido");
		}else{
			
			BuscaCEPServiceWeb buscaCep = new BuscaCEPServiceWeb();
			
			// Procuramos o cep para verificar que existe.
			while (cepValido ==null && contadorDigito!=0) {
				cepValido = buscaCep.obterEndereco(cep);	
			// Em quanto n�o exista substitu�mos o digito por 0 de direita para esquerda
				if(cepValido == null){
					
					cep = cep.substring(0,contadorDigito-1).concat(geraZeros(contadorDigito));
					--contadorDigito;
					
			// Se o cep for achado setamos na mensagem de resposta que va a devolver o nosso servi�o. 
				}else{
					
					resposta.setEndereco(cepValido);
					resposta.setErrorCode(0);
				}
			}
			if(cepValido == null){
				resposta.setErrorCode(1);
				resposta.setMensagem("CEP n�o existe");
			}
		
		}
		
		return resposta;
	}

	
	
	/**
	 * Devolve um String com o numero de 0's passado como par�metro.
	 * @param contador
	 * @return String  	
	 */
	public  String geraZeros (int contador){
		String zeros = "0"; 
		
		for (int i = 0; i < 8 - contador ; i++) {
			zeros= zeros.concat("0");
		}
		
	   return zeros;
		
	}
	
}
