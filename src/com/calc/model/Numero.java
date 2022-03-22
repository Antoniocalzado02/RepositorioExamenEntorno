package com.calc.model;

import java.util.Objects;

public abstract class Numero {
	/*Como podemos ver nos encontramos en la clase numero
	 * la cual tiene las variables de tipo potected
	 * tiene un constructor Numero el cual recibe un valor de tipo entero
	 * y una base de tipo Base
	 * Podemos encontrarnos tambien los getters and setters respectivos
	 * y metodo equals para comparar si son iguales
	 * Esta clase es abstracta*/

	protected int valorEntero;
	protected Base base;
	
	
	
	public Numero(int value, Base base) {
		super();
		this.base=base;
		setValorEntero(value);
	}

	
	public Numero(int valor) {
		this(valor, Base.DECIMAL);
	}
	
	protected abstract void setValorEntero(int valorEntero);


	public int getValorEntero() {
		return valorEntero;
	}
	


	public Base getBase() {
		return base;
	}


	@Override
	public int hashCode() {
		return Objects.hash(base, valorEntero);
	}
	
	//El metodo equals nos permite comprobarm,
	//si son los parametros que le estamos pasando son iguales


	@Override
	public boolean equals(Object obj) {
		return this==obj ||
				obj!=null && getClass() != obj.getClass()
				&& ((Numero) obj).base.equals(this.base)
				&& ((Numero) obj).valorEntero==this.valorEntero;
	}


	@Override
	public String toString() {
		return "Numero de tipo "+ getClass().getSimpleName()
				+ " con valorEntero=" + valorEntero 
				+ ", base=" + base;
	}
	
	
	
}
