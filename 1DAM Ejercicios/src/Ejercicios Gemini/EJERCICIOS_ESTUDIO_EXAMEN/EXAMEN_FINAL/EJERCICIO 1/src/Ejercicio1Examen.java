public class Ejercicio1Examen {

    public static void main(String[] args) {

        LeagueSystem liga = new LeagueSystem();

        // --- BLOQUE 1: League of Legends ---
        Player p1 = new Player("Faker", 3500);
        Player p2 = new Player("Caps", 2800);
        Player p3 = new Player("NoobMaster69", 500);
        Player p4 = new Player("Faker", 1000000);

        liga.rellenarVitrinas(p1, "Worlds 2023", "LCK Spring", "Worlds 2023");
        liga.rellenarVitrinas(p2, "LEC Title", "MSI Champion");
        liga.rellenarVitrinas(p3, "Participación Local", "Bronce League");
        liga.rellenarVitrinas(p4, "GOAT of Java", "Best Professor 2024", "Clean Code Master");

        liga.addPlayer("League of Legends", p1);
        liga.addPlayer("League of Legends", p2);
        liga.addPlayer("League of Legends", p3);
        liga.addPlayer("League of Legends", p4);

        // --- BLOQUE 2: Valorant ---
        Player v1 = new Player("TenZ", 3200);
        Player v2 = new Player("Mixwell", 2900);

        liga.rellenarVitrinas(v1, "Masters Reykjavik");
        liga.rellenarVitrinas(v2, "G2 Invitational");

        liga.addPlayer("Valorant", v1);
        liga.addPlayer("Valorant", v2);

        // --- PRUEBA DE FUNCIONAMIENTO ---

        System.out.println("\n[SISTEMA] Procesando retirada de: James...");
        liga.transferLegacy("League of Legends", "James");

        System.out.println("\n[SISTEMA] Procesando retirada de: Faker...");
        liga.transferLegacy("League of Legends", "Faker");

        System.out.println("\n=== ESTADO DE LA LIGA TRAS EL LEGADO ===");
        liga.showLeagues();
    }
}
