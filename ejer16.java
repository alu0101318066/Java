/* Implementa una aplicación que gestione una lista de nombres ordenada
 * por orden alfabético. Al arrancar se leerá de un fichero los nombres
 * insertados anteriormente y se pedirán nombres nuevos hasta que se 
 * introduzca la cadena "fin". Cada nombre que se introduzca deberá 
 * añadirse a los que ya había, de formma que la lista permanezca ordenada.
 * Al terminar, se guardará en el fichero la lista actualizada
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GestionLista gestionLista = new GestionLista();
        gestionLista.leerNombres();

        Scanner scanner = new Scanner(System.in);
        String nombre;
        do {
            System.out.print("Introduzca un nombre (o 'fin' para terminar): ");
            nombre = scanner.nextLine().trim();
            if (!nombre.equals("fin")) {
                gestionLista.insertarNombre(nombre);
            }
        } while (!nombre.equals("fin"));

        gestionLista.guardarNombres();
    }
}

class GestionLista {
    private static final String FICHERO = "nombres.txt";
    private List<String> nombres;

    public GestionLista() {
        nombres = new ArrayList<>();
    }

    public void leerNombres() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                nombres.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero de nombres: " + e.getMessage());
        }
    }

    public void insertarNombre(String nombre) {
        nombres.add(nombre);
        Collections.sort(nombres);
    }

    public void guardarNombres() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
            for (String nombre : nombres) {
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el fichero de nombres: " + e.getMessage());
        }
    }
}
