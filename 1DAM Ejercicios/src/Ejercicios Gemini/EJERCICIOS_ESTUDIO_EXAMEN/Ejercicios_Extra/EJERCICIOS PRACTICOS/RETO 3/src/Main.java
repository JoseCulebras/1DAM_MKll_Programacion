import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){
        List<Personaje> party = new ArrayList<>();
        // Se instancia la clase
        GestorGuardado gestorGuardado = new GestorGuardado();

        // Al guerrero le ponemos 10 de armadura para que el impacto de 15 le quite solo 5 de vida
        Personaje p1 = new Guerrero(10, "Jose", 1, 100);
        Personaje p2 = new Mago("Andrea", 1, 50, 100);

        party.add(p1);
        party.add(p2);

        System.out.println("\n=== ¡UN ENEMIGO EMBOSCA AL GRUPO! ===");
        for(Personaje personaje : party){
            personaje.recibirDanio(15);
        }

        // Guardamos el estado actual (Guerrero con 95 de vida, Mago con 35 de vida)
        gestorGuardado.guardarPartida(party, "partida.dat");

        System.out.println("\n=== BORRANDO MEMORIA ===");
        party.clear();
        System.out.println("Tamaño de la party actual: " + party.size()); // Saldrá 0

        System.out.println("\n=== CARGANDO PARTIDA ===");
        // CORREGIDO: Asignamos el retorno del metodo a nuestra lista
        party = gestorGuardado.cargarPartida("partida.dat");


        System.out.println("\n=== LISTA DE PERSONAJES CARGADOS===");
        party.forEach(p -> System.out.println(p));
    }
}
