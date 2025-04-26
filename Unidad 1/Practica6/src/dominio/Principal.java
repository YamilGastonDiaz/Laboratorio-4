package dominio;

public class Principal {

	public static void main(String[] args) {
		//Polimorfismo
		
		Animal animal = new Animal("Animal");		
		Animal perro = new Perro("Droopy", "Callejero");		
		Animal gato = new Gato("Hilacha");
		
		//System.out.println(animal.toString());
		//System.out.println(perro.toString());
		//System.out.println(gato.toString());
		
		Animal[] animales = new Animal[3];
		animales[0] = animal;
		animales[1] = perro;
		animales[2] = gato;
		
		for (Animal a : animales) {
			System.out.println(a.toString());
		}

	}

}
