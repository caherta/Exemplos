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
 * @author Carlos Herráez
 *@version 08.11.2015
 */

@Path("/crudServices")
public class CRUDService {
	
	
	/**
	 * Serviço para incluir um endereço
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
	 * Serviço para atualizar um endereço a partir de um id. 
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
	 * Serviço para deletar um endereço a partir de um id.
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
	 * Serviço para consultar um endereço a partir de um id. 
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
