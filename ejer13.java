/*Escribe unprograma que lea de un fichero binario que sea una tabla de números double y después muestre el contenido de la tabla por consola. */

import java.io.*;
import java.util.Scanner;

public class ejer13 {
  public static void main(String[] args) {
    try {
      DataInputStream in = new DataInputStream(new FileInputStream("C:\\Users\\Usuario\\Desktop\\prueba.dat"));
      double num = in.readDouble();
      in.close();
      System.out.println(num);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}