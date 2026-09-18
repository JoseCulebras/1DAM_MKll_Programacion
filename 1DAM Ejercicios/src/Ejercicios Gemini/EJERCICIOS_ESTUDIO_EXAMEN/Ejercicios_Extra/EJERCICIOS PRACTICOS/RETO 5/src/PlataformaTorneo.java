import java.util.*;

public class PlataformaTorneo {
    Map<String, List<Jugador>> inscritosPorJuego;

    public PlataformaTorneo(){
        this.inscritosPorJuego = new HashMap<>();
    }

    public void registrarJugador(Jugador jugador){
        inscritosPorJuego.computeIfAbsent(jugador.getVideojuego(), k -> new ArrayList<>()).add(jugador);
    }

    public void mostrarTopJugadoresPorJuego(String juego){
        List<Jugador> jugadores = inscritosPorJuego.get(juego);

        if(jugadores == null || jugadores.isEmpty()){
            System.out.println("[AVISO] No hay jugadores registrados en el videojuego: " + juego);
            return;
        }

        System.out.println("\n=== JUGADORES DE " + juego + " CON RANGO PLATINO Y DIAMANTE ===");
        jugadores.stream()
                .filter(j -> !(j.getRango().equals("ORO")))
                .sorted(Comparator.comparingInt(Jugador :: getPuntosCompetitivos).reversed())
                .forEach(System.out::println);
    }

    public void obtenerResumenTorneo(){
        if(inscritosPorJuego.isEmpty()){
            System.out.println("\n[AVISO] El torneo no tiene jugadores inscritos.");
            return;
        }

        System.out.println("\n=== RESUMEN DEL TORNEO ===");
        inscritosPorJuego.forEach((videojuego, listaDeJugadores) -> {

            int puntosMaximos = listaDeJugadores.stream()
                    .mapToInt(Jugador :: getPuntosCompetitivos)
                    .max()
                    .orElse(0);


            System.out.println("\nNombre del videojuego: " + videojuego);
            System.out.println("  - Cantidad de jugadores inscritos: " + listaDeJugadores.size());
            System.out.println("  - Puntos competitivos máximos de esta categoría: " + puntosMaximos);
        });
    }
}
