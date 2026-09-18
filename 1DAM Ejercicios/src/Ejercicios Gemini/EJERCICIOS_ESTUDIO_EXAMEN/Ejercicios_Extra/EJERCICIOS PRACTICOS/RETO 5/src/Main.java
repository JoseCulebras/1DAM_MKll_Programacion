public class Main {
    public static void main (String[] args){
        PlataformaTorneo torneo = new PlataformaTorneo();

        Jugador j1 = new Jugador("J01", "Jose", 1000, "ORO", "ROCKET LEAGUE");
        Jugador j2 = new Jugador("J02", "Javi", 1200, "PLATINO", "ROCKET LEAGUE");
        Jugador j3 = new Jugador("J03", "Oscar", 1500, "DIAMANTE", "ROCKET LEAGUE");

        Jugador j4 = new Jugador("J04", "Cristian", 1000, "ORO", "VALORANT");
        Jugador j5 = new Jugador("J05", "Adrián", 2000, "DIAMANTE", "VALORANT");
        Jugador j6 = new Jugador("J06", "Juan", 1500, "PLATINO", "VALORANT");

        torneo.registrarJugador(j1);
        torneo.registrarJugador(j2);
        torneo.registrarJugador(j3);
        torneo.registrarJugador(j4);
        torneo.registrarJugador(j5);
        torneo.registrarJugador(j6);

        torneo.mostrarTopJugadoresPorJuego("ROCKET LEAGUE");

        torneo.mostrarTopJugadoresPorJuego("VALORANT");

        torneo.mostrarTopJugadoresPorJuego("LEAGUE OF LEGENDS");

        torneo.obtenerResumenTorneo();


    }
}
