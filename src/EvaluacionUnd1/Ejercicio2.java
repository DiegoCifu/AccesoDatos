package EvaluacionUnd1;
import java.io.*;


public class Ejercicio2 {

	public static void main(String[] args) {
        // Fichero de entrada y de salida
        File fic = new File("." + File.separator + "src" + File.separator + "FicheroNombres.txt"); // Declara fichero de entrada
        String ficheroSalida = "." + File.separator + "src" + File.separator + "NombresCincoLetras.txt"; // Declara fichero de salida

    
    try {
    	// Abrir el archivo de entrada para lectura
        BufferedReader lector = new BufferedReader(new FileReader(fic));
        
        // Abrir el archivo de salida para escritura
        BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroSalida));
        
        String linea;
        
        // Leer el archivo línea por línea
        while ((linea = lector.readLine()) != null) {
            // Dividir la línea en palabras (asumimos que los nombres y apellidos están separados por espacios)
            String[] palabras = linea.split(" ");
            
            // Procesar cada palabra (nombre o apellido)
            for (String palabra : palabras) {
                // Comprobar si la palabra tiene exactamente 5 letras
                if (palabra.length() == 5) {
                    // Escribir la palabra en el archivo de salida
                    escritor.write(palabra);
                    escritor.newLine();  // Saltar a la siguiente línea en el archivo de salida
                }
            }
        }
  
        // Cerrar los archivos después de la operación
        lector.close();
        escritor.close();
        
        System.out.println("El archivo se ha procesado correctamente.");
    } catch (FileNotFoundException e) {
        System.out.println("El archivo de entrada no fue encontrado.");
    } catch (IOException e) {
        System.out.println("Ocurrió un error de entrada/salida.");
    }
}
}