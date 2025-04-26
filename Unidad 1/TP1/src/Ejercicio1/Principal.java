package Ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		Empleado[] vEmpleado = new Empleado[3];
		vEmpleado[0] = new Empleado();
		vEmpleado[1] = new Empleado("jaimito", 21);
		vEmpleado[2] = new Empleado("yogurt", 33);
		
		for (Empleado empleado : vEmpleado) {
			System.out.println(empleado.toString());
		}
		
		System.out.println(Empleado.devuelveProximoID());
		
		Empleado empleado = new Empleado("pepito", 22);
		
		System.out.println(empleado.toString());
		
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("demostenes");
		empleado2.setEdad(18);
		
		System.out.println(empleado2.toString());

	}

}
