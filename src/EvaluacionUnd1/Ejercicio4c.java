package EvaluacionUnd1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public class Ejercicio4c {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Uso: java Ejercicio4c <tipoDePersonaje>");
            return;
        }

        String tipoBuscado = args[0].toLowerCase();  // Convertimos el tipo a minúsculas para evitar problemas de mayúsculas/minúsculas
        boolean encontrado = false;
        int contadorPersonajes = 0;

        // Ruta del archivo donde se guardan los personajes
        File archivo = new File("." + File.separator + "src" + File.separator + "Marvel.dat");

        // Crear el archivo usando RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {

            // Leer cada registro y filtrar por tipo de personaje
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String dni = leerCadena(raf, 9);
                String nombre = leerCadena(raf, 10);
                String identidad = leerCadena(raf, 20);
                String tipo = leerCadena(raf, 10).toLowerCase();  // Convertimos el tipo a minúsculas
                int peso = raf.readInt();
                int altura = raf.readInt();

                // Si el tipo coincide con el solicitado
                if (tipo.equals(tipoBuscado)) {
                    encontrado = true;
                    contadorPersonajes++;

                    // Mostrar los detalles del personaje
                    System.out.println("ID: " + id);
                    System.out.println("DNI: " + dni);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Identidad secreta: " + identidad);
                    System.out.println("Tipo: " + tipo);
                    System.out.println("Peso: " + peso + " kg");
                    System.out.println("Altura: " + altura + " cm");
                    System.out.println("------------------------");
                }
            }

            // Si no se encontró ningún personaje del tipo solicitado
            if (!encontrado) {
                System.out.println("No se encontraron personajes del tipo: " + tipoBuscado);
            } else {
                System.out.println("Total de personajes encontrados del tipo " + tipoBuscado + ": " + contadorPersonajes);
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

