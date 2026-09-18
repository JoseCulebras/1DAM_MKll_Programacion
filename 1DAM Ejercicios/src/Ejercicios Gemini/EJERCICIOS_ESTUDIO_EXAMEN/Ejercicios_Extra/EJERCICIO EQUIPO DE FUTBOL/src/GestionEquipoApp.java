public class GestionEquipoApp {
    public static void main(String[] args) {
        Equipo miEquipo = new Equipo("S.D. Campus Universitario");

        System.out.println("--- INICIANDO PROCESO DE INSCRIPCIÓN DE FUTBOLISTAS ---");

        // Casos de prueba usando un método auxiliar para encapsular el aislamiento del try-catch
        // Porteros
        crearYInscribirFutbolista(miEquipo, 1, "Dimitrievski", Posicion.PORTERO, 2800, 32);
        // Error por dorsal duplicado
        crearYInscribirFutbolista(miEquipo, 1, "Dimitrievski 2", Posicion.PORTERO, 2800, 32);
        crearYInscribirFutbolista(miEquipo, 2, "Andrés Fernández", Posicion.PORTERO, 2500, 39);
        // Error por cupo máximo de Porteros (Máximo es 2)
        crearYInscribirFutbolista(miEquipo, 3, "Jaume Doménech", Posicion.PORTERO, 2100, 33);

        // Defensas (Rango 2500 - 3500)
        crearYInscribirFutbolista(miEquipo, 4, "Cristhian Mosquera", Posicion.DEFENSA, 3100, 19);
        crearYInscribirFutbolista(miEquipo, 12, "Unai Elgezabal", Posicion.DEFENSA, 2900, 33);

        // Error de Salario Inválido (Excepción controlada)
        // Rüdiger cobra 14580€, el máximo de defensa es 3500€
        crearYInscribirFutbolista(miEquipo, 22, "Antonio Rüdiger", Posicion.DEFENSA, 14580, 33);

        // Este jugador debe crearse correctamente aunque el anterior haya fallado (Requisito del PDF)
        crearYInscribirFutbolista(miEquipo, 14, "José Luis Gayà", Posicion.DEFENSA, 3400, 30);

        // Visualizamos el resultado final del equipo montado
        miEquipo.mostrarPlantilla();
    }

    /**
     * Método auxiliar clave para el examen. Captura la excepción de salario inválido
     * de un jugador concreto de forma aislada, permitiendo que el flujo del programa principal continúe con el resto.
     */
    private static void crearYInscribirFutbolista(Equipo equipo, int numero, String nombre, Posicion posicion, double salario, int edad) {
        try {
            // Intentamos construir el objeto (puede lanzar excepción)
            Futbolista f = new Futbolista(numero, nombre, posicion, salario, edad);
            // Si no lanza excepción, lo agregamos al equipo (controla dorsales y máximos)
            equipo.agregarFutbolista(f);
        } catch (SalarioInvalidoException e) {
            // Captura el fallo de salario y muestra el mensaje sin romper la ejecución
            System.out.println(e.getMessage());
        }
    }
}