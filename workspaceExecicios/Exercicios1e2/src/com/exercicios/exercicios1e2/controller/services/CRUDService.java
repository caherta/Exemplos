package com.exercicios.exercicios1e2.controller.services;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.exercicios.exercicios1e2.dao.CRUD;
import com.exercicios.exercicios1e2.model.Endereco;
import com.exercicios.exercicios1e2.model.MensagemCRUDJSON;
import com.exercicios.exercicios1e2.model.MensagemJSON;
import com.exercicios.exercicios1e2.model.business.ValidacoesCEP;
import com.exercicios.exercicios1e2.model.business.ValidacoesCRUD;

/**
 * 
 * @author Carlos Herr�ez
 *@version 08.11.2015
 */

@Path("/crudServices")
public class CRUDService {
	
	
	/**
	 * Servi�o para incluir um endere�o
	 * @param endereco
	 * @return
	 */
	
	@POST
	@Path("/incluirEndereco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertar(Endereco endereco){
		
		MensagemCRUDJSON resposta = null;
		
		ValidacoesCRUD valcrud = new ValidacoesCRUD();
		
		resposta = valcrud.insertar(endereco);
		
	 	return resposta.getMensagem();
	}
	
	/**
	 * Servi�o para atualizar um endere�o a partir de um id. 
	 * @param endereco
	 * @return
	 */
	@POST
	@Path("/atualizarEndereco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String atualizar(Endereco endereco){
		
		MensagemCRUDJSON resposta = null;
		
		ValidacoesCRUD valcrud = new ValidacoesCRUD();
		
		resposta = valcrud.atualizar(endereco);
		
	 	return resposta.getMensagem();
	}
	
	/**
	 * Servi�o para deletar um endere�o a partir de um id.
	 * @param endereco
	 * @return
	 */
	@POST
	@Path("/deletarEndereco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deletar(Endereco endereco){
		
			MensagemCRUDJSON resposta = null;
			
			ValidacoesCRUD valida = new ValidacoesCRUD();
			
			resposta = valida.deletar(endereco);
			
		 	return resposta.getMensagem();
	}
	
	
	/**
	 * Servi�o para consultar um endere�o a partir de um id. 
	 * @param endereco
	 * @return
	 */
	@POST
	@Path("/consultarEndereco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensagemCRUDJSON consultar(Endereco endereco){
		
			MensagemCRUDJSON resposta = null;
			
			ValidacoesCRUD valida = new ValidacoesCRUD();
			
			resposta = valida.consultar(endereco);
			
		
		 	return resposta;
	}
}
