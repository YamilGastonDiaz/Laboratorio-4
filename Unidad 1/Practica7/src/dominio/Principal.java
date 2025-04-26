package dominio;

public class Principal {

	public static void main(String[] args) {
		//Abstracción
		
		Animal perro = new Perro("Droopy", "Callejero");		
		Animal gato = new Gato("Hilacha");
		
		System.out.println(perro.toString() + " " + perro.habilidades());
		System.out.println(gato.toString() + " " + gato.habilidades());	
		
	}

}
