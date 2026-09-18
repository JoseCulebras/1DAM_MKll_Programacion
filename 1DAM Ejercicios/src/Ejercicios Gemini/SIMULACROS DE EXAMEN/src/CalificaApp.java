import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CalificaApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //cargamos los datos del archivo de texto 'notas_iniciales.txt'
        ArrayList<Alumno> Alumnos = cargarNotasInicialesTexto();

        int opcion = 0;
        double notaMedia = 0;
        double sumaNotas = 0;
        String nombre;
        double nota = 0;
        String modulo;

        do{
            System.out.println("=== SISTEMA DE CALIFICACIONES ===");
            System.out.println("1. Mostrar todos los alumnos y nota media global");
            System.out.println("2. Registrar nuevo alumno (Añadir al final)");
            System.out.println("3. Exportar actas finales (Ficheros de salida)");
            System.out.println("4. Salir");

            System.out.println("\nIntroduce la opción que desees: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("DATOS DE ALUMNOS");
                    System.out.println("================");

                    if(Alumnos.isEmpty()){
                        System.out.println("\nLa lista de alumnos está vacía.");

                    }else{
                        //Reseteamos la suma en cada consulta
                        sumaNotas = 0;

                        for(Alumno alumno : Alumnos){
                            System.out.println("\nNombre del alumno: " +  alumno.getNombre() + " | Modulo: " + alumno.getModulo() + " | Nota: " + alumno.getNota());

                            //Vamos acumulando las notas
                            sumaNotas += alumno.getNota();
                        }

                        notaMedia = sumaNotas / Alumnos.size();

                        System.out.println("\nNOTA MEDIA DE LA CLASE: " + notaMedia);
                    }
                    break;

                case 2:
                    System.out.println("\nREGISTRO DE NUEVO ALUMNO");
                    System.out.println("========================");
                    System.out.println("\nIntroduce el nombre del alumno que quieres añadir: ");
                    sc.nextLine();
                    nombre = sc.nextLine();

                    System.out.println("\nIntroduce el modulo del que quieres añadir una nota: ");
                    modulo = sc.nextLine();

                    do{
                        System.out.println("\nIntroduce la nota del modulo (0 - 10): ");
                        nota = sc.nextDouble();

                        if (!notaValida(nota)){
                            System.out.println("\nEsa nota no es válida.");
                            System.out.println("Por favor, introduce una nota entre 0 y 10.");
                        }
                    }while(!notaValida(nota));

                    //Añadimos el nuevo alumno al ArrayList
                    Alumnos.add(new Alumno(nombre, nota, modulo));
                    System.out.println("\nAlumno añadidio con éxito.");
                    break;

                case 3:

                    System.out.println("\nGenerando ficheros de salida...");

                    //Exportamos los aprobados al fichero de texto plano
                    exportarAprobadosTexto(Alumnos);

                    //Exportamos la lista completa al fichero binario serializado
                    guardarFicheroBinario(Alumnos);

                    break;

                case 4:
                    System.out.println("Cerrando el programa...");
                    break;

                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
                    break;
            }
        }while(opcion != 4);
        sc.close();
    }

    //Metodo de validación de notas
    public static boolean notaValida(double nota){
        return nota >= 0 && nota <= 10;
    }

    public static ArrayList<Alumno> cargarNotasInicialesTexto(){

        ArrayList<Alumno> listaCargada = new ArrayList<>();
        File fichero = new File("notas_iniciales.txt");

        if(!fichero.exists()){
            System.out.println("El fichero 'notas_iniciales.txt' no se ha detectado.");
            return listaCargada;
        }

        // Usamos try-with-resources con BufferedReader para leer líneas completas de texto plano
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea;

            while ((linea = br.readLine()) != null){
                // Separamos los campos por el asterisco. Se usa "\\" porque el asterisco es un carácter especial en Regex
                String[] datos = linea.split("\\*");

                // Controlamos que la línea tenga la estructura correcta (Nombre*Nota*Modulo)
                if(datos.length == 3){
                    String nombre = datos[0];
                    double nota = Double.parseDouble(datos[1]);// Conversión de String a double
                    String modulo = datos[2];

                    // Agregamos el objeto recién construido a la lista temporal
                    listaCargada.add(new Alumno(nombre, nota, modulo));
                }
            }
            System.out.println("Datos iniciales cargados desde 'notas_iniciales.txt' con éxito.");

        }catch (IOException e){
            System.out.println("No se pudo leer el archivo de texto: " + e.getMessage());
        }

        return listaCargada;
    }

    //Escribe en un fichero de texto plano "aprobados.txt" usando Streams
    public static void exportarAprobadosTexto(ArrayList<Alumno> listaCompleta){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("aprobados.txt"))){

            // Usamos Streams para filtrar a los aprobados de forma limpia
            listaCompleta.stream()
                    .filter(a -> a.getNota() >= 5)
                    .forEach(a -> {
                        try{
                           bw.write(a.getNombre()); // Escribimos solo el nombre
                           bw.newLine(); // Insertamos un salto de línea limpio

                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    });

            System.out.println("Fichero de texto 'aprobados.txt' generado con éxito.");

        }catch (IOException e){
            System.out.println("Error al generar el fichero de aprobados: " + e.getMessage());
        }
    }

    //Guarda la lista completa serializada en un archivo binario (.dat)
    public static void guardarFicheroBinario(ArrayList<Alumno> Alumnos){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("historico.dat"))){
            oos.writeObject(Alumnos);
            System.out.println("Histórico binario guardado con éxito en 'histórico.dat'.");

        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo binario: " + e.getMessage());
        }
    }

    //CLASE POO: Alumno (Estructura interna estática recomendada si se escribe todo en el mismo fichero)
    static class Alumno implements Serializable {
        private static final long serialVersionUID = 1L;
        private String nombre;
        private double nota;
        private String modulo;

        public Alumno(String nombre, double nota, String modulo){
            this.nombre = nombre;
            this.nota = nota;
            this.modulo = modulo;
        }

        public void setNombre(String nombre) {this.nombre = nombre;}

        public String getNombre(){return nombre;}

        public void setNota(double nota){this.nota = nota;}

        public double getNota(){return nota;}

        public void setModulo(String modulo){this.modulo = modulo;}

        public String getModulo(){return modulo;}

        @Override
        public String toString(){
            return "Alumno: " + nombre + " | Nota: " + nota + " | Módulo: " + modulo;
        }
    }
}
