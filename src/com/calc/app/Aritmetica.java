package com.calc.app;

import com.calc.model.Decimal;
import com.calc.model.Entero;
import com.calc.model.Numero;

public class Aritmetica extends Suma,Resta {

	public Aritmetica() {}
	
	public Numero calcularMedia(Object[] objs) {
		Numero acumulador = new Entero(0);
		
		for(int i=0; i<objs.length; i++) {
			acumulador = suma(acumulador, (Numero)objs[i]);
		}
		return new Decimal(acumulador.getValorEntero()/objs.length, 
						((Decimal)acumulador).getValorDecimal()*objs.length);
	}
}
