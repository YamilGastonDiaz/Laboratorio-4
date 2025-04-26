package dominio;

public class Principal {
	
	public static void main(String[] args)
	{
		//Métodos estáticos
		
		Articulo[] vArt = new Articulo[3];
		vArt[0] = new Articulo("pizza");
		vArt[1] = new Articulo("birra");
		vArt[2] = new Articulo("faso");
		
		for (Articulo articulo : vArt) {
			System.out.println(articulo.toString());
		}
		
		System.out.println(Articulo.decuelveProximoId());
	}
}
