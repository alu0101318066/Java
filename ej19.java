/** Ejercicio 10.19
Un encriptador es una aplicación que transforme un texto haciéndolo ilegible
para aquellos que desconocen el código. Diseña un programa que lea un fichero
de texto, lo codifique y cree un nuevo archivo con el mensaje cifrado. El 
alfabeto de codificación se encontrará en el fichero codec.txt. Un ejemplo de
codificación de alfabeto es:
  Alfabeto: a b c d e f g h i j k l m n o p q r s t u v w x y z
  Cifrado: e m s r c y j n f x i w t a k o z d l q v b h u p g */


import java.io.*;
import java.util.*;

public class Encriptador {
  public static void main(String[] args) {
    //Lectura del archivo de texto original
    String alfabeto = "";
    BufferedReader in = null;
    try {
      in = new BufferedReader(new FileReader("texto.txt")); 
      String linea = in.readLine;
      while (linea != null) { //mientras no llegue al finaldel archivo
        alfabeto += linea + "\n"; //el cambio de línea hay que insertarlo manualmente
        linea = in.readLine();
      }
    } catch (IOException ex) {}

  }

  //Lectura del archivo codec.txt 
  Map<Character, Character> codificacion = new HashMap<Character, Character>();
  BufferedReader in = null;
  try {

    in = new BufferedReader(new FileReader("codec.txt"));
    String linea;
    while (linea != null) {
      String[] partes = linea.split(":"); //se recorta el alfabeto por ":", la primera parte es el "titulo" y la segunda el alfabeto en si
      String nombre = partes[0];
      String alfabeto = partes[1].trim();
      for (int i = 0; i < alfabeto.length(); i++) { //falta poner las cosas en el map (se puede usar put en java?) 

      }
    }
 
  } catch (IOException ex) {}


}
