package com.exercicios.exercicio3.business;
/**
 * 
 * @author Carlos Herraez
 * @version 06.11.2015
 * 	
 */
import java.util.ArrayList;
import java.util.HashMap;

import com.exercicios.exercicio3.classe.impl.StreamImpl;

public class ExercicioStream {

/**
 * Método que recebe como entrada StreamImpl que implementa a classe Stream procurando em essa stream se existe algum digito que não se repita e devolvendo o primeiro de todos.  
 * @param stream Stream que passamos para ser avaliada. 
 * @return String Devolve “” quando não encontra dígitos que não se repitam e o dígito quando o encontra
 */
	public char firstChar(StreamImpl stream){
		char digitoEncontrado = '\0';
		
		// Usaremos um HashMap para saber se o digito está 
		// repetido ou não e um ArrayList para saber a 
		// ordem na qual está na Stream.
		HashMap<String, Boolean> map = new HashMap<>();
		ArrayList<String> digitoList = new ArrayList<>();
		
		try {
			
			// Salvamos no HashMap cada digito com o valor true até ele 
			// repetir que se muda para false. Ao mesmo tempo se preenche
			// um ArrayList com os dígitos para conhecer a ordem na
			// qual eles foram aparecendo. 
			while (stream.hasNext()) {
				char[] te = {stream.getNext()};
				String digito = new String(te);
				if(map.size()==0){
					map.put(digito, true);
					digitoList.add(digito);
				}else if(map.get(digito)!=null){
					map.put(digito, false);
				}else{
					map.put(digito, true);
					digitoList.add(digito);
				}
			}
			
			// Verificamos se existe algum dígito dentro do
			// HashMap com o valor true que indica que existe
			// algum digito que não se repete. 
			if(map.containsValue(true)){
				String strEncontrado = "";
				boolean encontrado = false;
				int contador = 0;
				
				// Percorremos o ArrayList verificando no 
				// HashMap se esse digito tem valor true ou 
				// false até encontrar o primeiro com o valor true. 
				while (!encontrado) {
					strEncontrado = digitoList.get(contador);
					encontrado = map.get(strEncontrado);
					contador++;
				}
				digitoEncontrado = strEncontrado.charAt(0);	
			}
		
		} catch (Exception e) {
			throw e;
		}
		
		return digitoEncontrado;
	}
}
