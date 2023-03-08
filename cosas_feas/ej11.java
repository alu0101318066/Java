import java.io.*;

public class LeerArchivo {
  public static void main(String[] argumentos) {

    String nombreArchivo;

    if (argumentos.length == 0) {
      nombreArchivo = "prueba.txt";
    } else {
      nombreArchivo = argumentos[0];
    }

    try {
      in = new BufferedReader (new FileReader());
      String linea = in.readLine(nombreArchivo);
      while (linea != null) {
        texto += linea + '\n';
        linea = in.readLine();
      }
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException ex) {
          System.out.println(ex);
        }
      }
    }

    System.out.println(texto);

  }
}