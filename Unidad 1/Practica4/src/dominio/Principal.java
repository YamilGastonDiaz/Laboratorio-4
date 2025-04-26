package dominio;

public class Principal {

	public static void main(String[] args) {
		
		//Herencia
		
		ArticuloGimnasio artG = new ArticuloGimnasio();
		
		System.out.println(artG.toString());
		
		ArticuloGimnasio artG1 = new ArticuloGimnasio("corredora", 100);
		
		System.out.println(artG1.toString());

	}

}
