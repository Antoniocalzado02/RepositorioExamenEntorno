package com.calc.app;

import com.calc.model.Decimal;
import com.calc.model.Entero;
import com.calc.model.Numero;

public class Aritmetica {

	public Aritmetica() {}
	
	/**Encontramos el metodo de tipo Numero el cual hace una suma
	 * Encontramos tambien antes el metodo resta que es del mismo tipo
	 * Nos encontramos con la funcion instanceof que nos devuelve
	 * un true si son del mismo tipo que se le pide, o false si es
	 * el caso contrario
	 * Nos encontramos con el equals para comprobar si sus bases son iguales 
	 * ya que estan llamando a la base con el getter de base*/

	
	public Numero suma(Numero n1, Numero n2) {
		Numero resultado = null;
		
		if(n1.getBase().equals(n2.getBase())) {
			
			if (n1 instanceof Entero && n2 instanceof Entero) {
				resultado = new Entero(n1.getValorEntero()+n2.getValorEntero());
				
			}else if(n1 instanceof Decimal && n2 instanceof Decimal) {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n1).getValorDecimal()+((Decimal)n2).getValorDecimal(),
						n1.getBase()
				);
			}else if(n1 instanceof Decimal) {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n1).getValorDecimal(),
						n1.getBase());
			}else {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n2).getValorDecimal(),
						n1.getBase());
			}
			
		}
		
		return resultado;
		/**
		 * 
		 * Devuelve el resultado de la suma de dos numeros
		 * Estos deben comprobarse que sean enteros con el instanceof
		 * y tambien sus bases deben ser iguales para sumarse
		 * */
	}
	
	public Numero resta(Numero n1, Numero n2) {
		Numero sustraer = null;
		if (n2 instanceof Decimal) {
			Decimal tmp = (Decimal)n2;
			sustraer = new Decimal(-tmp.getValorEntero(), -tmp.getValorDecimal(), tmp.getBase()); 
		}else {
			sustraer = new Entero(-n2.getValorEntero());
		}
		return suma(n1, sustraer);
		/**
		 * 
		 * Devuelve el numero 1 que le hemos pasado y el sustraer
		 * Estos deben comprobarse que sean de tipo decimal
		 * y sustraer toma los valores que se le pasan por los parametros
		 * */
	}
	
	
	public Numero calcularMedia(Object[] objs) {
		Numero acumulador = new Entero(0);
		
		for(int i=0; i<objs.length; i++) {
			acumulador = suma(acumulador, (Numero)objs[i]);
		}
		return new Decimal(acumulador.getValorEntero()/objs.length, 
						((Decimal)acumulador).getValorDecimal()*objs.length);
	}
}
