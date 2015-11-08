package com.exercicios.exercicios1e2.controller.services;

/**
 * 
 * @author Carlos Herr�ez
 *@version 08.11.2015
 */

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.exercicios.exercicios1e2.model.MensagemJSON;
import com.exercicios.exercicios1e2.model.business.ValidacoesCEP;


@Path("/buscaCEPServices")
public class BuscaCEPService {
	
	/**
	 * Servi�o que recebe como par�metro um objeto MensagemJSON contendo o CEP a procurar. Se for um cep valido e existe, o servi�o devolve a informa��o com o endere�o.
	 * @param cep
	 * @return
	 */
	
	@POST
	@Path("/buscaCEP")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensagemJSON enviarCEP(MensagemJSON cep){
		
			MensagemJSON resposta = null;
			
			ValidacoesCEP valida = new ValidacoesCEP();
			
			resposta = valida.validarCEP(cep);
			
		
		 	return resposta;
	}
	
	

}
