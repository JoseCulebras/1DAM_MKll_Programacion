import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {
    private String nick;
    private int skillPoints;
    //Colección de trofeos
    //Usamos un HasSet porque el enunciado exige explícitamente que no se repitan trofeos
    private Set<String> trofeos;

    //Restricción: Solo existe un constructor con el Nick y los skillPoints
    public Player(String nick, int skillPoints){
        this.nick = nick;
        this.skillPoints = skillPoints;
        this.trofeos = new HashSet<>();//Inicializamos el conjunto vacío
    }

    //Métodos estríctamente permitidos por el enunciado
    public Set<String> getTrofeos(){
        return this.trofeos;
    }

    public String getNick(){ return this.nick; }

    public int getSkillPoints(){
        return this.skillPoints;
    }

    public void addSkillPoints(int points){
        this.skillPoints += points;
    }

    @Override
    public String toString(){
        return "{nick='" + getNick() + "', skillPoints=" + getSkillPoints() + ", trofeos=" + getTrofeos() + "}";
    }

    //Sobrescribimos equals y hasCode para que el sistema reconozca si un jugador es el mismo por su Nick
    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(nick, player.nick);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nick);
    }
}
