import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coche {
    private String matricula;
    private int kilometraje;
    private Set<String> historialAverias;

    public Coche(String matricula, int kilometraje){
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.historialAverias = new HashSet<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Set<String> getHistorialAverias(){
        return this.historialAverias;
    }

    @Override
    public String toString(){
        return "Matrícula: " + getMatricula() + " | Kilometraje: " + getKilometraje() + " | Historial de averías: " + getHistorialAverias();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){return true;}

        if(o == null || getClass() != o.getClass()){return false;}

        Coche coche = (Coche) o;

        return Objects.equals(matricula, coche.matricula);
    }

    @Override
    public int hashCode(){
        return Objects.hash(matricula);
    }
}
