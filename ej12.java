import java.io.*;
import java.util.Scanner;

public class DatosUsuario {
  public static void main(String[] argumentos) {
    String nombre;
    int edad;

    Scanner datos = new Scanner(System.in);

    System.out.print("Introduce tu nombre: ");
    nombre = datos.nextLine();

    System.out.print("Introduce tu edad: ");
    edad = datos.nextInt();

    try {
      File archivo = null;
      archivo = new File("datos.txt");

      if (!archivo.exists()) {
        archivo.createNewFile();
      }

      BufferedWriter in = new BufferedWriter(new FileWriter(archivo));

      in.write(nombre + "," + edad);
      in.newLine();

      in.close();

      System.out.println("Los datos se han guardado correctamente.");

    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    

    
  }
}