import java.io.*;
import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        // Lista donde almacenaremos los alumnos leídos del fichero
        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {

            // Abrimos el fichero para lectura
            BufferedReader br =
                    new BufferedReader(
                            new FileReader("alumnos.txt"));

            String linea;

            // Leemos línea a línea hasta llegar al final
            while((linea = br.readLine()) != null){

                // Separamos los campos usando ';'
                String[] datos = linea.split(";");

                String nombre = datos[0];
                double nota = Double.parseDouble(datos[1]);

                // Creamos el objeto y lo añadimos a la lista
                alumnos.add(
                        new Alumno(nombre, nota));
            }

            // Cerramos el fichero
            br.close();

        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        try {

            // Abrimos el fichero para escritura
            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("aprobados.txt"));

            // Recorremos únicamente los alumnos aprobados
            alumnos.stream()
                    .filter(a -> a.getNota() >= 5)
                    .forEach(a -> {

                        try {

                            // Escribimos el nombre en el fichero
                            bw.write(a.getNombre());

                            // Salto de línea
                            bw.newLine();

                        } catch(IOException e) {
                            e.printStackTrace();
                        }

                    });

            // Cerramos el fichero
            bw.close();

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
