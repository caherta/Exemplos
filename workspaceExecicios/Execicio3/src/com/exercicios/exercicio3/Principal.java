package com.exercicios.exercicio3;
/**
 * 
 * @author Carlos Herraez
 * @version 06.11.2015
 * 	
 */
import com.exercicios.exercicio3.business.ExercicioStream;
import com.exercicios.exercicio3.dao.impl.StreamImpl;

public class Principal {
/**
 * Para realizar testes do exercicio
 * @param args
 */
	public static void main(String[] args) {
		ExercicioStream exercicio = new ExercicioStream();
		String entrada = "aAbcAa";
		try {
			StreamImpl stream = new StreamImpl(entrada);
			
			char digito = exercicio.firstChar(stream);
			
			if(digito=='\0'){
				System.out.println("No existen caracteres no repetidos");
			}else{
				System.out.println("El primer caracter que no se repite es: " + digito);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro inesperado");
			e.printStackTrace();
		}		

	}

}
