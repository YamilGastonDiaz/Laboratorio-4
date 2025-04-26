package Ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

public class mainEjercicio3 {

	public static void main(String[] args) {
		
		ArrayList<Edificio> lista = new ArrayList<>();
		
		//Polideportivo p1 = new Polideportivo(2000, "Primero de Marzo", 3);
		//lista.add(p1);
		
		lista.add( new Polideportivo(2000, "Primero de Marzo", 3));
		lista.add( new Polideportivo(2000, "Primero de Marzo", 3));
		lista.add( new Polideportivo(2000, "Primero de Marzo", 3));
		lista.add( new Oficina(2000.5, 20));
		lista.add( new Oficina(1000.9, 15));
		
		Iterator<Edificio> ed = lista.iterator();
		while(ed.hasNext()) 
		{
			System.out.println(ed.next().toString());
		}
	}

}
