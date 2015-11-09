package com.exercicios.exercicios1e2.model.business;
/**
 * 
 * @author Carlos Herr�ez
 *@version 08.11.2015
 */
import java.sql.ResultSet;

import com.exercicios.exercicios1e2.dao.CRUD;
import com.exercicios.exercicios1e2.model.Endereco;
import com.exercicios.exercicios1e2.model.MensagemCRUDJSON;
import com.exercicios.exercicios1e2.model.MensagemJSON;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ValidacoesCRUD {

	/**
	 * M�todo que insire um endere�o novo na tabela endere�o
	 * @param endereco
	 * @return
	 */
	public MensagemCRUDJSON insertar(Endereco endereco){
		CRUD crud = null;
		try {
			MensagemCRUDJSON resposta = new MensagemCRUDJSON();
			
			// Usando o servi�o do exercicio 1 verificamos se trata de um CEP v�lido ou n�o.
			MensagemJSON output = buscaCEP(endereco);
			
		
			if(output.getErrorCode()!=1){
				
				// Verificamos que todos os campos obrigatorios foram preenchidos se n�o se informa ao usuario. 
				if(endereco.getRua().equals("") 
						|| endereco.getNumero().equals("") 
						|| endereco.getCepNumber().equals("") 
						|| endereco.getCidade().equals("") 
						|| endereco.getEstado().equals("")){
					
					resposta.setErrorCode(1);
					resposta.setMensagem("Para insertar � precisso informar: Rua, N�mero, Cep, Estado e Cidade");
				}else{
					
					// Caso todas as valida��es foram passadas se insire o endere�o na BD. 
					crud = new CRUD();
					if(crud.insert(endereco.getRua(), 
							endereco.getNumero(), 
							endereco.getCepNumber(), 
							endereco.getCidade(), 
							endereco.getEstado(), 
							endereco.getBairro(), 
							endereco.getComplemento())){
						
						resposta.setErrorCode(0);
						resposta.setMensagem("Endere�o incluido com sucesso");
						
					}
				}
			
			}else{
				resposta.setErrorCode(1);
				resposta.setMensagem(output.getMensagem());
				
			}
		
			return resposta;
			
		} catch (Exception e) {
			return null;
		}finally{
			if (crud!=null){
				crud.fecharConexao();
			}
				
			
		}
	}

		/**
		 * M�todo que atualiza um endere�o na BD		
		 * @param endereco
		 * @return
		 */
		public MensagemCRUDJSON atualizar(Endereco endereco){
			CRUD crud = null;
			try {
				MensagemJSON output = new MensagemJSON();
				output.setErrorCode(0);
				
				MensagemCRUDJSON resposta = new MensagemCRUDJSON();
				
				// Usando o servi�o do exercicio 1 verificamos se trata de um CEP v�lido ou n�o.
				if(!endereco.getCepNumber().equals("")){
					
					output = buscaCEP(endereco);
					
				}
				
				if(output.getErrorCode()!=1){
						
					// Verificamos se o JSON n�o foi enviado totalmente vazio.
					if(endereco.getRua().equals("") 
							&& endereco.getNumero().equals("") 
							&& endereco.getCepNumber().equals("") 
							&& endereco.getCidade().equals("") 
							&& endereco.getEstado().equals("") 
							&& endereco.getBairro().equals("") 
							&& endereco.getComplemento().equals("")){
						
						resposta.setErrorCode(1);
						resposta.setMensagem("Insira pelo menos um campo para atualizar");
						
					}else{
						
						// Caso todas as valida��es foram passadas se insire o endere�o na BD. 
						 crud = new CRUD();
						if(crud.update(endereco.getId(),
								endereco.getRua(), 
								endereco.getNumero(), 
								endereco.getCepNumber(), 
								endereco.getCidade(), 
								endereco.getEstado(), 
								endereco.getBairro(), 
								endereco.getComplemento())){
							
							resposta.setErrorCode(0);
							resposta.setMensagem("Endere�o atualizado com sucesso");
							
						}else{
							
							resposta.setErrorCode(1);
							resposta.setMensagem("Endere�o n�o atualizado ou n�o existe");
						}
					}
				}else{
					resposta.setErrorCode(1);
					resposta.setMensagem(output.getMensagem());
					
				}
				return resposta;
				
			} catch (Exception e) {
				return null;
			}finally{
				if (crud!=null){
					crud.fecharConexao();
				}
					
				
			}
		
		
		
		
		
	}
		
		
		/**
		 * M�todo para deletar um endere�o da BD
		 * @param endereco
		 * @return
		 */
		public MensagemCRUDJSON deletar(Endereco endereco){
			CRUD crud = null;
			try {
				
				MensagemCRUDJSON resposta = new MensagemCRUDJSON();
				 crud = new CRUD();
				// Verificamos se o id foi informado.
				if(crud.delete(endereco.getId())){
					
					resposta.setErrorCode(1);
					resposta.setMensagem("Endere�o deletado com sucesso");
				}else{
					resposta.setErrorCode(0);
					resposta.setMensagem("Endere�o n�o foi deletado ou n�o existe");
				}
				
				
				return resposta;
				
			} catch (Exception e) {
				return null;
			}finally{
				if (crud!=null){
					crud.fecharConexao();
				}
					
				
			}
		
		
		
		
		
	}
		/**
		 * M�todo que consulta um endere�o na BD
		 * @param endereco
		 * @return
		 */
		public MensagemCRUDJSON consultar(Endereco endereco){
			CRUD crud = null;
			try {
				
				MensagemCRUDJSON resposta = new MensagemCRUDJSON();
				 crud = new CRUD();
				ResultSet rs  = crud.getEndereco(endereco.getId());
				
				// Preenchemos o endere�o com a informa��o vinda da BD.
				if (rs.next()){
					endereco.setId(rs.getInt(1));
					endereco.setRua(rs.getString(2));
					endereco.setNumero(rs.getString(3));
					endereco.setCepNumber(rs.getString(4));
					endereco.setCidade(rs.getString(5));
					endereco.setEstado(rs.getString(6));
					endereco.setBairro(rs.getString(7));
					endereco.setComplemento(rs.getString(8));
				 }
				
				if(!endereco.getCepNumber().equals("")){
					resposta.setId(endereco.getId());
					resposta.setEndereco(endereco);
					resposta.setErrorCode(0);
					resposta.setMensagem("Endere�o recuperado");
				}else{
					
					resposta.setErrorCode(0);
					resposta.setMensagem("Endere�o n�o existe");
				}
				
				return resposta;
				
			} catch (Exception e) {
				return null;
			}finally{
				if (crud!=null){
					crud.fecharConexao();
				}
					
				
			}
		
		
		
		
		
	}
		
		
		/**
		 * M�todo que chama o servi�o do exercicio 1.
		 * @param endereco
		 * @return
		 * @throws Exception
		 */
		private MensagemJSON buscaCEP(Endereco endereco) throws Exception {
			MensagemJSON mjson = new MensagemJSON();
			mjson.setCepNumber(endereco.getCepNumber());
			
			ClientConfig cc = new DefaultClientConfig();
			
			cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			
			Client client = Client.create(cc);
			
			WebResource wr = client.resource("http://localhost:8080/Exercicios1e2/rest/buscaCEPServices/buscaCEP");
			
			ClientResponse response = wr.accept("application/json").type("application/json").post(ClientResponse.class, mjson);
			
			if(response.getStatus() != 200){
				
				throw new Exception("Erro na conex�o");
				
				
			}
			
			MensagemJSON output = response.getEntity(MensagemJSON.class);
			return output;
		}
}
