package EvaluacionUnd1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public class Ejercicio4b {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Uso: java Ejercicio4b <DNI> <pesoDelMesPasado>");
            return;
        }

        String dniBuscado = args[0];
        int pesoDelMesPasado = Integer.parseInt(args[1]);

        // Ruta del archivo donde se guardan los personajes
        File archivo = new File("." + File.separator + "src" + File.separator + "Marvel.dat");

        // Crear el archivo usando RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            boolean encontrado = false;

            // Leer cada registro hasta encontrar el DNI
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String dni = leerCadena(raf, 9);
                String nombre = leerCadena(raf, 10);
                String identidad = leerCadena(raf, 20);
                String tipo = leerCadena(raf, 10);
                int pesoActual = raf.readInt();
                int altura = raf.readInt();

                if (dni.equals(dniBuscado)) {
                    encontrado = true;
                    System.out.println("Personaje encontrado: " + nombre);
                    System.out.println("Peso actual: " + pesoActual + " kg");

                    // Calcular la diferencia de peso
                    int diferencia = pesoActual - pesoDelMesPasado;
                    if (diferencia > 0) {
                        System.out.println(nombre + " ha engordado " + diferencia + " kg.");
                    } else if (diferencia < 0) {
                        System.out.println(nombre + " ha adelgazado " + Math.abs(diferencia) + " kg.");
                    } else {
                        System.out.println(nombre + " se mantiene en su peso.");
                    }
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El personaje con DNI " + dniBuscado + " no existe.");
            }
        }
    }

    // Método para leer una cadena de un archivo de longitud fija
    public static String leerCadena(RandomAccessFile raf, int longitud) throws IOException {
        byte[] buffer = new byte[longitud];
        raf.read(buffer);
        return new String(buffer).trim(); // Retorna la cadena sin espacios
    }
}

