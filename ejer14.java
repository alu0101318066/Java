/* Introduce por teclado una frase y guárdala en un archivo binario.
 * A continuación, recupera la frase del archivo y muéstrala por pantalla.
 */

import java.io.*;
import java.util.*;

public class ejer14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String frase;
        System.out.print("Introduce una frase: ");
        frase = teclado.nextLine();
        try {
            FileOutputStream fos = new FileOutputStream("frase.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(frase);
            dos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
        }
        try {
            FileInputStream fis = new FileInputStream("frase.dat");
            DataInputStream dis = new DataInputStream(fis);
            frase = dis.readUTF();
            System.out.println("La frase es: " + frase);
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
        }
    }
}