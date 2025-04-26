package Ejercicio2;

import java.time.LocalDate;

public class mainEjercicio2 {

	public static void main(String[] args) {
		
		LocalDate fechaC =  LocalDate.of(2030, 6, 13);
		LocalDate fechaE = LocalDate.of(2025, 4, 22);
		
		ProductoFresco pf = new ProductoFresco(fechaC, 111, fechaE, "Argentina");
		System.out.println(pf.toString());
		
		ProductoRefrigerado pr = new ProductoRefrigerado(fechaC, 222, 131313);
		System.out.println(pr.toString());
		
		ProductoCongelado pc = new ProductoCongelado(fechaC, 333, 20);
		System.out.println(pc.toString());

	}

}
