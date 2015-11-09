package com.exercicios.exercicios1e2.dao;
/**
 * 
 * @author Carlos Herráez
 *@version 08.11.2015
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	
	private Connection conex;
	private ResultSet rs;
	private Statement st;
	private ConexaoDB condb;
	
	public CRUD() {
        try{
        	
        	conex = condb.getConexao();
            if(conex==null){
               throw new Exception("Erro na Conexão com BD");
            }
            st = conex.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	/**
	 * Método que insire um endereço na tabela endereco. 
	 * @param rua
	 * @param numero
	 * @param cep
	 * @param cidade
	 * @param estado
	 * @param bairro
	 * @param complemento
	 * @return
	 * @throws SQLException
	 */
	
	public boolean insert (String rua, String numero, String cep, String cidade, String estado, String bairro, String complemento) throws SQLException{
		try {
			String query = "INSERT INTO exercicios.endereco VALUES(NULL, '"
							+ rua + "', + '" 
							+ numero + "', + '" 
							+ cep + "', + '" 
							+ cidade + "', + '" 
							+ estado + "', + '" 
							+ bairro + "', + '" 
							+ complemento +"');";
			st.executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			conex.rollback();
			conex.close();
			return false;
		}
		
		
	}
	
	/**
	 * Método que atualiza um endereço na tabela endereco. 
	 * @param id
	 * @param rua
	 * @param numero
	 * @param cep
	 * @param cidade
	 * @param estado
	 * @param bairro
	 * @param complemento
	 * @return
	 * @throws SQLException
	 */
	public boolean update (int id, String rua, String numero, String cep, String cidade, String estado, String bairro, String complemento) throws SQLException{
		
		try {
			
			int contadorParametros = 0;
			
			 String query = "UPDATE exercicios.endereco SET";
					 		 
			 if(!rua.equals("")){
				 query = query.concat(" rua = '"+ rua + "'");
				 contadorParametros++;
			 }		
			 
			 if(!numero.equals("")){
				 if(contadorParametros !=0){
					 query = query.concat(",");
				 }
				 contadorParametros++;
				 query = query.concat(" numero = '"+ numero + "'");
				 
			 }
			 
			 if(!cep.equals("")){
				 if(contadorParametros !=0){
					 query = query.concat(",");
				 }
				 contadorParametros++;
				 query = query.concat(" cep = '"+ cep + "'");
			 }
			 
			 if(!cidade.equals("")){
				 if(contadorParametros !=0){
					 query = query.concat(",");
				 }
				 contadorParametros++;
				 query = query.concat(" cidade = '"+ cidade + "'");
			 }
			 
			 if(!estado.equals("")){
				 if(contadorParametros !=0){
					 query = query.concat(",");
				 }
				 contadorParametros++;
				 query = query.concat(" estado = '"+ estado + "'");
			 } 
			 
			 if(!bairro.equals("")){
				 if(contadorParametros !=0){
					 query = query.concat(",");
				 }
				 contadorParametros++;
				 query = query.concat(" bairro = '"+ bairro + "'");
			 }
			 
			 if(!complemento.equals("")){
				 if(contadorParametros !=0){
					 query = query.concat(",");
				 }
				 contadorParametros++;
				 query = query.concat(" complemento = '"+ complemento +"'");
			 }
			 
			 query = query.concat(" WHERE idENDERECO = "+ id +";");
			 
	            int r = st.executeUpdate(query);
	            if(r==0){
	            	return false;
	            }else{
	            	return true;
	            	}
			
		} catch (Exception e) {
			e.printStackTrace();
			conex.rollback();
			conex.close();
			return false;
		}
	}
	
	/**
	 * Método que consulta um endereço na tabela endereco. 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getEndereco (int id) throws SQLException{
		
			try {
				
				 String query = "SELECT * FROM exercicios.endereco WHERE idENDERECO = '"+ id +"'";
				 rs = st.executeQuery(query);
				 
				 return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	/**
	 * Método que deleta um endereço na tabela endereco. 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(int id) throws SQLException{
        try {
        	
            String query = "DELETE FROM exercicios.endereco WHERE idENDERECO = '"+ id +"'";
            st.executeUpdate(query);
            
            
            	return true;
          
            
            
        } catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	/**
	 * Método para fechar as conexões
	 */
	public void fecharConexao(){
		try {
			this.conex.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
