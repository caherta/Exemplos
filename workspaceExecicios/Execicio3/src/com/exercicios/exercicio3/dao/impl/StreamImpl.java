package com.exercicios.exercicio3.dao.impl;
/**
 * 
 * @author Carlos Herraez
 * @version 06.11.2015
 * 	
 */
import java.util.ArrayList;
import java.util.Iterator;

import com.exercicios.exercicio3.dao.Stream;

public class StreamImpl implements Stream {
	
	private ArrayList<String> streamValue = new ArrayList<>();
	private Iterator<String> iter;
	
	
	public StreamImpl(String valor){
	
		for (int i = 0; i < valor.length(); i++) {
			String digito = valor.substring(i, i+1);
			
			this.streamValue.add(digito);		
			}
		
		this.iter =  this.streamValue.iterator();
	}

	
	/**
	 *  	
	 * @return char 
	 * @throws Não lança exceções 
	 */
	@Override
	public char getNext() {
		return iter.next().charAt(0);
	}

	
	/**
	 *  
	 * @return boolean
	 * @throws Não lança exceções
	 */
	@Override
	public boolean hasNext() {
		return iter.hasNext();
	}

}