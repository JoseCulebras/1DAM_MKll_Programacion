import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AnalizadorExamenDGT {
    public static void main (String[] args){
        List<Pregunta> bancoPreguntas = new ArrayList<>();
        String rutaArchivo = "preguntasExaminator.txt"; //El archivo con los datos del examen

        //Usamos un bloque try-with-resources para garantizar el cierre automático del fichero
        // 1. Lectura y parsing original del fichero
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            Pregunta preguntaActual = null;

            while ((linea = br.readLine()) != null){
                if(linea.trim().isEmpty()){
                    continue;
                }

                //Caso A: Línea es una Pregunta
                if(linea.startsWith("p-")){
                    String[] trozos = linea.split("-");
                    // trozos[0] -> "p"
                    // trozos[1] -> "¿Cuál es la función del reposacabezas?"
                    // trozos[2] -> "74"
                    String enunciado = trozos[1];
                    int dificultad = Integer.parseInt(trozos[2]);

                    preguntaActual = new Pregunta(enunciado, dificultad);
                    bancoPreguntas.add(preguntaActual);

                  //Caso B: Línea es una Respuesta asociada a la pregunta actual
                } else if (linea.startsWith("r-") && preguntaActual != null) {
                    String[] trozos = linea.split("-");
                    //trozos[0] -> "r"
                    //trozos[1] -> "A"
                    //trozos[2] -> "Evitar el latigazo cervical"
                    //trozos[3] -> "95"
                    String opcion = trozos[1];
                    String textoRespuesta = trozos[2];
                    int porcentaje = Integer.parseInt(trozos[3]);

                    preguntaActual.respuestas.add(new Respuesta(opcion, textoRespuesta, porcentaje));
                }
            }

            System.out.println("[FICHERO] Carga completada. Preguntas procesadas: " + bancoPreguntas.size());

            // 2. Procesamiento con Programación Funcional (Streams)
            List<Pregunta> preguntasProcesadas = bancoPreguntas.stream()
                    .filter(p -> p.idDificultad >= 70)              // Elimina menores de 70
                    .distinct()                                              // Quita duplicados usando el equals de Pregunta
                    .sorted(Comparator.comparing(p -> p.enunciado)) // Ordena alfabéticamente
                    .collect(Collectors.toList());


            // 3. Validación de cantidad de preguntas
            if(preguntasProcesadas.size() < 20){
                crearFicheroNoSuficientes();
                System.out.println("[SISTEMA] Programa terminado: No hay suficientes preguntas válidas.");
                return;
            }

            // Si hay más de 20, nos quedamos con las primeras 20
            List<Pregunta> preguntasExamen = preguntasProcesadas.stream()
                    .limit(20)
                    .collect(Collectors.toList());


            // 4. Guardar JSON Original
            serializaJSON(preguntasExamen, "preguntas_json_original.gson");


            //  5. Arreglar y generar JSON final
            arreglarFichero("preguntas_json_original.gson", "preguntas_json_final.gson");

            System.out.println("[SISTEMA] El examen se ha procesado y reparado correctamente.");

        }catch(IOException e){
            System.out.println("Error al procesar el archivo del examen: " + e.getMessage());
        }
    }

    // Genera el aviso de error en caso de no llegar al cupo
    private static void crearFicheroNoSuficientes(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("no_hay_suficientes_preguntas.txt"))){
            bw.write("No se han podido reunir las 20 preguntas requeridas que cumplan los filtros.");

        }catch (IOException e){
            System.out.println("Error al crear el archivo de aviso: " + e.getMessage());
        }
    }

    // Serializa manualmente al formato JSON estructurado
    public static void serializaJSON(List<Pregunta> preguntas, String nombreFichero){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))){
            bw.write("[\n");
            for (int i = 0; i < preguntas.size(); i++){
                Pregunta p = preguntas.get(i);
                bw.write("  {\n");
                bw.write("      \"enunciado\": \"" + p.enunciado + "\", \n");
                bw.write("      \"porcentajeAcierto\": " + p.idDificultad + ",\n"); // Línea que desaparecerá luego
                bw.write("      \"respuestas\": [\n");

                int totalRespuestas = p.respuestas.size();
                int contador = 0;

                for (Respuesta r : p.respuestas){
                    contador++;

                    bw.write("      \"" + r.opcion + " - " + r.texto + " - " + r.porcentajeUso + "\"");

                    if (contador < totalRespuestas){
                        bw.write(",");
                    }

                    bw.write("\n");
                }

                bw.write("      ]\n");
                bw.write("  }");

                if(i < preguntas.size() - 1){
                    bw.write(",");
                }

                bw.write("\n");
            }

            bw.write("]\n");

        } catch (IOException e){
            System.out.println("Error al serializar a JSON: " + e.getMessage());
        }
    }

    // Repara el archivo original aplicando los filtros finales requeridos
    public static void arreglarFichero(String origen, String destino){
        try(BufferedReader br = new BufferedReader(new FileReader(origen));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destino))){

            String linea;
            int numeroPregunta = 1;

            while ((linea = br.readLine()) != null){
                // R1: Eliminar la línea del porcentaje de acierto
                if (linea.contains("\"porcentajeAcierto\"")){
                    continue;
                }

                // R2: Numerar los enunciados manteniendo la identación intacta
                if (linea.contains("\"enunciado\": \"")){
                    int indiceMarca = linea.indexOf("\"enunciado\": \"") + 14;
                    String prefio = linea.substring(0, indiceMarca);
                    String restoEnunciado = linea.substring(indiceMarca);

                    linea = prefio + numeroPregunta + ". " + restoEnunciado;
                    numeroPregunta++;
                }

                bw.write(linea);
                bw.newLine();
            }

        }catch (IOException e){
            System.out.println("Error al reparar el fichero: " + e.getMessage());
        }
    }

    //Clases internas para estructurar limpiamente la información leída
    public static class Respuesta{
        String opcion;
        String texto;
        int porcentajeUso;

        public Respuesta(String opcion, String texto, int porcentajeUso){
            this.opcion = opcion;
            this.texto = texto;
            this.porcentajeUso = porcentajeUso;
        }

        @Override
        public boolean equals(Object o){
            if (this == o){
                return true;
            }

            if (o == null || getClass() != o.getClass()){
                return false;
            }

            Respuesta respuesta = (Respuesta) o;

            return Objects.equals(opcion, respuesta.opcion) && Objects.equals(texto, respuesta.texto);
        }

        @Override
        public int hashCode(){
            return Objects.hash(opcion, texto);
        }
    }

    public static class Pregunta{
        String enunciado;
        int idDificultad;
        //Se usa LinkedHashSet para evitar duplicados manteniendo el orden
        Set<Respuesta> respuestas = new LinkedHashSet<>();

        public Pregunta(String enunciado, int idDificultad){
            this.enunciado = enunciado;
            this.idDificultad = idDificultad;
        }

        @Override
        public boolean equals(Object o){
            if (this == o){
                return true;
            }

            if (o == null || getClass() != o.getClass()){
                return false;
            }

            Pregunta pregunta = (Pregunta) o;

            return Objects.equals(enunciado, pregunta.enunciado);
        }

        @Override
        public int hashCode(){
            return Objects.hash(enunciado);
        }
    }
}
