/* Pide un valor double por consola y guárdalo en un archivo binario */

import java.io.*;
import java.util.Scanner;

public class GuardarDouble {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Introduce un número: ");
    double num = sc.nextDouble();
    sc.close();
    try {
      DataOutputStream out = new DataOutputStream(new FileOutputStream("C:\\Users\\Usuario\\Desktop\\prueba.dat"));
      out.writeDouble(num);
      out.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
