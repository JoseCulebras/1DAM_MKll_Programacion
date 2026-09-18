import java.util.*;

public class LeagueSystem {
    //Estructura Obligatoria: Clave (Videojuego) -> Valor (Lista de Jugadores)
    private Map<String, List<Player>> liga;

    public LeagueSystem(){
        this.liga = new HashMap<>();
    }

     /*
      * Añade un jugador al videojuego especificado.
      */
    public void addPlayer(String game, Player p){
        //Si el videojuego no existe en el mapa, creamos su lista vacía primero
        if(!liga.containsKey(game)){
            liga.put(game, new ArrayList<>());
        }

        //Recuperamos la lista de ese juego y comprobamos que el jugador no esté ya inscrito
        List<Player> jugadoresDelJuego = liga.get(game);

        if(!jugadoresDelJuego.contains(p)){
            jugadoresDelJuego.add(p);
            System.out.println("\n[SISTEMA] Jugador " + p.getNick() + " inscrito en " + game);

        }else{
            System.out.println("\n[AVISO] El jugador " + p.getNick() + " ya está en " + game);
        }
    }

    /*
     * Rellena la vitrina Varargs (el concepto de los tres puntos '...')
     */
    public void rellenarVitrinas(Player p, String... premios){
        //'premios' se comporta internamente como un array normal de Strings (String[])
        for (String premio : premios){
            p.getTrofeos().add(premio); //El Set ignora los duplicados automáticamente
        }
    }

    /*
     * Gestiona la retirada de un jugador y transfiere su legado al mejor del juego
     */
    public void transferLegacy(String game, String retiredNick){
        if(!liga.containsKey(game)){
            System.out.println("El juego especificado no existe.");
            return;
        }

        //1. Localiza la lista de jugadores del videojuego indicado
        List<Player> jugadores = liga.get(game);

        Player jugadorRetirado = null;

        //2. Buscamos al jugador que se retira con el nombre de retiredNick
        for(Player p : jugadores){
            if(p.getNick().equalsIgnoreCase(retiredNick)){
                jugadorRetirado = p;
                break;
            }
        }

        //4. Si el jugador NO existe:
        // Mandar mensaje indicando que no participa en el juego
        if(jugadorRetirado == null){
            System.out.println(retiredNick + " no participa en este juego (" + game + ")");
            return;
        }

        //Guardamos sus puntos
        int puntosATransferir = jugadorRetirado.getSkillPoints();

        // 3. Si el jugador existe:
        // Mostrar cuántos trofeos únicos tenía en su Set antes de irse
        // Elimina al jugador de la lista
        System.out.println("Jugador " + retiredNick + " eliminado");
        System.out.println("Sus trofeos eran: ");
        for(String trofeo : jugadorRetirado.getTrofeos()){
            System.out.println("- Trofeo: " + trofeo);
        }

        jugadores.remove(jugadorRetirado);

        // Si quedan jugadores, buscamos al que tiene más skillPoints usando Streams de forma elegante
        if(!jugadores.isEmpty()){
            Player heredero = jugadores.stream()
                    .max(Comparator.comparingInt(Player::getSkillPoints))
                    .get(); //Extraemos el jugador con el máximo valor

            heredero.addSkillPoints(puntosATransferir);
            System.out.println("\n[LEGADO] El mejor jugador restante es " + heredero.getNick() + ". Nuevos puntos: " + heredero.getSkillPoints());

        }else{
            // Si la lista se queda vacía, eliminamos el juego por completo del mapa
            liga.remove(game);
            System.out.println("\n[SISTEMA] No quedan jugadores en " + game + ". Videojuego eliminado de la liga.");
        }
    }

    public void showLeagues(){
        liga.forEach((juego, listaJugadores) -> {
            System.out.println("\nJuego " + juego);
            System.out.println("*************************");
            listaJugadores.forEach(p -> System.out.println("Player" + p));
        });
    }

}
