package Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class mainEjercicio1_a {

	public static void main(String[] args) {
		
		ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
		
		Profesor p1 = new Profesor("Juan Pérez", 40, "Titular", 10);
		Profesor p2 = new Profesor("María López", 35, "Adjunto", 7);
		Profesor p3 = new Profesor("Carlos Gómez", 45, "Asociado", 12);
		Profesor p4 = new Profesor("Ana Martínez", 50, "Titular", 20);
		Profesor p5 = new Profesor("Luis Fernández", 38, "Jefe de Trabajos Prácticos", 5);
		
		listaProfesores.add(p1);
		listaProfesores.add(p2);
		listaProfesores.add(p3);
		listaProfesores.add(p4);
		listaProfesores.add(p5);
		
		Iterator<Profesor> iter = listaProfesores.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		

	}

}
