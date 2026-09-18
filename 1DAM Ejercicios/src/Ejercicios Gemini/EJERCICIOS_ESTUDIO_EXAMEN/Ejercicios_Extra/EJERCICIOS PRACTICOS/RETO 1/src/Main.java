public class Main {
    public static void main (String[] args){

        Aeropuerto gestionVuelos = new Aeropuerto();

        // Abriendo líneas aéreas
        gestionVuelos.abrirVuelo("VO1", "Paris");
        gestionVuelos.abrirVuelo("VO2", "Roma");

        // Creamos pasajeros de prueba (Dos de ellos tienen el mismo DNI a propósito)
        Pasajero p1 = new Pasajero("21797976W", "Jose", "01A");
        Pasajero p2 = new Pasajero("12345678A", "Juan", "01B");
        Pasajero p3 = new Pasajero("87654321B", "Andrea", "02C");
        Pasajero p4 = new Pasajero("21797976W", "Yose", "01F"); // Mismo DNI que pas1

        System.out.println("=== INICIANDO PROCESO DE EMBARQUE ===");
        try{
            // Caso 1: Embarque correcto (Intentamos meter 4, pero registrará 3 por el duplicado)
            gestionVuelos.embarcarPasajeros("VO1", p1, p2, p3, p4);
            System.out.println("[SISTEMA] Embarque en VO1 completado");

            // Caso 2: Forzamos la excepción con un código de vuelo que no existe
            gestionVuelos.embarcarPasajeros("VO99", p1);

        } catch (VueloNoEncontradoException e){
            // Capturamos el error y evitamos que el programa se rompa
            System.out.println(e.getMessage());
        }

        // Exportamos las estadísticas al fichero de texto
        gestionVuelos.exportarVuelosLlenos();
    }
}
