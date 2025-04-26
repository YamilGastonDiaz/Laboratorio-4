package Ejercicio1;

import java.io.IOException;

public class DniInvalido extends IOException {

	@Override
	public String getMessage() {
		return "El dni ingresado contiene letras";
	}
	
	
}
