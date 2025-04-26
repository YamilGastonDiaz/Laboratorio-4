package Ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		
		Archivo a = new Archivo();
		a.setRuta("Personas.txt");
		
		
		if (a.existe()) {
			System.out.println("- Lista del Archivo -");
			a.lee_lineas();
			
			System.out.println("- Lista del Archivo ordenado -");
			a.mostrarOrdenado();
			
		}

	}

}
