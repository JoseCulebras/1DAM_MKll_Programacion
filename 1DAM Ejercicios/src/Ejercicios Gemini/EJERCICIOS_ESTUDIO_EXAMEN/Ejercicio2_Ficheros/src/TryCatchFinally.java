import java.io.*;

public class TryCatchFinally {
    static BufferedReader br = null;

    static void main(String[] args) {
        BufferedReader br = null;

        try {
            // Intentamos abrir el fichero
            br = new BufferedReader(
                    new FileReader("alumnos.txt"));
        }
        catch(FileNotFoundException e){

            // El fichero no existe
            System.out.println("No existe el fichero");

        } catch(IOException e){

            // Error durante la lectura
            System.out.println("Error de lectura");
        }  finally {

            // Este bloque se ejecuta siempre
            // Cerramos el recurso si se abrió correctamente
            try {
                if(br != null)
                    br.close();

            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
