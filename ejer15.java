/* Implementa un programa que lea números enteros desde el fichero numeros.dat
 * y los vaya guardando en los ficheros pares.dat y impares.dat según su imparidad
*/

import java.io.*;
import java.util.*;

public class ejer15 {
    public static void main(String[] args) {
        GestionNumeros gestionNumeros = new GestionNumeros();
        gestionNumeros.leerNumeros();
        gestionNumeros.guardarNumeros();
    }
}

class GestionNumeros {
    private static final String FICHERO = "numeros.dat";
    private static final String FICHERO_PARES = "pares.dat";
    private static final String FICHERO_IMPARES = "impares.dat";
    private List<Integer> numeros;

    public GestionNumeros() {
        numeros = new ArrayList<>();
    }

    public void leerNumeros() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero de números: " + e.getMessage());
        }
    }

    public void guardarNumeros() {
        try (BufferedWriter bwPares = new BufferedWriter(new FileWriter(FICHERO_PARES));
             BufferedWriter bwImpares = new BufferedWriter(new FileWriter(FICHERO_IMPARES))) {
            for (Integer numero : numeros) {
                if (numero % 2 == 0) {
                    bwPares.write(numero.toString());
                    bwPares.newLine();
                } else {
                    bwImpares.write(numero.toString());
                    bwImpares.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el fichero de números: " + e.getMessage());
        }
    }
}


