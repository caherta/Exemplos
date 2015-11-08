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
 * M�todo que recebe como entrada StreamImpl que implementa a classe Stream procurando em essa stream se existe algum digito que n�o se repita e devolvendo o primeiro de todos.  
 * @param stream Stream que passamos para ser avaliada. 
 * @return String Devolve �� quando n�o encontra d�gitos que n�o se repitam e o d�gito quando o encontra
 */
	public char firstChar(StreamImpl stream){
		char digitoEncontrado = '\0';
		
		// Usaremos um HashMap para saber se o digito est� 
		// repetido ou n�o e um ArrayList para saber a 
		// ordem na qual est� na Stream.
		HashMap<String, Boolean> map = new HashMap<>();
		ArrayList<String> digitoList = new ArrayList<>();
		
		try {
			
			// Salvamos no HashMap cada digito com o valor true at� ele 
			// repetir que se muda para false. Ao mesmo tempo se preenche
			// um ArrayList com os d�gitos para conhecer a ordem na
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
			
			// Verificamos se existe algum d�gito dentro do
			// HashMap com o valor true que indica que existe
			// algum digito que n�o se repete. 
			if(map.containsValue(true)){
				String strEncontrado = "";
				boolean encontrado = false;
				int contador = 0;
				
				// Percorremos o ArrayList verificando no 
				// HashMap se esse digito tem valor true ou 
				// false at� encontrar o primeiro com o valor true. 
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
