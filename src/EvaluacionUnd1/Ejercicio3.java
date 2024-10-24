package EvaluacionUnd1;
import java.io.*;

public class Ejercicio3 {

	
	    public static void main(String[] args) {
	        // Ruta del archivo PDF a verificar
	        File archivo = new File("." + File.separator + "src" + File.separator + "ejemplo.pdf");

	        // Secuencia de bytes esperada para un archivo PDF (%PDF -> {37, 80, 68, 70})
	        byte[] bytePDF = {37, 80, 68, 70};

	        try (FileInputStream fis = new FileInputStream(archivo)) {
	            // Leer los primeros 4 bytes del archivo
	            byte[] cabeceraLeida = new byte[4];
	            int bytesLeidos = fis.read(cabeceraLeida);

	            // Verificar si se han leído al menos 4 bytes
	            if (bytesLeidos == 4) {
	                // Comparar la cabecera leída con la secuencia esperada
	                boolean esPDF = true;
	                for (int i = 0; i < 4; i++) {
	                    if (cabeceraLeida[i] != bytePDF[i]) {
	                        esPDF = false;
	                        break;
	                    }
	                }

	                // Resultado de la comparación
	                if (esPDF) {
	                    System.out.println("El archivo es un PDF válido.");
	                } else {
	                    System.out.println("El archivo no es un PDF válido.");
	                }
	            } else {
	                System.out.println("No se pudo leer la cabecera completa del archivo.");
	            }
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	        }
	    }
	}
