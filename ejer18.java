/* Un libro de firmas es útil para recoger los nombres de todas las personas
que han pasado por un determinado lugar. Crea una aplicación que permita mostrar
el libro de firmas o insertar un nuevo nombre (comprobando que no se encuentre
repetido) usando el fichero binario firmas.dat
 */

import java.io.*;
import java.util.*;

public class ejer18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea;
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("firmas.dat"))) {
            do {
                System.out.print("Introduzca un nombre (o vacío para terminar): ");
                linea = sc.nextLine();
                dos.writeUTF(linea);
            } while (!linea.equals(""));
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("firmas.dat"))) {
            while (dis.available() > 0) {
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}