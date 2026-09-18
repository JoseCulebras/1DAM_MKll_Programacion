import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1App {
    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();

        // Datos iniciales proporcionados por el PDF
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 19.99));
        libros.add(new Libro("1984", "George Orwell", 14.50));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 21.00));
        libros.add(new Libro("El nombre del viento", "Patrick Rothfuss", 18.75));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 13.95));
        libros.add(new Libro("Rayuela", "Julio Cortázar", 16.40));
        libros.add(new Libro("Don Quijote de la Mancha", "Alonso Fdez. de Avellaneda", 35.00));
        libros.add(new Libro("La sombra del viento", "Carlos Ruiz Zafón", 17.50));

        System.out.println("--- 1. LIBROS CON PRECIO MAYOR A 20€ ---");
        libros.stream()
                .filter(l -> l.getPrecio() > 20.0)
                .forEach(System.out::println);

        System.out.println("\n--- 2. LISTA DE SOLO TÍTULOS (MAPEO) ---");
        List<String> titulos = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.toList());
        titulos.forEach(System.out::println);

        System.out.println("\n--- 3. LIBROS ORDENADOS POR PRECIO (MENOR A MAYOR) ---");
        // Aplicamos la Opción 3 de ordenación funcional usando Comparator.comparing
        libros.stream()
                .sorted(Comparator.comparing(Libro::getPrecio))
                .forEach(System.out::println);

        System.out.println("\n--- 4. ¿HAY ALGÚN LIBRO DE 'George Orwell'? ---");
        boolean existeOrwell = libros.stream()
                .anyMatch(l -> l.getAutor().equalsIgnoreCase("George Orwell"));
        System.out.println("¿Existe?: " + (existeOrwell ? "Sí" : "No"));
    }
}