package EvaluacionUnd1;
import java.io.*;


public class Ejercicio1 {

	 public static void main(String[] args) {
	        try {
	            File fic = new File("." + File.separator + "src" + File.separator + "FicheroEvaluacion.txt"); // Declara fichero
	            BufferedReader fichero = new BufferedReader(new FileReader(fic));
	            String linea;
	            while ((linea = fichero.readLine()) != null) {
	                // Invertir la cadena
	                String lineaInvertida = new StringBuilder(linea).reverse().toString();
	                // Imprimir la línea invertida
	                System.out.println(lineaInvertida);
	            }
	            fichero.close();
	        } catch (FileNotFoundException fn) {
	            System.out.println("No se encuentra el fichero");
	        } catch (IOException io) {
	            System.out.println("Error de E/S");
	        }
	    }
	}