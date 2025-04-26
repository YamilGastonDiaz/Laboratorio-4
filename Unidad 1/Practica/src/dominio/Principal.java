package dominio;

public class Principal {
	
	public static void main(String[] args) {
		
		//Clases - Encapsulamiento - Método toString()
		
		
		//ejemplo 1
		Articulo art = new Articulo();		
		System.out.println("ID: " + art.getId() + " - Nombre: " + art.getNombre());
		
		//ejemplo 2
		Articulo art2 = new Articulo("hamburguesa", 13);
		System.out.println("ID: " + art2.getId() + " - Nombre: " + art2.getNombre());
		
		//ejemplo 3
		Articulo art3 = new Articulo();
		art3.setId(22);
		art3.setNombre("papas");		
		System.out.println(art3.toString());
	}

}
