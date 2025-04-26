package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;


public class Archivo {
	private String ruta;

	public String getRuta() {return ruta;}
	public void setRuta(String ruta) {this.ruta = ruta;}
	
	public boolean existe()
	{
		File archivo = new File(ruta);
		if(archivo.exists())
				return true;
			return false;
	}
	
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader (entrada);
			
			String linea = "";
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
	public void mostrarOrdenado() {
		TreeSet<Persona> personas = new TreeSet<>();
		FileReader entrada;
		
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader (entrada);
			
			String linea;
			while ((linea = miBuffer.readLine()) != null) {
				String[] texto = linea.split("-");
				if (texto.length == 3) {
					String nombre = texto[0].trim();
					String apellido = texto[1].trim();
					String dni = texto[2].trim();
					
					try {
						Persona.verificarDniInvalido(dni);
						
						personas.add(new Persona(nombre, apellido, dni));
						
					} catch (Exception e) {
						System.out.println("Error dni invalidos \n");
					}					
					
				}
			}
			
			System.out.println("Lista de personas ordenadas por apellido:");
		    for (Persona p : personas) {
		        System.out.println(p);
		    }
		    
		    try {
				FileWriter fileW = new FileWriter("Resultado.txt", false);
				BufferedWriter buffW = new BufferedWriter(fileW);
				
				for (Persona p1 : personas) {
					buffW.write(p1.toString());
					buffW.newLine();
				}
				
				buffW.close();
				fileW.close();
				
				System.out.println("Los datos se guardaron correctamente");
				
			} catch (Exception e) {
				System.out.println("Error al guardar en Resultado.txt");
			}
			
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
	
}
