//import Ejercicio1_Streams.Videojuego;
//import com.google.gson.Gson;
//import com.google.gson.stream.JsonWriter;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class MainJsonStreaming {
//    public static void main(String[] args) {
//        // Lista del ejercicio 1
//        ArrayList<Videojuego> juegos = new ArrayList<>();
//        juegos.add(new Videojuego("Minecraft", "Sandbox", 9.5));
//        juegos.add(new Videojuego("FIFA", "Deportes", 7.8));
//        juegos.add(new Videojuego("GTA V", "Accion", 9.2));
//
//        Gson gson = new Gson(); // Instancia básica de Gson
//
//        System.out.println("Generando archivo JSON mediante Streaming...");
//
//        // Creamos el escritor del archivo JSON
//        try (JsonWriter writer = new JsonWriter(new FileWriter("videojuegos.json"))) {
//
//            writer.setIndent("  "); // Hace que el JSON se guarde con espacios y sea legible
//
//            writer.beginArray(); // Escribe el corchete de apertura: [
//
//            for (Videojuego juego : juegos) {
//                // Serializa el objeto actual de forma individual dentro del flujo
//                gson.toJson(juego, Videojuego.class, writer);
//            }
//
//            writer.endArray(); // Escribe el corchete de cierre: ]
//
//            System.out.println("¡Archivo 'videojuegos.json' creado con éxito!");
//
//        } catch (IOException e) {
//            System.out.println("Error al escribir el JSON: " + e.getMessage());
//        }
//    }
//}
