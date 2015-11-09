package com.exercicios.exercicio3;
/**
 * 
 * @author Carlos Herraez
 * @version 06.11.2015
 * 	
 */
import com.exercicios.exercicio3.business.ExercicioStream;
import com.exercicios.exercicio3.classe.impl.StreamImpl;

public class Principal {
/**
 * Para realizar testes do exercicio
 * @param args
 */
	public static void main(String[] args) {
		ExercicioStream exercicio = new ExercicioStream();
		String entrada = "aAbcAabc";
		try {
			StreamImpl stream = new StreamImpl(entrada);
			
			char digito = exercicio.firstChar(stream);
			
			if(digito=='\0'){
				System.out.println("Não existem dígitos não repetidos");
			}else{
				System.out.println("O primeiro dígito que não se repete é: " + digito);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro inesperado");
			e.printStackTrace();
		}		

	}

}
