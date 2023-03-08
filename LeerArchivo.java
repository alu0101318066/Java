/*Lee el valor double contenido en num.dat y muéstralo por pantalla. */
import java.io.*;
import java.util.Scanner;

public class LeerArchivo {
  public static void main(String[] args) {
    try {
      DataInputStream in = new DataInputStream(new FileInputStream("C:\\Users\\Usuario\\Desktop\\num.dat"));
      double num = in.readDouble();
      in.close();
      System.out.println(num);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}