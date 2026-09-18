//import Ejercicio2_Ficheros.Alumno;
//
//import java.io.*;
//
//public class MainBinarioApp {
//    public static void main(String[] args) {
//        File archivo = new File("alumnos.dat");
//        Alumno nuevoAlumno = new Alumno("Marcos Pérez", 7.5);
//
//        System.out.println("Añadiendo alumno al archivo binario...");
//
//        // Si NO existe, creamos el archivo con la cabecera normal
//        if (!archivo.exists()) {
//            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
//                oos.writeObject(nuevoAlumno);
//                System.out.println("Archivo creado y primer alumno guardado.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        // Si YA existe, usamos nuestra clase modificada en modo append (true)
//        else {
//            try (MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream(archivo, true))) {
//                moos.writeObject(nuevoAlumno);
//                System.out.println("Alumno añadido correctamente al final del archivo.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
