package com.exercicios.exercicios1e2.model;

/**
 * 
 * @author Carlos Herráez
 * @version 07.11.2015
 * 
 */

public class Endereco {
	
	
	private int id;
	private String cepNumber;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	private String complemento;
	private String numero;
	
	
	public Endereco(){
		
		
	}
	
	public Endereco(String cepNumber, String rua, String bairro, String cidade, String estado, String complemento, String numero){
		this.id = 0;
		this.cepNumber = cepNumber;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.numero = numero;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCepNumber() {
		return cepNumber;
	}
	public void setCepNumber(String cepNumber) {
		this.cepNumber = cepNumber;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
		
	
}
