package com.exercicios.exercicios1e2.model;

/**
 * VO que tem a informação da mensagem que recebemos e enviamos. 
 * @author Carlos Herráez
 *@version 08.11.2015
 */

public class MensagemJSON {
	
	private String cepNumber;
	private Endereco endereco;
	private int    errorCode;	
	private String mensagem;
	public Endereco getEndereco() {
		return endereco;
	}
	
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getCepNumber() {
		return cepNumber;
	}


	public void setCepNumber(String cepNumber) {
		this.cepNumber = cepNumber;
	}
	
	
	
}
