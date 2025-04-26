package Ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		
		TreeSet<Profesor> listaProfesores = new TreeSet<Profesor>();
		
		Profesor p1 = new Profesor("Juan Pérez", 40, "Titular", 10);
		Profesor p2 = new Profesor("María López", 35, "Adjunto", 7);
		Profesor p3 = new Profesor("Carlos Gómez", 45, "Asociado", 12);
		Profesor p4 = new Profesor("Ana Martínez", 50, "Titular", 20);
		Profesor p5 = new Profesor("Juan Pérez", 40, "Titular", 10);
		
		listaProfesores.add(p1);
		listaProfesores.add(p2);
		listaProfesores.add(p3);
		listaProfesores.add(p4);
		listaProfesores.add(p5);
		
		Iterator<Profesor> iter = listaProfesores.iterator();
		while(iter.hasNext()) {
			Profesor p = (Profesor)iter.next();
			System.out.println(p.toString());
		}
		
		if(p1.equals(p5))
		{
			System.out.println("Son la misma persona");
		}
		else
		{
			System.out.println("No son la misma persona");
		}

	}

}
