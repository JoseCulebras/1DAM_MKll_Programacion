import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ejercicio3App {
    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 19.99));
        libros.add(new Libro("1984", "George Orwell", 14.50));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 21.00));
        libros.add(new Libro("El nombre del viento", "Patrick Rothfuss", 18.75));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 13.95));

        System.out.println("=== DEMOSTRACIÓN DE PEEK (EL ESPÍA DEL FLUJO) ===");
        // .peek() nos permite mirar el objeto dentro del stream sin interrumpir ni terminar el flujo
        long librosCaros = libros.stream()
                .filter(l -> l.getPrecio() > 15.0)
                .peek(l -> System.out.println("-> Pasó el filtro: " + l.getTitulo()))
                .count(); // Operación terminal que cuenta cuántos pasaron

        System.out.println("Total de libros caros: " + librosCaros);

        System.out.println("\n=== CÁLCULO DE LA MEDIA DE PRECIOS ===");
        // mapToDouble transforma el flujo a un stream primitivo numérico para poder usar .average()
        OptionalDouble media = libros.stream()
                .mapToDouble(Libro::getPrecio)
                .average();

        if (media.isPresent()) {
            System.out.printf("El precio medio de los libros es: %.2f€\n", media.getAsDouble());
        } else {
            System.out.println("No se pudo calcular la media.");
        }
    }
}