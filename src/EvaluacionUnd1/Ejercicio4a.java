package EvaluacionUnd1;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.*;


public class Ejercicio4a {

	
   public static void main(String[] args) throws IOException {
        // Arrays con los datos de personajes
        int[] ids = {1, 2, 3, 4, 5, 6, 7};
        String[] dnis = {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
        String[] nombres = {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
        String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe", "James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
        String[] tipos = {"heroe", "villano", "heroe", "heroe", "villano", "heroe", "villano"};
        int[] pesos = {76, 84, 66, 136, 78, 102, 70};
        int[] alturas = {178, 183, 156, 152, 177, 182, 188};

        // Ruta del archivo donde se guardarán los personajes
        File archivo = new File("." + File.separator + "src" + File.separator + "Marvel.dat");

        // Crear el archivo usando RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            System.out.println("Iniciando la escritura en el archivo Marvel.dat en la ruta: " + archivo.getAbsolutePath());

            for (int i = 0; i < ids.length; i++) {
                raf.writeInt(ids[i]); // Escribir ID (int)
                raf.writeBytes(formatearCadena(dnis[i], 9)); // Escribir DNI (String de 9 caracteres)
                raf.writeBytes(formatearCadena(nombres[i], 10)); // Escribir Nombre (String de 10 caracteres)
                raf.writeBytes(formatearCadena(identidades[i], 20)); // Escribir Identidad secreta (String de 20 caracteres)
                raf.writeBytes(formatearCadena(tipos[i], 10)); // Escribir Tipo (String de 10 caracteres)
                raf.writeInt(pesos[i]); // Escribir Peso (int)
                raf.writeInt(alturas[i]); // Escribir Altura (int)

                System.out.println("Personaje " + nombres[i] + " escrito en el archivo.");
            }

            System.out.println("Los datos de los personajes han sido guardados satisfactoriamente en " + archivo.getName());
        }
    }

    // Método para formatear cadenas asegurando que tienen el tamaño adecuado
    public static String formatearCadena(String cadena, int longitud) {
        if (cadena.length() > longitud) {
            return cadena.substring(0, longitud); // Cortar si es más larga
        } else {
            return String.format("%-" + longitud + "s", cadena); // Rellenar con espacios si es más corta
        }
    }
}
	    

