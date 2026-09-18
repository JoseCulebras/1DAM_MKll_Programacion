import java.util.HashMap;
import java.util.Map;

public class Equipo {
    private String nombreEquipo;

    // Almacenamos los futbolistas en un Map usando el dorsal (numero) como clave.
    // Esto garantiza que no pueda haber dos números iguales en el equipo de forma nativa.
    private Map<Integer, Futbolista> plantilla;

    // Estructura Map estática para definir los límites máximos por posición
    private static final Map<Posicion, Integer> MAX_FUTBOLISTAS_POSICION = new HashMap<>();

    // Inicializador estático para configurar las reglas de tope de jugadores
    static {
        MAX_FUTBOLISTAS_POSICION.put(Posicion.PORTERO, 2);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.DEFENSA, 5);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.CENTROCAMPISTA, 5); // Suponemos 5 según la media habitual
        MAX_FUTBOLISTAS_POSICION.put(Posicion.DELANTERO, 4);      // Suponemos 4
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.plantilla = new HashMap<>();
    }

    /**
     * Intenta añadir un futbolista al equipo controlando duplicados de dorsal y topes por posición
     */
    public void agregarFutbolista(Futbolista f) {
        // 1. Control de Dorsal duplicado
        if (plantilla.containsKey(f.getNumero())) {
            System.out.println("[ERROR] No se pudo añadir a " + f.getNombre() + ". El dorsal " + f.getNumero() + " ya está ocupado.");
            return;
        }

        // 2. Control de máximo por posición
        Posicion pos = f.getPosicion();
        long totalEnPosicion = plantilla.values().stream()
                .filter(jugador -> jugador.getPosicion() == pos)
                .count();

        int maxPermitido = MAX_FUTBOLISTAS_POSICION.getOrDefault(pos, Integer.MAX_VALUE);

        if (totalEnPosicion >= maxPermitido) {
            System.out.println("[ERROR] No se pudo añadir a " + f.getNombre() + ". Cupo máximo de " + pos + "s alcanzado (" + maxPermitido + ").");
            return;
        }

        // Si supera todos los filtros, se mete en la plantilla con éxito
        plantilla.put(f.getNumero(), f);
        System.out.println("[SISTEMA] -> " + f.getNombre() + " incorporado con éxito al equipo.");
    }

    public void mostrarPlantilla() {
        System.out.println("\n========================================================");
        System.out.println("PLANTILLA DEL EQUIPO: " + nombreEquipo.toUpperCase());
        System.out.println("========================================================");
        if (plantilla.isEmpty()) {
            System.out.println("El equipo no tiene jugadores inscritos.");
        } else {
            // Mostramos los jugadores ordenados por Dorsal de forma limpia
//            plantilla.values().stream()
//                    . someSortMethodOrJustForEach(System.out::println);
        }
    }
}