import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {
        ArrayList<Videojuego> juegos = new ArrayList<>();

        juegos.add(new Videojuego("Minecraft","Sandbox",9.5));
        juegos.add(new Videojuego("FIFA","Deportes",7.8));
        juegos.add(new Videojuego("GTA V","Accion",9.2));
        juegos.add(new Videojuego("Valorant","Shooter",8.4));
        juegos.add(new Videojuego("Rocket League","Deportes",8.1));

        // 1. Todos los juegos con +8 de puntuación.
        System.out.println("Juegos con más de un 8 de puntuación");

        juegos.stream()         // Recorremos la lista de videojuegos
                .filter(j -> j.getPuntuacion() > 8)  // Nos quedamos únicamente con los
                                                                // que tienen más de 8 puntos
                .forEach(System.out::println);        // Mostramos el resultado por pantalla

        System.out.println();

        // 2. Obtener una lista con los nombres de los videojuegos
        System.out.println("Lista de los nombres");

        List<String> nombresVideojuegos = juegos.stream()    // El resultado será un Stream<String>
                .map(Videojuego::getNombre)         // Transformamos cada Videojuego en su nombre
                .collect(Collectors.toList());    // Lo convertimos en una lista

        nombresVideojuegos.forEach(System.out::println);
        System.out.println();

        /* También se puede hacer

        juegos.stream()
                .map(Ejercicio1_Streams.Videojuego::getNombre)
                .forEach(System.out::println);
        */

        // 3. Puntuación media de todos los juegos

        double media = juegos.stream()
                .mapToDouble(Videojuego::getPuntuacion) // Obtenemos únicamente las puntuaciones
                .average()  // Calculamos la media
                .getAsDouble();

        System.out.println("Media de puntuaciones: " + media);

        System.out.println();
        // 4. Lista de mayor a menor puntuacion

        System.out.println("Ordenados por puntuación");
        List<Videojuego> juegosOrdenadosPorPuntuacion =
                juegos.stream()
                        .sorted((j1, j2) -> // Ordenamos de mayor a menor puntuación
                                Double.compare(
                                        j2.getPuntuacion(),
                                        j1.getPuntuacion()
                                ))
                        .collect(Collectors.toList());

        juegosOrdenadosPorPuntuacion.forEach(System.out::println);

        /*
        * Si quisieramos hacerlo del revés (de menor a mayor)

        List<Videojuego> juegosOrdenadosPorPuntuacion =
                juegos.stream()
                        .sorted((j1, j2) -> // Ordenamos de mayor a menor puntuación
                                Double.compare(
                                        j1.getPuntuacion(),
                                        j2.getPuntuacion()
                                ))
                        .collect(Collectors.toList());

          Valdría solo con comparar el 1 con el 2, totalmente del revés
        */

        System.out.println();
        // 5. Agruparlos por géneros
        Map<String,List<String>> agrupadoPorGenero =
                juegos.stream()
                        .collect(Collectors.groupingBy(
                                Videojuego::getGenero,
                                Collectors.mapping(
                                        Videojuego::getNombre,
                                        Collectors.toList()
                                )
                        ));

        System.out.println(agrupadoPorGenero);
    }
}
