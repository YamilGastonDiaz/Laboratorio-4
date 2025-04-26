package dominio;

public class Principal {
	
	public static void main(String[] args) {
		
		//Variables estáticas
		
		Articulo art = new Articulo("papa");
		System.out.println(art.toString());
		
		Articulo art2 = new Articulo("con");
		System.out.println(art2.toString());
		
		Articulo art3 = new Articulo("queso");
		System.out.println(art3.toString());

	}

}
