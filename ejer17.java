/* Escribe un texto, línea a línea, de forma que, cada vez que se pulse Intro,
 * se guarde la línea en un archivo binario. El proceso se termina cuando
 * introduzcamos una línea vacía. Después el programa lee el texto completo del
 * archivo y lo muestra por pantalla.
 */

import java.io.*;
import java.util.*;

public class ejer17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea;
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("texto.dat"))) {
            do {
                System.out.print("Introduzca una línea de texto (o vacío para terminar): ");
                linea = sc.nextLine();
                dos.writeUTF(linea);
            } while (!linea.equals(""));
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("texto.dat"))) {
            while (dis.available() > 0) {
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}