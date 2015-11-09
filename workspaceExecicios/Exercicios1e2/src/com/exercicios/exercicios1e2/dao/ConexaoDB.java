package com.exercicios.exercicios1e2.dao;
/**
 * 
 * @author Carlos Herráez
 *@version 08.11.2015
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexaoDB {
      
	/**
	 * Método para conetar a base mysql 
	 * @return
	 */
    public static Connection getConexao()
    {
        Connection conexao=null;
      
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/exercicios";
            String usuarioDB="admin";
            String passwordDB="admin";
            conexao= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
        }
        catch(Exception e)
        {
            conexao=null;
        }
        finally
        {
            return conexao;
        }
    }
}