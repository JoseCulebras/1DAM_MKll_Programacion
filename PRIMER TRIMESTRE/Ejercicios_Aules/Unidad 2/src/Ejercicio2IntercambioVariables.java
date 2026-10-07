public class Ejercicio2IntercambioVariables {
    public static void main (String[] args){

        System.out.println("Ejercicio 2: Programa que intercambia los valores entre tres variables distintas");
        System.out.println("================================================================================");

        int jugador1 = 25;
        int jugador2 = 40;
        int jugador3 = 15;
        int valorTemp;

        System.out.println("\nPuntuaciones iniciales: ");
        System.out.println("Jugador 1: " + jugador1);
        System.out.println("Jugador 2: " + jugador2);
        System.out.println("Jugador 3: " + jugador3);

        valorTemp = jugador1;
        jugador1 = jugador2;
        jugador2 = jugador3;
        jugador3 = valorTemp;

        System.out.println("\nPuntuaciones después de la reorganización: ");
        System.out.println("Jugador 1: " + jugador1);
        System.out.println("Jugador 2: " + jugador2);
        System.out.println("Jugador 3: " + jugador3);
    }
}
